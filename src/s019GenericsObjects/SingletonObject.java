package s019GenericsObjects;

/*
    Singleton nedir:
    Bir sinifin nesnesine ihtiyacimiz var ama bu nesnenin memory'de sadece bir tane olmasini istersek kullanabiliriz
    Neden sadece bir tane nesnenin olmasini istiyor olabiliriz:
    Cunku o nesnes uzerinden yapilan islemlerin farkli siniflar tarafindan paylasilaabilmesine ihtiyac duyabiliriz
    farkli siniflar tarafindan yapilan degisiklikler diger sinifa gectiginde tasinsin istiyor olabiliriz nesnenin
    olusturulmasi maaliyetli olabilir
    Statik olarak memory'de saklanir, garbage collector'a diyoruz ki bunu silme bunun life-cycle'si benim kontrolumde
    Anti-pattern olarak:
    1- Tam da bu yuzden singleton'in gereksiz kullaniminda memoryden silinmeyen nesneler uretip memory'i sisirebiliriz
    (memory leak)
    2- Daha karmasik projelerde singleton obje'nin senkranizasyonunun dogru sekilde yapmak zor olabilir
 */
public class SingletonObject {
    public static void main(String[] args) {
        Retrofit retrofit = Retrofit.getInstance();
        Retrofit retrofit2 = Retrofit.getInstance();
        System.out.println(retrofit == retrofit2);
    }
}