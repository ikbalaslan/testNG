package techproed.pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "formBasicEmail")
    public WebElement emailLink;
    @FindBy(id = "formBasicPassword")
    public WebElement passwordLink;
    @FindBy(xpath = "//button[.=' Login']")
    public WebElement buttonLink;
}
