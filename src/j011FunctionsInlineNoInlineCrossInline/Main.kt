package j011FunctionsInlineNoInlineCrossInline

fun main() {
    TODO("ders 11 tekrar")
    runAndPrint("message", ::print)
}

// arka planda higher order functionlara parametre olarak girilen fonksiyonlarin instance'i olusturulur
// eger inline kullanilirse body gomerek bunun onune gecer ve performans artisi saglar (ozellikle tekrarli cagrimlardsa)
// ama body buyukse eger derlenme suresini arttirabilir
inline fun runAndPrint(str: String, print: (String) -> Unit) {
    print(str)
}

// noinline paramatre bekleyen 
fun log(str: String) {
    println(str)
}

fun log(logger: (String) -> Unit) {
    logger("Start")
}
inline fun runAndPrint(run: (String) -> Unit, noinline logger: (String) -> Unit) {
    log(logger) // kaldirirsak illegal usage olur
    run("Message")
    logger("End")
}