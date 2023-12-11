package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertTrue;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){
        extentTest = extentReports.createTest("Arama testi","Kullanici belirlenen kelimeyi aratip, dogru arama yapildigini test eder");
        // testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu ana sayfaya gider");
        // belirlenen arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");
        // arama sonucunda urun bulunabildigini test edin
        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        assertTrue(aramaSonucSayisi > 0);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");
        ReusableMethods.bekle(1);
        // ilk urunu tiklayin

        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk urunu tiklar");
        // acilan urun sayfasinda urun isminin
        // case sensitive olmadan belirlenen arama kelimesi icerdigini test edin

        String actualUrunIsmiKucukHarf = testOtomasyonuPage
                                            .urunSayfasindakiUrunIsimElementi
                                            .getText()
                                            .toLowerCase();
        assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));

        extentTest.pass("acilan urun sayfasinda urun isminin\ncase sensitive olmadan belirlenen arama kelimesi icerdigini test eder");

        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");

    }
}
