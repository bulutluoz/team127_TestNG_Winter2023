package tests.day17_crosBrowserCalisacakTestler;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01 {

    @Test
    public void aramaTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
}
