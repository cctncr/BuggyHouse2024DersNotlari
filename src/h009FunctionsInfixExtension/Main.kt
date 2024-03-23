package h009FunctionsInfixExtension

fun main() {
    /*
        infix fonksiyonlar
        daha okunakli kodlar yazmak icin kullanilir
        infix keyword'u ile baslar
        member function olmalidir
        ya da bir extension function olmalidir
        sadece bir parametre almalidir. Bu parametre vararg olamaz
        infix fonksiyonun parametresi default deger alamaz
     */

    // infix fun infixFunction(justOneParam: AwesomeParam) : Whatever { }
    infix fun Int.awesomePlus(other: Int): Int {
        return this + other
    }
    val number = 3
    println(number + number - 2 * (3.awesomePlus(4)))

    /*
        siralama:
        matematiksel operatorler
        tip donusumleri
        range kullanimi
        mantik operatorleri
     */

    /*
        top level degil de local yazilmis fonksiyonlar reflection dahil yazildigi fonksiyonun disindan erisilemezler.
        mesela sdk yazarken ya da guvenlikle alakali durumlarda bu ise yarayabilir.
     */

    // generic function
    fun <T> setColor(colorCodeId: T) {

    }

    /*
        extension functions

        read-only siniflara, ya da degisiklik yapmak istemedigimiz siniflara fonksiyon yazmak icin kullaniriz
        class'in member fonksiyonu olmuyor java tarafinda disaridan bir ve kendisi olmak uzere 2 parametre alan
        static final function olarak yazilir
     */

    fun String.addNumber(number: Number): String {
        return this + number
    }

    10.0.log()

    /*
    val shape = Shape()
    shape.size = 10
    println(shape.size)

    stackOverFlow hatasi aliriz
    get() size'i cagirir, size'da get()'i cagirir
     */

}
fun Number.log() {
    println("${this.javaClass.simpleName} number: $this")
}
class Shape

// ayni extension function gibi extension property de yazabilir ama backing field'i olmaz
var Shape.size: Int
    get() = size
    set(value) {
        size = value
    }