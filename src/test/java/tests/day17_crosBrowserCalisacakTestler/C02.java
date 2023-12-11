package tests.day17_crosBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class C02 extends TestBaseCross {

    /*
        Varolan test package'lari altinda cross browser calisacak test yazmamak lazim
        Eger bir test method'unun crossBrowser ile calisacak testlere eklenmesi istenirse
        CrossBrowser package'ina tasiyip
        su degisiklikleri yapmak lazim
        1- TestBaseCross'a extends
        2- Driver.getDriver() yerine TestBaseCross'dan gelen driver objesi kullanin
        3- Page class'lari Driver.getDriver() ile tanimlandigindan kullanamayiz
           locate'leri test method'u icinde driver objesi ile yapmaliyiz
     */

    @Test
    public void dropdownTesti(){
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        List<WebElement> dropdownMenuElementleriList =
                driver.findElements(By.xpath("//select[@class='form-control']"));
        Select selectGun = new Select(dropdownMenuElementleriList.get(0));
        selectGun.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(dropdownMenuElementleriList.get(1));
        selectAy.selectByValue("nisan");
        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(dropdownMenuElementleriList.get(2));
        selectYil.selectByVisibleText("1990");
        //	4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText() + "/" +
                selectAy.getFirstSelectedOption().getText()+"/"+
                selectYil.getFirstSelectedOption().getText());
        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<String> aylarListesi = ReusableMethods.stringListeDonustur(selectAy.getOptions());
        System.out.println(aylarListesi);


        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(selectAy.getOptions().size(),13);

        ReusableMethods.bekle(3);

    }

}
