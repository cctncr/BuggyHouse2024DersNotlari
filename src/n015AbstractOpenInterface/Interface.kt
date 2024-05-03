package n015AbstractOpenInterface
// INTERFACE'LER STATE TUTAMAZLAR, TUTMAMALILAR, show icin hacky yontemler var

// interface'lerin constructor'i olamaz
interface TextWatcher {
    abstract fun onTextChanged()
    fun beforeTextChanged()
    fun afterTextChanged()
    // body'si olan fonksiyonun override etme zorunlulugu kalkar
    // cunku arka planda static bir class ve member tanimlar interface icinde DefaultImpls
    open fun funWithBody() {

    }

    // arka planda Companion diye static final class olusturur ve icine member tanimlar ayni funWithBody
    companion object {
        val name: String = "Can"
    }
}

interface ChildInterface : TextWatcher {
    // abstract class'larda oldugu gibi super interfacenin member'larini override etme zorunlulugu yok
    // yine abstract class'ta oldugu gibi memberler implement edildiyse concrete class'da override etme zorunlulugu yok
    // ama abstract class'lardaki gibi final veremiyoruz
    override fun onTextChanged() {}
    override fun afterTextChanged() {}
}

// abstract class interface'i implement ediyorsa override etme zorunlulugu yok
abstract class A : ChildInterface, TextWatcher {

}

fun main() {
    // val textWatcher = TextWatcher() bu sekilde nesnesi olusturulamaz
    val textWatcher = object : TextWatcher {
        override fun onTextChanged() {
            TODO("Not yet implemented")
        }

        override fun beforeTextChanged() {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged() {
            TODO("Not yet implemented")
        }
    }

    val childInterface = object : ChildInterface {
        override fun beforeTextChanged() {
            TODO("Not yet implemented")
        }
        // ChildInterface'de implement edildigi icin digerlerinin override edilme zorunlulugu yok
    }
}