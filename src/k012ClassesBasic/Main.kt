package k012ClassesBasic

// constructor yazmazsak eger default olarak bos bir constructor olusur
// java'dan farkli olarak kotlinde 2 turde constructor var:
// -> primary constructor class isminin yanindaki ayraclara
// -> class icinde constructor keywordu ile.
// visibility modifier ya da annotation verirken constructor keyword'u kullanmak lazim
class Turtle public constructor(name: String, legCount: Int) {
    var color: String = ""

    // init primary constructor body'si
    init {
        println("object initialized - primary constructor created")
    }

    init {
        // birden fazla init blogu yazilabilir bunlar yazim sirasina gore arka arkaya calisir
    }

    // secondary constructor once primary constructor'i cagirir
    // yani once init blogu calisacak
    constructor(name: String, feet: Int, color: String) : this(name, feet) {
        this.color = color
        println("object initialized - secondary constructor created")
    }

}

fun main() {
    val turtle = Turtle("Brown", 3, "Brown")
    val b = 10
}

// VISIBILITY MODIFIERS
// public - private - internal - protected
/*
eger top level olarak yazildiysa:
public -> her yerde visible
private -> sadece o file icinde visible
internal -> o module icinde her yerde visible
protected -> top level olarak kullanimi yok

eger class member olarak yazildisya:
private -> sadece o class icinde visible
(outer class inner class icindeki private members'lari goremez ama inner outer'dakileri gorebilir)
protected -> private gibi ama subclass'lari da gorebilir
internal -> class instance'i uzerinden o module icinde gorunur
public -> class instance'i uzerinden her yerde gorunur

eger internal ve protected members'lari override edersek ve kendimiz yeni bir visibility modifier
belirlemezsek ayni visibility modifier'i tasirlar

eger constructor icin yazildiysa:
oncelikle constructor keyword'unu acikca yazmamiz gerekiyor primary constructor icin
default olarak public geliyor boylece class'in visible oldugu her yerde visible oluyor

sealed class'larda constructor'lar defult olarak protected geliyor

local degiskenler fonksiyonlar ve class'lar visibility modifiers alamazlar
 */