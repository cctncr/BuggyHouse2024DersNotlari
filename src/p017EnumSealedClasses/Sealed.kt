package p017EnumSealedClasses

// kisitlanmis bir sinif hiyerarsisini developerin keyfiyetinden cikarip ide'nin kontrolune vermek
/*
    sealed class'lar baska bir clasi miras alabilir. open abstract sealed farketmez
    interface taniminda bir problem yoktur eger body'siz fonksiyon varsa subclass'lar onu override etmek zorunda
    initi ve constructor'u olmasina ragmen direkt olarak nesnesi uretilemez.
    primary constructor'i default olarak private degil protected'dir.
    primary constructor'da tanimlanan property ister sabit olarak ister subclasslarda
    eger constructor'i private'a cekerseniz subclass'larin bu class scoop'u disinda miras alinmasini engellemis
    olursunuz bu da ozellikle daha kisitli bir hiyerarsi kurmak istediginizde kutuphane kullanimlarinda (closed api)
    onemlidir
    compile time'da subclass'lari belli oldugu icin when icinde else case'ine ihtiyac duymazlar type safety sunar
    direct subclass'larin constructor'inda sealed class'tan bagimsiz propertyler tanimlanabilir, interface implement
    edilebilir
    direct subclass'lar enum class haricinde (enum classlar class miras alamaz, direct subclass'lar acik bir sekilde
    sealed class'i miras almalidirlar) diger class turleri olabilir: sealed inner data abstract
    arkaplanda sealed class abstract class olarak tutulur
    direct class'larin birden fazla nesnesi olusturulabilir, enum class entry'leri tek bir nesne olarak memory'de
    tutulurlar. direct classlar ozunde static degildir (sealed class scoop'u icinde tanimlanirlarsa static olurlar) bu
    yuzden nesneleri olusturulmasi gerekmektedir
    sealed class'lar ayni module veya package icinde gecerlidir farkli moduller tarafindan gorulemezler
    sealed class'larin direct class'lari compile time'da biliniyor boylece when expression'da else case'i gerekmiyor
    sealed class icinde sadece object kullanimlari varsa sealed yerine enum yapmak daha mantikli
 */

open class A
sealed class Errors protected constructor(errorCode: Int) : A(), B {
    abstract class NoInternetError public constructor(): Errors(100) {
        override fun abstractFun() {
            TODO("Not yet implemented")
        }

        override fun someFunction() {
            TODO("Not yet implemented")
        }

        abstract fun specialFun()
    }

    data class ServerError(val errorCode: Int) : Errors(errorCode) {
        override fun abstractFun() {
            TODO("Not yet implemented")
        }

        override fun someFunction() {
            TODO("Not yet implemented")
        }
    }

    inner class OtherError : Errors(300) {
        override fun abstractFun() {
            TODO("Not yet implemented")
        }

        override fun someFunction() {
            TODO("Not yet implemented")
        }
    }

    init {

    }

    abstract fun abstractFun()

    // constructor(errorCode: Int) : this()
}

interface B {
    fun someFunction()
}

sealed class D
// direct subclass
open class E : D()
// indirect subclass
class F : D()

fun main() {
    // val errors = Errors(100) nesnesi uretilemez
    val errors = Errors.ServerError(300)
}