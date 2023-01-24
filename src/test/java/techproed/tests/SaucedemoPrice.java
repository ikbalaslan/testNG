package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.SaucedemoHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import java.util.List;

@Listeners(techproed.utilities.Listeners.class)
public class SaucedemoPrice {
    SaucedemoHomePage saucedemoHomePage = new SaucedemoHomePage();
    //Given
    //    Go to  https://www.saucedemo.com/
    //  When
    //    Enter the username  as "standard_user"
    //  And
    //    Enter the password as "secret_sauce"
    //  And
    //    Click on login button
    //  Then
    //    Assert that total price of all products is 129.94 dollars
    //  And
    //    Flash each web element you used
    @Test()
    public void totalPrice(){
        Driver.getDriver().get(ConfigReader.getProperty("saucedemo_url"));

        JSUtils.flash(saucedemoHomePage.username);
        saucedemoHomePage.username.sendKeys("standard_user");
        JSUtils.flash(saucedemoHomePage.password);
        saucedemoHomePage.password.sendKeys("secret_sauce");
      JSUtils.flash(saucedemoHomePage.button);
        saucedemoHomePage.button.click();
        List<WebElement> listOfItems = saucedemoHomePage.texts;
       Double totalPrice=0.0;
        for(WebElement w : listOfItems){
            JSUtils.flash(w);
          String x= w.getText().toString();
         x= x.replaceAll("[^0-9.]", "");
            totalPrice= totalPrice + Double.valueOf(x);

        }
        Assert.assertEquals(129.94,totalPrice);
       Driver.closeDriver();
    }

}
