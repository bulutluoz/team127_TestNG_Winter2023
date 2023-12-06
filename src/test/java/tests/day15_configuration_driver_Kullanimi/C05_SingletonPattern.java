package tests.day15_configuration_driver_Kullanimi;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_SingletonPattern {

    @Test
    public void test01(){

        /*
        SINGLETON pattern bir class'dan
        obje olusturulmasini onlemek icin kullanilan
        yontemlerden biridir

        SINGLETON pattern kullanmak icin
        obje olusturulmasini engellemek istedigimiz class'da
        gorunur bir constructor olusturur
        ve bu constructor'in access modifier'ini PRIVATE yapariz


        Driver driver = new Driver();
        driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        ReusableMethods.bekle(5);
        driver.closeDriver();

         */

    }
}
