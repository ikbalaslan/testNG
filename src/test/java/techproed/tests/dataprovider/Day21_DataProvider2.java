package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day21_DataProvider2 {
    HomePage homePage;
    LoginPage loginPage;
    @DataProvider
    public Object[][] customerData(){
        //Test DATA
        Object [][] customerCredentials = {
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customerCredentials;
    }

    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(3);
        try {
            homePage.homePageLink.click();
        } catch (Exception e) {
        }
        try {
            homePage.userID.click();
            homePage.logoutLink.click();
            homePage.OK.click();
            homePage.homePageLink.click();
        } catch (Exception e) {
        }
        ReusableMethods.waitFor(3);
    }

    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username , String password){
             login();
        loginPage.emailLink.sendKeys(username);
        loginPage.passwordLink.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.buttonLink.click();
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
        ReusableMethods.verifyElementDisplayed(homePage.userID);

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
