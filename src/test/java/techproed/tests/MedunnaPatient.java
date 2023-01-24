package techproed.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.MedunnaHomePage;
import techproed.pages.MedunnaLoginPage;
import techproed.pages.MedunnaPatientsPage;
import techproed.utilities.*;

public class MedunnaPatient {
    MedunnaLoginPage medunnaLoginPage;
    MedunnaHomePage medunnaHomePage;
    MedunnaPatientsPage medunnaPatientsPage;
   @DataProvider
    public Object[][] patientData(){
String path = "src/test/java/resources/MedunnaCredentials.xlsx";
String sheetName = "medunna01";
       ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
       Object[][] patientCredential = excelUtils.getDataArrayWithoutFirstRow();
       return  patientCredential;
    }

    @Test(dataProvider = "patientData")
    public void test(String username , String password , String firstname , String lastname , String email, String phone ) throws InterruptedException {
      //Admin can create patients

//    Given
//        Go to https://medunna.com/
      Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
//    When
//        Click on User icon
      medunnaHomePage = new MedunnaHomePage();
      medunnaHomePage.userIcon.click();


//    And
//        Click on "Sign In" section
medunnaHomePage.signInSection.click();

//    And
//        Enter username into "Username" input
      medunnaLoginPage = new MedunnaLoginPage();
      medunnaLoginPage.usernameInput.sendKeys(username);
//    And
//        Enter password into "Password" input
      medunnaLoginPage.passwordInput.sendKeys(password);
//
//        John.123
//    And
//        Check the "Remember Me" checkbox
      medunnaLoginPage.rememberMeCheckBox.click();

      //    And
//        Click on "Sign In" button
      medunnaLoginPage.signInSubmitButton.click();
//    And
//        Click on "Items & Titles" men
      medunnaHomePage.itemsAndTitleMenu.click();
//    And
//        Click on "Patient" section
      medunnaHomePage.patientSection.click();
//    And
//        Click on "Create a new patient" button
      medunnaPatientsPage = new MedunnaPatientsPage();
      medunnaPatientsPage.createNewPatientButton.click();

//    And
        medunnaPatientsPage = new MedunnaPatientsPage();
        medunnaPatientsPage.patientFirstNameInput.sendKeys(firstname);
        medunnaPatientsPage.patientLastNameInput.sendKeys(lastname);
        medunnaPatientsPage.emailInput.sendKeys(email);
        medunnaPatientsPage.patientPhoneInput.sendKeys(phone);
        JSUtils.clickElementByJS(medunnaPatientsPage.saveButton);



//        Enter firstname into "First Name" input

//    And
//        Enter last name into "Last Name" input
//    And
//        Enter email into "Email" input
//    And
//        Enter phone number into "Phone" input
//    And
//        Click on "Save" button

  }


    @AfterMethod
    public void closeBrowser(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }




}