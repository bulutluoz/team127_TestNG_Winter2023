package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssertion {

    @Test
    public void softAssertionTesti(){

        /*
            TestNG coklu assertion iceren testlerde
            2 alternatif sunuyor

            1- JUnit'deki method'larin aynilarini kullanabilirsiniz
               Testimiz failed olan ilk assertion'da calismayi durdurur
               geriye kalan assertion'larin passed olup olmadigini bilemeyiz
               failed olan assertion'i duzelttikten sonra
               digerlerine bakabiliriz

               Bu yontemi kullandigimizda
               failed olan her bir assertion icin
               duzeltmeleri yapip yeniden testi calistirmamiz gerekir
            2- SoftAssert class'indan ayni assert method'larini kullanabiliriz
               SoftAssert kullandigimizda TestNG assertion'lar failed olsa da
               durumu not alip calismaya devam eder
               Siz ne zaman rapor ver derseniz
               TestNG yaptigi tum assertion'lari gozden gecirir
               FAILED olan assertion'lari size raporlar
               ve FAILED olan varsa calismayi durdurur

                - softAssert objesi olustur
                - tum assertion'lari softAssert objesi kullanarak yap
                - assertion'lar bitince assertAll() ile rapor iste

         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();

        // Title'in Test icerdigini test edin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),"Title Test icermiyor");

        // url'in https://www.testotomasyonu.com oldugunu test edin

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farkli");

        // arama kutusunun kullanilabilir durumda oldugunu test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        softAssert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled(),"Arama kutusu kullanilamiyor");

        // belirlenmis aranacak kelimeyi aratip urun bulundugunu test edin
        testOtomasyonuPage
                .aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        softAssert.assertTrue(bulunanSonucSayisi>0,"Kayitli kelime arandiginda urun bulunamadi");

        // Nutella aratip, urun bulunamadigini test edin

        testOtomasyonuPage.aramaKutusu.clear();

        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        softAssert.assertTrue(bulunanSonucSayisi==0,"Nutella bulundu");

        softAssert.assertAll();

        // sayfayi kapatin

        Driver.closeDriver();

    }
}
