package i010FunctionsHigherOrderFunctions

import java.lang.Integer.sum


fun main() {
    /*
        first class citizen olma sartlari:
        bir degiskene atanabilme
        bir fonksiyonun parametresi olarak verilebilme
        bir fonksiyonun geri donus tipi olabilme

        kotlinde functions'lar first class citizen
     */

    /*
        bir fonksiyona parametre olarak bir fonksiyon veriyorsak
        bir fonksiyonun geri donus tipini bir fonksiyon olarak veriyorsak
        bu fonksion higher order fonksiyon olur
     */

    /*
        kullanim yerleri:

        geriye donuk haberlesme yapmak istiyorsak
        fonksiyon call edildigi yere bilgi tasimasi isteniyorsa
        eskiden interface kullaniliyordu simdi higher order tercih ediliyor
     */
    fun calculateAndPrint(numberOne: Int, numberTwo: Int, operation: (Int, Int) -> Int): Int {
        val result = operation(numberOne, numberTwo)
        println(result)
        return  result
    }
    calculateAndPrint(10, 20) { numberOne, numberTwo ->
        sum(numberOne, numberTwo)
    }
    calculateAndPrint(4, 8, ::sum)

    // 1. yontem degiskene atamak
    val test: (String) -> Int = { name ->
        name.length
    }

    // 2. yontem anonymous function
    val anonymousFunction = fun(surname: String): String {
        return "surname: $surname"
    }

    // 3. yontem normal function ::function kullanimi
    fun sum(numberOne: Int, numberTwo: Int): Int = numberOne + numberTwo
    calculateAndPrint(8, 2, ::sum)

    // fonksiyon alan fonksiyon parametresine de default deger verebiliriz
    fun calculate(number1: Int, number2: Int, operation: (Int, Int) -> Int = ::sum): Int {
        return operation(number1, number2)
    }
    println(calculate(2, 4))
}

