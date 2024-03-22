package g008LoopsFunctions

import kotlin.time.measureTime

fun main() {
    /*
        value in list
        index in list.indices
        (index, value) in list.withIndex()
     */

    for (value in 1..10) { // value in IntRange
        print("$value ")
    }
    println()

    val countryCodeArray = arrayOf("tr", "az", "en", "fr")
    for (index in countryCodeArray.indices) {
        print("$index value: ${countryCodeArray[index]} - ")
    }
    println()

    val alphabet = 'a'..'z'
    //destructing declaration
    for ((index, value) in alphabet.withIndex()) {
        println("$index. harf: $value")
    }

    println("continue:")
    for (value in 1..50) {
        if (value % 2 == 1) {
            continue // donguyu atlatiyor
        }
        print("$value ")
    }
    println()

    println("break:")
    for (value in 1..50) {
        if (value % 2 == 0) {
            break
        }
        print("$value")
    }
    println()

    // label kullanimi
    mainLoop@for (value in 1..50) {
        println("main loop value: $value")
        for (value2 in 1..50) {
            println("inner loop value: $value2")
            if (value2 == 5) {
                break@mainLoop
            }
        }
    }

    // for if olarak calisir
    var number = 0
    while (number < 5) {
        print("${number++} ")
    }
    println()

    for (value in 0..100) {
        if (value < 5) {
            print("$value ")
        } else {
            break
        }
    }
    println()

    // Fonksiyonlar
    // eger fonksiyon static'se () olmadan, degilse nesnesini olusturularak ismiyle cagirilir
    Math.pow(2.0, 1.2)

    // default argument
    fun takeSquare(number: Int = 2): Int {
        return number * number
    }
    // fonksiyon overload yapar
    takeSquare(5) // 5 * 5
    takeSquare() // 2 * 2

    // name argument
    // parametrelerin sirasini degistirerek yazmamizi saglar
    takeSquare(number = 10)

    // vararg yazarken eger tekse ya da sonda yazildiysa "String..." gibi donusturulur ortaday veya bastaysa Array'e
    // donusturulur. bu ufak performans farki yaratir
    fun getUserInfo1(vararg userInfo: String, key :Int) {
        return println(userInfo[0])
    }

    fun getUserInfo2(key: Int, vararg userInfo: String) {
        return println(userInfo[0])
    }
}