package p017EnumSealedClasses

interface SomeInterface {
    fun interfaceGoo()
}

// kumelenebilir veri gruplari icin kullanilir
/*
    class miras alamaz ve alinamaz ama interface implement edebilir. eger implement edilen interface'in body'siz bir fonksiyonu
    varsa ve eger enum class icinde override edilmediyse ayri ayri enum sabitleri icerisinde override edilmek zorundadir
    nesnesi uretilemiyor cunku primary constructor mecburi olarak private degistirilemiyor
    secondary constructor, companion object, fonksiyon, abstract fonksiyon, open fonksiyon yazilabilir
    direkt olarak enum sabitlerinin icine property yazamiyoruz
    eger enum class'i primary constructor'inda bir property'e sahipse tum enum sabitleri constructor'inda bu property'e
    sahip olmak zorundalar
    sabitler tek baslarina bir class'i miras alamazlar ya da bir interface'i implement edemezler
    Any class'indan gelen toString fonksiyonunu sabitlerde ve enum class'da override edilebilir
    enum sabitinin name attribute'u direkt kendi class ismini verir, ordinal ise enum class icinde kacinci sirada
    oldugunu verir
    enum class'i icindeki duz fonksiyonlara disaridan erisilemez cunku enum class'inin instance'si olusturulamaz, enum
    sabitleri kullansin diye varlar
 */
final enum class Team private constructor(val starCount: Int) : SomeInterface {
    FENERBAHCE(3) {
        override fun interfaceGoo() {
            TODO("Not yet implemented")
        }

        override fun toString(): String {
            return super.toString()
        }

        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    GALATASARAY(4) {
        override fun interfaceGoo() {
            TODO("Not yet implemented")
        }

        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    BESIKTAS(3) {
        override fun interfaceGoo() {
            TODO("Not yet implemented")
        }

        override fun boo() {
            TODO("Not yet implemented")
        }

        override fun zoo() {
            super.zoo()
        }


    };
    fun foo() {

    }

    abstract override fun interfaceGoo()

    init {

    }

    constructor(value: Int, type: String) : this(value) {

    }

    companion object {

    }

    abstract fun boo()

    open fun zoo() {

    }

    override fun toString(): String {
        return super.toString()
    }
}

fun main() {
    val besiktas = Team.BESIKTAS
    println("star count: " + besiktas.starCount)
    println("name: " + besiktas.name)
    println("ordinal: " + besiktas.ordinal)
    for ((index, value) in Team.entries.withIndex()) {
        println("$index: $value")
    }
    Team.values() // entries gibi ama array doner list yerine
    Team.valueOf("BESIKTAS").let(::println)
    Team.FENERBAHCE.foo()
}