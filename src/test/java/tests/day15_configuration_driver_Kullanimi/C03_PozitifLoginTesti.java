package tests.day15_configuration_driver_Kullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PozitifLoginTesti {

    @Test(groups = {"smoke" , "regression"})
    public void pozitifLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2- account linkine basin
        ReusableMethods.bekle(1);
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        // 3- Kullanici email'i olarak gecerliEmail girin
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        // 4- Kullanici sifresi olarak gecerliPassword girin
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        // 5- Login butonuna basarak login olun
        ReusableMethods.bekle(1);
        testOtomasyonuPage.loginButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutLinki.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
