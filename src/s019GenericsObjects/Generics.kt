package s019GenericsObjects

// Invariant: Generic type'lar tek basina kullanildigi durumda sadece arayuzde belirtilen type neyse sadece o type'in
// degiskenlerini kabul eder child ya da super type'lari kabul edemez
// out kullanimi: kendisini ve child class'larini super (ust) type'lara atayabilmemizi sagliyor co-variant
// in kullanimi: kendisini ve super class'larini child type'lara atayabilmemizi sagliyor contra-variant

// Function<*, String> ifadesi Function<in Nothing, String> olur.
// Function<Int, *> ifadesi Function<Int, out Any?> olur
data class Box<T>(val item: T)

fun Box<*>.printBox() {
    val item = this.item
    println(item)
}

inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return Pair(this.first as A, this.second as B)
}

// Ozunde Consumer in, Producer out

// covariant
// burada Source T producer oluyor consumer olmuyor
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
    // ...
}

// contravariant
// burada Comparable consumer oluyor producer olmuyor
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}

// Star-projections
/*
    Function<*, String> -> Function<in Nothing, String>
    Function<Int, *> -> Function<Int, out Any?>
    Function<in Nothing, out Any?>
 */


fun <T> T.basicToString(): String { // extension function
    when (this) {
        is String -> return this
        is Number -> return "$this"
        is Box<*> -> return this.item.toString()
        else -> return "can't"
    }
}

// Comparable<T> burada upper bound. eger explicitly olarak yazilazsa Any? olur
fun <T : Comparable<T>> sort(list: List<T>) { }

// eger birden fazla upper bound gerekliyse where keyword'u ile yapilabilir cunku bir <> icine bir upper bound yazilir
// buarada T hem CharSequence hem de Comparable implement etmek zorundadir
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

// Java'nin @NotNull annotation'u ile calisabilmesi adina kesinlikle null olmayan generic type'lar yazmak icin (& Any)
// kullanabiliriz
interface ArcadeGame<T> {
    fun save(x: T): T
    // T1 is definitely non-nullable
    fun load(x: T & Any): T & Any
}

// Type erasure
/*
    kotlinde compile-time'da type-safety ozelligi generic kullanimlari denetlerken run-time'da generic yapilar
    kaldirilir ve yerlerine ust ve alt sinirlar getirilir mesela Foo<Bar> ve Foo<Baz?> Foo<*> olabilir.
 */

fun main() {
    val box = Box<String>("test")
    box.printBox()
    val pair = Pair<Int, String>(20, "str")
    pair.asPairOf<Int, String>().also { println(it) }
    box.basicToString().also { println(it) }
}

/*
    Sorular:
    1- Neden generic type'lari kullaniyoruz da Any'i kullanmiyoruz
    2- invariant, covariant, contravariant ne demek
    3- star projection
    4- reified keyword'u ne ise yarar (type erasure)
 */