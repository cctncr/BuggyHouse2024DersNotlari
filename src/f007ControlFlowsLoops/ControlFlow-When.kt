package f007ControlFlowsLoops

fun main() {
    val countryCode = readln()
    println(
        when (countryCode) {
            "tr", "az" -> "TC Vatandasi"
            "fr" -> "France Vatandasi"
            "ru" -> "Russian Vatandasi"
            else -> "Bulunamadi"
        }
    )

    val number = 10
    when (number) {
        is Int -> {
            println("Integer")
        }

        !is Int -> {
            println("Integer degil")
        }
    }

    when (number) {
        in 0..100 -> {
            println("0 ile 100 arasinda")
        }

        !in 0..100 -> {
            println("0 ile 100 arasinda degil")
        }
    }

}