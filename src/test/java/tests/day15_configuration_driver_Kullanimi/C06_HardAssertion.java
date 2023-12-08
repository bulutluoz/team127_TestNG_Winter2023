package tests.day15_configuration_driver_Kullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_HardAssertion {

    @Test
    public void hardAssertionTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Title'in Test icerdigini test edin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // url'in https://www.testotomasyonu.com oldugunu test edin

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        // arama kutusunun kullanilabilir durumda oldugunu test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        Assert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled());

        // belirlenmis aranacak kelimeyi aratip urun bulundugunu test edin
        testOtomasyonuPage
                .aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanSonucSayisi>0);

        // Nutella aratip, urun bulunmadigini test edin
        ReusableMethods.bekle(2);
        testOtomasyonuPage.aramaKutusu.clear();
        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        ReusableMethods.bekle(2);
        bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanSonucSayisi==0);

        // sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
