package o016DataInnerNested

fun main() {
    val person = Person("can", 23, "gkagkr")
    person.toString().let(::println)

    // destructing declaration
    val (name, age) = person
}

data class Person(val name: String, val age: Int) {
    constructor(name: String, age: Int, job: String) : this(name, age) {
    }
}
/*
    mutlaka primary constructor sahip olmali ve val/var ile yazilmis bir parametre icermeli cunku arkada generate edilen
    fonksiyonlarin bu propertylere esirmesi gerekli.
    primary constructor icin equals, hashcode, copy, toString ve component N fonksiyonlari generate edilir. eger equals,
    hashcode ve toString fonksiyonlarini override edersek arkada generate edilmez bizim yazdigimiz gecerli olur.
    primary constructordaki propertylere default degerler verilebilir bu konu mapping kutuphanelerinin(jackson, json)
    bos constructor'a sahip olmasi gerekliliginden onemlidir.
    data class'larda data manipulasyonu yapmak ya da icine fonksiyonlar yazip logic olusturmak yanlistir bunlarin gorevi
    data tutmaktir.
 */