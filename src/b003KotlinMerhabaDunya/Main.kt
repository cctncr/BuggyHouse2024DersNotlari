package b003KotlinMerhabaDunya

// main fonksiyon ozel bir fonksiyondur uygulamanin baslangic noktasini ifade eder
fun main() {
    print("Hello World") // yan yana yazar
    println() // yazar ve alt satira gecer

    // val <desgisken ismi>: <Type> = <Baslangic degeri>
    val name: String = "Cafer Can"

    // type'i elle belirtmek yerine baslangic degeri vererek type inference yapabiliriz.
    val age = 22

    // initialize etmeden degisken olusturma
    val surname: String

    // konsoldan veri isteme
    surname = readln()

    // var ile yazilirsa degiskene yeniden atama yapilabilir
    var isMale = false

    // val -> value , var -> variable
    // val'i setter'i private yapilmis bir var gibi dusunebiliriz
    // bir degiskeni yazarken val olarak yazin sonrasinda o degiskene yeniden atama yapilacaksa var'a cevirin
}

// yine app entry point. args: Array<String> program arguments alir
/*
fun main(args: Array<String>) {
    for (lang in args) {
            println(lang)
    }
}
 */

/*
ctrl + alt + L
option + command + L
file'i reformatlar, girintileri cikintilari duzenler
 */