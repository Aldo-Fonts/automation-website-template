package Steps;

import Actions.LoginActions;
import driver.SeleniumDriver;
import io.cucumber.java.en.Given;

import java.util.NoSuchElementException;

public class LoginSteps {
    LoginActions loginActions = new LoginActions();

    @Given("I type {string} on {string} input")
    public void typeOnInput(String text, String inputField) {
        text = text.toLowerCase();
        inputField = inputField.toLowerCase();
        try {
            switch (inputField) {
                case "username":
                    loginActions.typeUsername(text);
                    break;
                case "password":
                    loginActions.typePassword(text);
                    break;
            }
        }catch (NoSuchElementException error){
            error.printStackTrace();
        }
    }

    @Given("I click on {string} button")
    public void clickOnButton(String text) {
        text = text.toLowerCase();
        try {
            switch (text) {
                case "submit":
                    loginActions.clickOnSubmit();
                    break;
            }
        } catch (NoSuchElementException error) {
            error.printStackTrace();
        }
    }
}
