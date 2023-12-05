package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuFormPage {

    public TestOtomasyonuFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//select[@class='form-control']")
    public List<WebElement> dropdownMenuElementleriList;

    @FindBy(id = "gridCheck4")
    public WebElement carpintiCheckboxKutusu;

    @FindBy(id = "gridCheck5")
    public WebElement sirtAgrisiCheckboxKutusu;

    @FindBy(id = "hastalikCheck2")
    public WebElement sekerCheckboxKutusu;

    @FindBy(id = "hastalikCheck7")
    public WebElement epilepsiCheckboxKutusu;
}
