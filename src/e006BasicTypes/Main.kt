package e006BasicTypes

fun main() {
    fun printAllStrings(vararg strings: String) {
        for (string in strings) {
            print("$string ")
        }
        println()
    }
    // "*" spread operator deniyor
    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", *lettersArray)

    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(1, 2, 3)

    // arraylerde == referans kontrolu yapar
    println(array1 == array2)
    println(array1.contentEquals(array2))
    // cok boyutlu arraylerde contentDeepEquals kullanilir

    // sonlu sayili liste olusturmaya yarar
    val numbers = 1..100
    val numbers2 = 1.rangeTo(100)

    // a'kadar
    val numbers3 = 1..<100
    val numbers4 = 1.rangeUntil(100)

    // tersten
    val numbers6 = 100 downTo 1

    // aralikli 1, 3, 5...
    val steppedNumbers = 1..100 step 2

    // charlarla
    val alphabet = 'a'..'z'
}