package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class SaucedemoHomePage {
    public SaucedemoHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement button;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    public List<WebElement> texts;




}
