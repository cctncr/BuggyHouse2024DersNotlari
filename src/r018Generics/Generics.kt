package r018Generics

// Elimizde oyle bir parametre olmasi gerekiyor ki ama bu parametre birden fazla tipte olabilir; bu tiplerin hangisi
// olduguyla da ilgilenmiyoruz bu durumlarda generic type'lar kullanilabilir
// Any ile type safety saglanamadigi icin generic'lere ihtiyac duyariz compile time'da hata vermicek ama run time'da
// hata alicaz

/*
    Java Wild Cards:
    (duz kullanimda) in-variant -> sadece o class type'i, birbirlerinin yerine kullanilamaz
    (? extends E) co-variant -> E ve child'lari; Kotlinde: out
    (? super E) contra-variant -> E ve parent'lari; Kotlinde: in
 */

class Box <out T> (val value: T)

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun main() {
    val box: Box<Number> = Box<Float>(1.0f)
    // val box: Box<Number> = Box<Int>(1) bu kullanimi yapamiyoruz cunku in-variant
}