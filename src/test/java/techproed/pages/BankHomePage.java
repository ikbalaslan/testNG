package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class BankHomePage {
   public BankHomePage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(xpath = "//*[@ng-click='manager()']")
    public WebElement BankManagerButton;
   @FindBy(xpath = "//*[@ng-class='btnClass1']")
    public WebElement addCustomer;
   @FindBy(xpath = "//*[@placeholder='First Name']")
    public WebElement firstName;
   @FindBy(xpath = "//*[@placeholder='Last Name']")
    public WebElement lastName;
    @FindBy(xpath = "//*[@placeholder='Post Code']")
    public WebElement postCode;
    @FindBy(xpath = "//*[.='Add Customer']")
    public WebElement addButton;
    @FindBy(xpath = "//*[@ng-class='btnClass2']")
    public WebElement openAccountButton;
    @FindBy(id = "userSelect")
    public WebElement dropdown;
    @FindBy(id = "currency")
    public WebElement currencyDropdown;
    @FindBy(xpath = "//*[.='Process']")
    public WebElement processButton;
    @FindBy(xpath = "//*[@ng-class='btnClass3']")
    public WebElement customersButton;
    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> listOfRows;
    @FindBy(xpath = "//*[@class='btn home']")
    public WebElement homeButton;
    @FindBy(xpath = "(//*[@class='btn btn-primary btn-lg'])[1]")
    public WebElement customerLoginButton;
    @FindBy(name = "userSelect")
    public WebElement nameDropdown;
    @FindBy(xpath = "//*[.='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@ng-class='btnClass2']")
    public WebElement depositButton;
    @FindBy(xpath = "//*[@ng-model='amount']")
    public WebElement amountDeposit;
    @FindBy(xpath = "//*[@ng-show='message']")
 public WebElement text;
    @FindBy(xpath = "//*[@ng-click='withdrawl()']")
 public WebElement withdraw;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountWithdraw;

    @FindBy(xpath = "//*[.='Withdraw']")
    public WebElement withdrawButton;
    @FindBy(xpath = "//*[@ng-show='message']")
 public WebElement withdrawText;
 @FindBy(xpath = " //*[.='Logout']")
 public WebElement logoutButton;
 @FindBy(xpath = "(//*[.='Delete'])//button")
 public List<WebElement> deleteLists;
 @FindBy(xpath = "//*[.='Deposit']")
 public WebElement depositButton1;








}
