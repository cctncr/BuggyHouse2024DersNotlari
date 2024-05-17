package s019GenericsObjects

// arka planda java'dakini yapiyor
object RetrofitKotlin {
    var baseUrl = "www.github.com"
}

/*
    object'in uc farkli kullanimi vardir:
    expression kullanimi, buurada singleton static'lik falan yok
    declaration (state) (singleton) kullanimi
    companion kullanimi
*/

interface TextWatcher {
    fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
    fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
    fun afterTextChanged(s: String?)
}

interface TextWatcherInterface : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    override fun afterTextChanged(s: String?) {}
}

open class TextWatcherClass : TextWatcherInterface {
    override fun afterTextChanged(s: String?) {}
}

class A {
    val age: Int = 23
    // burada multi inheritance var hem A class'indan age'i hem de TextWatcherClass'inin fonksiyonlarini aldi
    // arka planda anonymous class olustu, kullan at class'lar
    val obj = object : TextWatcherClass() {
        override fun afterTextChanged(s: String?) {
            super.afterTextChanged(s)
        }
        fun getAge() = age
    }
}

fun main() {
    val baseUrl = RetrofitKotlin.baseUrl
    val name = "Can"
    val textWatcher = object : TextWatcherClass() {
        override fun afterTextChanged(s: String?) {
            super.afterTextChanged(s)
        }
        fun doSomething() {
            name.let(::println)
            baseUrl.let(::println)
        }
    }
    textWatcher.doSomething()
}

