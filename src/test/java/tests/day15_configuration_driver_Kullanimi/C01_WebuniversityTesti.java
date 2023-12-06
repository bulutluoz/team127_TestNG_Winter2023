package tests.day15_configuration_driver_Kullanimi;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_WebuniversityTesti {

    @Test
    public void negatifLoginTesti(){
        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webuniversityPage.loginPortalLinki);
        //3."Login Portal" a tiklayin
        ReusableMethods.bekle(1);
        webuniversityPage.loginPortalLinki.click();
        //4.Diger window'a gecin
        ReusableMethods.titleIleSayfaDegistir("WebDriver | Login Portal");
        //5."username" ve  "password" kutularina rastgele deger yazdirin

        //6."login" butonuna basin
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        //8.Ok diyerek Popup'i kapatin
        //9.Ilk sayfaya geri donun
        //10.Ilk sayfaya donuldugunu test edin

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
