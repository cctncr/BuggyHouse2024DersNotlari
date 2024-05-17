package s019GenericsObjects;

/*
    adim adim:
    1- tum contructorlari ve default constructor'i private'a cek
    2- icerde sinifin kendi private static instance'sini olustur
    3- bu instance'i geri donen static bir fonksiyon yaz
    4- bu fonksiyon icerisinde instance'in null check'ini yaparak geri dondur
    synchronized ayni anda birden fazla threat'in erismesini engeller
    volatile degiskenin degeri degistirildiginde uzerinde calisan thread'leri haberdar eder
 */
public class Retrofit {
    private volatile static Retrofit INSTANCE;
    String BASE_URL;

    private Retrofit() {
        BASE_URL = "https://api.github.com/";
    }

    public synchronized static Retrofit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit();
        }
        return INSTANCE;
    }
}
