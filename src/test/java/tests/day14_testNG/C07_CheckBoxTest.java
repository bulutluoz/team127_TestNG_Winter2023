package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_CheckBoxTest {
    @Test
    public void test01(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        testOtomasyonuFormPage.carpintiCheckboxKutusu.click();
        testOtomasyonuFormPage.sirtAgrisiCheckboxKutusu.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(testOtomasyonuFormPage.carpintiCheckboxKutusu.isSelected());
        Assert.assertTrue(testOtomasyonuFormPage.sirtAgrisiCheckboxKutusu.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        Assert.assertFalse(testOtomasyonuFormPage.epilepsiCheckboxKutusu.isSelected());
        Assert.assertFalse(testOtomasyonuFormPage.sekerCheckboxKutusu.isSelected());
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
