package d005BasicTypes

import java.util.*

fun main() {
    /*
    Char - 16 bit
    'a' gibi tek tirnak icine yazilir cift tirnak icine yazilirsa String olur
    eger sayi verilirse o sayiya karsilik gelen ASCII Table degeri gelir
     */
    val number = '6'
    println(number.code)
    // verdigimiz rakam'i almak istiyorsak digitToInt() kullaniriz
    println(number.digitToInt())

    /*
    escape karakterleri string icinde ozel karakterleri kullanmak icin kullanilir
    \ karakteri
     */
    "\t"
    "\""
    "\\"
    "\n"
    "\b"
    // gibi

    val uCode = '\u2665' // gibi unicode karakterleri yazabiliriz
    println(uCode)

    // boolean
    val isStudent = true
    val isMale = false
    // mantiksal operatorler
    /*
    && -> ve
    || -> veya
    ! -> not

    bunlar lazyly calisir yani
    && icin soldaki ifade false ise sagdakine bakmadan sonuc false olur
    || icin soldaki ifade true ise sagdakine bakmadan sonuc true olur
     */

    println(isMale && isStudent) // false ve isStudent'e bakmaz
    val nullableIsStudent: Boolean? = null
    // nullable boolean degiskenler icin direkt degiskeni yazamiyoruz
    println(nullableIsStudent == false && isMale)

    // Stringler
    /*
    Stingler yaklasik olarak karakter basina 2 byte yer kaplar UTF-16 encoding'ini kullanir
    Cift tirnak icine yazilan karakterler butunudur
     */
    val name = "Can"
    val char1 = 'C'
    val char2 = 'a'
    val char3 = 'n'

    // for dongusuyle her karakteri sirayla char icine alip yazdirabiliriz
    for (char in name) {
        println(char in name)
    }

    // String type olarak immutable'dir
    var str = "can"
    str = "cafer" // bu string yeniden yaratilir

    // Stringleri toplarken once string yazmaliyiz

    // 7 + str // burasi patlar
    str + 7 // burasi calisir cafer7

    // String ekleme $ isareti ile olur

    val fullName = "$str can tuncer" // cafer can tuncer

    // raw string kullanimi
    // trim indent soldaki gereksiz bosuklari siler
    """
       *
      ***
     *****
    *******
    """.trimIndent()

    // String.format()
    /*
    %s String icin
    %d Int icin
    %f ondalikli sayilar icin
    %n yeni bir satira gecmek icin
     */

    val name3 = "Cafer Can"
    val age = 22
    val height = 1.80f
    val formattedString = "Merhaba, benim adım %s, %d yaşındayım ve %,.2f m boyundayım."
        .format(Locale("tr", "TR"),name3, age, height)
    println(formattedString)
}