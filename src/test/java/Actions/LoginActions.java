package Actions;

import Locators.LoginLocators;
import driver.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginActions {
    LoginLocators loginLocators;

    public LoginActions(){
        this.loginLocators = new LoginLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), loginLocators);
    }

    public void typeUsername(String username) {
        loginLocators.username.sendKeys(username);
    }

    public void typePassword(String password) {
        loginLocators.password.sendKeys(password);
    }

    public void clickOnSubmit(){
        loginLocators.submit.click();
    }
}
