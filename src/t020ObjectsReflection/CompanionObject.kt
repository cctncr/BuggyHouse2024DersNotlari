package t020ObjectsReflection

// companion kelime anlami olarak eslik eden demek
// life-cycle'i HomeFragment'a bagli olan static bir obje olusturmus oluyoruz
class HomeFragment {
    var valueList: List<Pair<String, Any>> = listOf()
    companion object {
        fun newInstance(valueList: List<Pair<String, Any>>): HomeFragment {
            val fragment = HomeFragment()
            fragment.valueList = valueList
            return fragment
        }
    }
}

fun main() {
    // bu sekilde yapmak yerine:
    // val homeFragment = HomeFragment()
    // homeFragment.valueList = listOf()
    // boyle yaparak:
    HomeFragment.newInstance(listOf())
    // hem Fragment'a icine bakmadan gelmesi gerek degiskenleri gormus oluyoruz hem de bunlari set etmeyi unutmamis
    // oluyoruz

    // companion object member'lari static gibi gozuksede statik degildir. Omitlesek bile Companion uzerinden
    // member'larina erisiyoruz companion'in nesnesi static
    HomeFragment.Companion.newInstance(listOf())
}

/*
    companion object ile object arasindaki fark:
    object life-cycle'i proje life-cycle iken companion object kullanildigi class'a baglidir class olunce o da olur
 */