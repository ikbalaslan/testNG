package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Day21_DataProvider3 {
    /*
    In this method, we will get the data from EXCEL using DataProvider
    The only difference between class 2 and class 3 is the place where we get the data
    In this class, we get the data from excel
    In class 2 , we received the data from the class itself. In this class we get the data from excel

     */
    HomePage homePage;
    LoginPage loginPage;
    @DataProvider
    public Object[][] customerData(){
        //PATH OF EXCEL SHEET
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        //SHEET name
        String sheetName = "customer_info";
        //CALL EXCEL UTIL CLASS
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        //USE on of the excel util method to receive the data from the excel
       Object [][] customerCredentials =excelUtils.getDataArrayWithoutFirstRow();
        //Test DATA
//        Object [][] customerCredentials = {
//                {"sam.walker@bluerentalcars.com","c!fas_art"},
//                {"kate.brown@bluerentalcars.com","tad1$Fas"},
//                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
//                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
//        };
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
