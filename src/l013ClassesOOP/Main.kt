package l013ClassesOOP

class Encapsulation {
    // karmasayi onlemek icin
    // mimari olarak bir architecture kurabilmek icin belli class'larin belli class'lari hic gormemesi
    // belli class'larin belli belli class'larin belli kisimlarini gorebilmesi mimariyi kurmabilmek icin lazim
}

class Inheritance {
    // bir sinifin, baska bir sinifin bazi ozelliklerini kullanabilmesi icin yapi
}

class Polymorphism {
    // ayni fonksiyonlarin farkli sonuc icermesi statik polymorphism cunku sabit yazili bilgi elle yazdik
    // class'in uste class'dan geleni override etmesine dinamik polymorphism denir cunku class'a gore degisir
}

fun main(args: Array<String>) {
    val dog = Dog("Karabas", 4)
    val cat = Cat("London", 4)
}

open class Animal(open val name: String, open val legCount: Int) {
    open fun makeASound() = ""

}

class Dog(override val name: String, override val legCount: Int) : Animal(name, legCount) {
    override fun makeASound(): String {
        return "wouf wouf"
    }
}

class Cat(override val name: String, override val legCount: Int) : Animal(name, legCount) {
    override fun makeASound(): String {
        return "meow"
    }

}