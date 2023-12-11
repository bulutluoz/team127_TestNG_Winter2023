package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C03_DataProviderIleNegatifLoginTesti {


    @DataProvider
    public static Object[][] kullaniciBilgileriDP() {

        String[][] kullaniciBilgileri ={{"kullanici1", "12345"},
                {"kullanici2", "23456"}, {"kullanici3", "34567"},
                {"kullanici4", "45678"}, {"kullanici5", "56789"}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciBilgileriDP")
    public void cokluNegatifLoginTesti(String username, String password){

        // testotomasyonu anasayfaya gidin

        // account linkine tiklayin

        // kullanici adi ve sifre olarak verilen listedeki
        // tum degerler icin giris yapilamadigini test edin

        // kullanici1   12345
        // kullanici2   23456
        // kullanici3   34567
        // kullanici4   45678
        // kullanici5   56789
    }
}
