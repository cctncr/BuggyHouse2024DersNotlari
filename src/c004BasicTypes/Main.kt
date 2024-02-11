package c004BasicTypes

fun main() {
    // ozunde 2 tur degisken tipi var primitive ve reference
    // int age = 22 Java'da primitive tipler kucuk yaziliyor
    // kotlinde coding levelde primitive tip yazamiyoruz ama wrapper class'i onu primitive optimize eder yapabiliyorsa
    // eger null verilmisse primitive degil reference type olur
    val referenceTypeInt: Int? = null
    // sayilarda eger Byte range'i icindeyse nullable olsa bile primitive olur
    val integer1: Long? = 127
    val integer2: Long? = 127
    // === referanslarini karsilastirir
    println(integer1 === integer2) // Byte range'i icinde oldugu icin true
    // val degiskenler ozunde immutable degil read-only degiskenlerdir. Baska mutable degiskenlere bagli ozel bir getter
    // fonksiyonu yazabiliriz
    // multi-thread islemlerde val iletisim maaliyetini azaltir

    val name: String? = null
    val age: Int? = null
    val number = null // type'i Nothing
    // name.lowercase() ? ya da !! koymamiz gerekiyor
    // name?.lowercase() ? null degilse calistir diyoruz
    // name!!.lowercase() !! null olmayacagini garanti ediyoruz NPE alabiliriz
    // uygulamada dogru gosterilmesi hayati olmayan durumlarda ? kullanilmali. Mesela banka uygulamasinda bakiye degeri
    // !! kullanilmalidir

    /*
    bit 0 ve 1, 2 deger alir
    Byte 8 bit 2^8 256 deger alir [-128 - 127] [-2^7 - 2^7-1]
    Short 16 bit
    Int 32 bit
    Long 64 bit

    Float 32 bit
    Double 64 bit

    degisken tiplerinin unsigned versiyonlari var negatif taraflari pozitif tarafa eklenir
    UByte 8 bit 2^6 256 deger alir [0 - 255]
     */
    val unsignedByte: UByte= UByte.MAX_VALUE // 255

    // sayilarda type inference icin eger Int range'ini asmiyorsa Int set edilir asiliyorsa Long set edilir
    val number2 = 999999999999999 // Long
    val number3 = 10000L // L eklenirse Long olur
    // ondalikli sayilarda type inference icin eger float olarak belirtilmezse Double set edilir
    val number4 = 3.2 // Double
    val number5 = 3.2f // f ya da F eklenirse Float olur
}