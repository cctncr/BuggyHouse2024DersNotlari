package n015AbstractOpenInterface

class EventManager
// kendinden open ve final olamaz
// nesnesi olusturulamamasina ragmen constructor yazilmasinin sebebi inject etmemiz gereken baska bir class varsa onu
// verebilmek icin
abstract class Human(val name: String, eventManager: EventManager) {
    // abstract property'lere initial deger veremeyiz
    abstract val surName: String // = "Default Value" yapamayiz
    open val age: Int = 20
    // abstract class'lar state tutabilir
    val eyeColor: String = "blue"
    open fun display() {
    }
    abstract fun run()
    constructor(name: String, age: Int, eventManager: EventManager) : this(name, eventManager) {
    }
}

// abstract class abstract miras aliyorsa member'lari implement etmek zorunda degil cunku miras alan abstract olmayan
// baska class diger ust class'larin abstract member'larini da implement etmek zorunda
abstract class Turk(name: String, age: Int, eventManager: EventManager) : Human(name, age, eventManager) {
    abstract val skinColor: String
    override val surName: String = ""
}

class Izmirli(name: String, age: Int, eventManager: EventManager) : Turk(name, age, eventManager) {
    override val skinColor: String
        get() = TODO("Not yet implemented")
    // Turk class'inda override edildigi icin override etme zorunlulugu kalkmis oldu ama yine de override edilebilir
    // eger kesinlikle child class'da override edilmesin istedeydik surName'i Turk class'inda final yapabilirdik
    // override val surName: String
        // get() = TODO("Not yet implemented")
    override fun run() {
        TODO("Not yet implemented")
    }
}

fun main() {
    // abstract class'larin nesnesi olusturulamaz
    // val human = Human("Human")
}