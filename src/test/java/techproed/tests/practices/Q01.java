package techproed.tests.practices;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BankHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Q01 {
    //Open 5 Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts.
   /*
Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table row numbers
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
Then
    Assert that "Deposit Successful" is displayed
And
    Click on "Deposit"(Submit) button
And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0

 */
    //Open 5 Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts.
    //https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
BankHomePage bankHomePage = new BankHomePage();
Faker faker = new Faker();
    @Test
    public void test(){
    Driver.getDriver().get(ConfigReader.getProperty("xyz_bank_home_URL"));
    bankHomePage.BankManagerButton.click();
    bankHomePage.addCustomer.click();
for (int i =0;i<5;i++) {
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String postCode = faker.address().zipCode();
    bankHomePage.firstName.sendKeys(firstName);
    bankHomePage.lastName.sendKeys(lastName);
    bankHomePage.postCode.sendKeys(postCode);
    bankHomePage.addButton.click();

    try {
        Driver.getDriver().switchTo().alert().accept();
    } catch (Exception ignored) {

    }
}
for (int i =5;i<11;i++) {
//    Click on "Open Account"  button
    bankHomePage.openAccountButton.click();
//And
//    Click on "Customer" dropdown
    Select select = new Select(bankHomePage.dropdown);

//And
//    Select customer name
    select.selectByIndex(i);

//And
//    Click on "Currency" dropdown
    Select select1 = new Select(bankHomePage.currencyDropdown);

//And

//    Select "Dollar"
    select1.selectByVisibleText("Dollar");

//And
//    Click on "Process" button
    bankHomePage.processButton.click();
    try {
        Driver.getDriver().switchTo().alert().accept();
    } catch (Exception ignored) {

    }

}
//And
//    Accept alert
//And
//    Open 4 more accounts
//And
//    Click on "Customers" button
        bankHomePage.customersButton.click();
//And
//    Count table row numbers
int numberOfRows = bankHomePage.listOfRows.size();
        System.out.println(numberOfRows);

//Then
//    Assert that you created 5 customers
        Assert.assertTrue(numberOfRows==10);
//When
//    Click on "Home" button
bankHomePage.homeButton.click();
//And
//    Click on "Customer Login" button
bankHomePage.customerLoginButton.click();
//And
//    Click on "Your Name" dropdown
Select select= new Select(bankHomePage.nameDropdown);

//And
//    Select the any name you created
        select.selectByIndex(7);

//And
//    Click on "Login" button
bankHomePage.loginButton.click();
//And
//    Click on "Deposit" button
   bankHomePage.depositButton.click();



//And
//    Type 100 into "Amount to be Deposited" input
        WebElement amountButton = ReusableMethods.waitForClickablility(bankHomePage.amountDeposit,10);
        amountButton.sendKeys("100");

        bankHomePage.depositButton1.click();
//Then

//    Assert that "Deposit Successful" is displayed
        Assert.assertTrue(bankHomePage.text.isDisplayed());
//And
//    Click on "Withdrawal" button
        bankHomePage.withdraw.click();

//And

//        WebElement withdrawButton = ReusableMethods.waitForVisibility(bankHomePage.amountWithdraw,10);


//And
//    Type 100 into "Amount to be Withdrawn" input
        System.out.println("NOT YET");
        bankHomePage.amountWithdraw.click();

        bankHomePage.amountWithdraw.sendKeys("100");
//        withdrawButton.sendKeys("100");
        System.out.println("SendKeys HAppend");
//        bankHomePage.amountWithdraw.sendKeys("100");

//And
//    Click on "Withdraw"(Submit) button
        Actions actions = new Actions(Driver.getDriver());
        actions.click(bankHomePage.withdrawButton);

//        bankHomePage.withdrawButton.click();

//Then
//    Assert that "Transaction  Successful" is displayed
        ReusableMethods.verifyElementDisplayed(bankHomePage.withdrawText);
//When
//    Click on "Logout" button
        bankHomePage.logoutButton.click();
//And
//    Click on "Home" button
        bankHomePage.homeButton.click();
//And
//    Click on "Bank Manager Login" button
        bankHomePage.BankManagerButton.click();
//And
//    Click on "Customers" button
        bankHomePage.customersButton.click();
//And
//    Click on each "Delete" button
for (WebElement w : bankHomePage.deleteLists){
    w.click();
    ReusableMethods.waitFor(1);
}
//And
//    Count table row numbers
//Then
//    Assert that number of customers is 0

}
}
