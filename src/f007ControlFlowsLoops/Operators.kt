package f007ControlFlowsLoops

fun main() {
    var number = 10

    println(number)
    println(number++) // once islemi yapip sonra degerini arttirir
    println(number)
    println(++number) // once degerini arttirir sonra islemi yapar
    println(number)

    val numberOne = 10
    val numberTwo = 6

    println("---------------------------------------------------")
    // toplama islemi
    print("${numberOne + numberTwo} ")
    println(numberOne.plus(numberTwo))

    // cikarma islemi
    print("${numberOne - numberTwo} ")
    println(numberOne.minus(numberTwo))

    // carpma islemi
    print("${numberOne * numberTwo} ")
    println(numberOne.times(numberTwo))

    // bolme islemi
    print("${numberOne / numberTwo} ")
    println(numberOne.div(numberTwo))

    // bolumden kalan
    print("${numberOne % numberTwo} ")
    println(numberOne.rem(numberTwo))
    println("---------------------------------------------------")

    print("Final notunu giriniz :")
    val grade = readln().toInt()
    val charNote = if (grade == 100) {
        "AA"
    } else if (grade <= 99 && grade >= 80) {
        "BB"
    } else if (grade <= 79 && grade >= 50) {
        "CC"
    } else if (grade <= 49 && grade >= 20) {
        "DD"
    } else if (grade <= 19 && grade >= 0) {
        "FF"
    } else {
        "ERROR"
    }
    println("char note = $charNote")

    // eger grade 100'den kucukse -1 doner
    // eger grade 100'e esitse 0  doner
    // eger grade 100'den buyukse 1 doner
    println(grade.compareTo(100))
    println("---------------------------------------------------")

    var a = -10
    val b = 20
    val flag = true
    a += 5 // a = a + 5 anlamina gelir diger aritmetik operatorlerle de calisir
    // "${a += 20}" String template'de atama islemi yapamayiz

    println(a.unaryPlus()) // +.-5 = -5
    println(a.unaryMinus()) // -.-5 = +5
    println(!flag) // true -> false

    /*
        +a     a.unaryPlus()
        -a     a.unaryMinus()
        ++a    a.inc()
        --a    a.dec()
        !flag flag.not()
     */
}