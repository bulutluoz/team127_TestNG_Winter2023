package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssertion {

    @Test
    public void softAssertionTesti(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Anasayfada degiliz");
        // 3. Sign in butonuna basin
        ZeroPage zeroPage = new ZeroPage();
        zeroPage.signInLinki.click();

        // 4. Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");
        // 5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");
        // 6. Sign in tusuna basin
        zeroPage.signInButonu.click();
        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
        // 8. Giris yapilabildigi dogrulayin
        softAssert.assertTrue(zeroPage.onlineBankingLinki.isDisplayed(),"Giris yapilamadi");

        // 9. Online banking menusunu tiklayin
        zeroPage.onlineBankingLinki.click();
        //10. Pay Bills sayfasina gidin
        zeroPage.payBillsLinki.click();
        //11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseForeignCurrencyLinki.click();
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroPage.pcCurrencyDropdownElementi.isEnabled(),"currency dropdown kullanilamiyor");
        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");
        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedOption = "Eurozone (euro)";
        String actualSeciliOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSeciliOption,expectedOption,"Eurozone secilemedi");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedDropdownSize = 16;
        int actualDopdownSize = select.getOptions().size();
        softAssert.assertEquals(actualDopdownSize,expectedDropdownSize,"Dropdown beklenen boyutta degil");
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<WebElement> dropdownElementleriList = select.getOptions();
        List<String> dropdownYazilariList = ReusableMethods.stringListeDonustur(dropdownElementleriList);
        softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Dropdown'da Canada Dolari yok");
        //17. Sayfayi kapatin
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
