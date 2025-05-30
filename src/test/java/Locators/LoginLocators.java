package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginLocators {

    @FindBy(how= How.ID, using = "username")
    public WebElement username;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.CSS, using = ".fa")
    public WebElement submit;
}
