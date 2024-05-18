package t020ObjectsReflection

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

class Account private constructor() {
    private var balance: Long = 34235252
    private val accountName: String = "Hirda Hesap"

    private constructor(branchName: String, branchCode: Int) : this()

    private fun sendMoneyFromBalance(sentMoneyAmount: Long) {
        balance -= sentMoneyAmount
    }
}

fun main() {
    val primaryConstructor = Account::class.primaryConstructor!!
    primaryConstructor.isAccessible = true
    val account = primaryConstructor.call()
    for (property in Account::class.declaredMemberProperties) {
        // proguard obfuscate islemi yaparken class, fonksiyon, property isimlerini random seyler ile mapler
        // reflection ile buradaki gibi balance'a erismek istiyorsak mesela obfuscate islemi sonucunda balance ismi
        // degisecegi icin burasi patlar. onun icin proguarda buraya dokunma dememiz lazim
        // proguardin ikinci gorevi kullanilmayan dosyalari silmek
        if (property.name == "balance") {
            property.isAccessible = true
            val value = property.call(account)
            println(value)
        }
    }
}
