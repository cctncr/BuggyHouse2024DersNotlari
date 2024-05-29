package u021ScoopeFunctionsDelegation

/*
    Kod bloklarini gruplamak icin kullanilirlar
    Ozunde 5 tane scoope function var ama run'in iki kullanimi var:
    let
    run
    with
    apply
    also
    Teknik olarak birbirleri yerine kullanilabilirler ama dogrusu bu degildir
 */

/*
    Hangisini kullanacigini secerken:
    1- receiver uzerinde bir manipulasyon olucak mi olucaksa apply ya da also kullanmak lazim cunku context'i donuyor

 */

val name: String? = "str"

/*
public inline fun <T, R> T.let(block: (T) -> R): R { return block(this) }
T : Context (name?)
R : son satir (2) geri donus degeri
Lambda param : T, this yok cunku extension yok
 */
val letReturnValue: Int? = name?.let {
    println("let - $it")
    2
}

/*
public inline fun <T, R> T.run(block: T.() -> R): R { return block() }
T : Context (name?)
R : son satir ("String") geri donus degeri
Lambda Param : Yok, this = T cunku extension function
 */
val runReturnValue: String? = name?.run {
    println("run - $this")
    "String"
}

/*
public inline fun <R> run(block: () -> R): R { return block() }
T : Yok, extension yok
R : son satir (true)
Lambda Param : Yok, this yok cunku extension yok
 */
val run2ReturnValue: Boolean = run {
    println("run")
    true
}

/*
public inline fun <T, R> with(receiver: T, block: T.() -> R): R { return receiver.block() }
T : Fonksiyonun fonksiyon olmayan degisken olan parametresi, yani 1. parametresi. extension yok
R : son satir (Array<Int>)
Lambda param : yok
 */
val withReturnValue: Array<*> = with(name) {
    println("with - $this")
    arrayOfNulls<Int>(4)
}

/*
public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
T : Context (name?)
R : Yok, cunku higher order function'in geri donus tipi yok onun yerine Context donuyor (T)
Lambda param : yok, this = T cunku extension function
 */
val applyReturnValue: String? = name?.apply {
    println("apply - $this")
}

/*
public inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }
T : Context (name?)
R : Yok, cunku higher order function'in geri donus tipi yok onun yerine Context donuyor (T)
Lambda param : T, this yok cunku extension yok
 */
val alsoReturnValue: String? = name?.also {
    println("also - $it")
}

data class Person(val name: String, val age: Int) {
    var job = ""
}

class Student {
    var age = 0
    var name: String = ""
}

fun main() {
    // builder pattern kullaniyormus gibi genelde nesne olusturma islemleri icin kullanilir
    var student: Student? = Student().apply {
        age = 23
        name = "Can"
    }

    // data classlarda nesne olusturuluyorsa also kullanmak daha dogru olur
    val person = Person("Dmitry", 30).also {
        it.job = "Mechanic"
    }

    // let genelde null check icin kullanilir ve karsisina run block'u gelebilir bu sekilde dikkat edilmesi gerekn sey
    // run block'u bu ornekte tam olarak student'e bakmaz let block'unun son satiri null ise run calisir
    val value: Int = student?.let {
        5
        // null
    } ?: run {
        4
    }
    println(value)

    // ayni seyi also ile yaptigimizda also bize context'i yani bu ornekte student?'i donecegi icin daha dogru bir elvis
    // kullanimi yapmis oluruz fakat value2 type'i Any olur cunku student?'da donebilir 4'de o yuzden atama yapmiyorken
    // kullanmamiz lazim
    val value2: Any = student?.also {
        5
    } ?: run {
        4
    }
    println(value2)
    // Ozet olarak degiskenin kendisini elvis operatorune vermek istiyorsak let run degil also run kullanmak daha dogru

    // expression olmayan run'i gruplama yapmak isteyip fonksiyonlara ayirmak istemedigimizde kullaniriz
    run {

    }

    // with'i nullable olmayan sabit bir degisken varsa kullanabiliriz
    with(value) {

    }

    /*
        Ozet:
        Nesne oluşturma işlemi için apply, also. Eğer elimizde oluşturulmuş bi nesne varsa bu nesne nullable değilse
        with null gelme ihtimali var expression da yapıyosak let run kullanmamız lazım.
     */

    // https://blog.mindorks.com/using-scoped-functions-in-kotlin-let-run-with-also-apply/
}