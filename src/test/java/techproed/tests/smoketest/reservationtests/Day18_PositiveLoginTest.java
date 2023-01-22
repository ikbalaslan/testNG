package techproed.tests.smoketest.logintests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
public class Day18_PositiveLoginTest {
    HomePage homePage;
    LoginPage loginPage;
    @Test
    public void US100201_Admin_Login(){
//going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.emailLink.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        loginPage.passwordLink.sendKeys("12345");
        ReusableMethods.waitFor(3);
        loginPage.buttonLink.click();
        ReusableMethods.waitFor(3);
//        Verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
