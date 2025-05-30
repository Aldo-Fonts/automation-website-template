package Steps;

import driver.SeleniumDriver;
import io.cucumber.java.en.Given;

public class InitialPath {
    @Given("I am at the main site")
    public void mainSite() {
        SeleniumDriver.openPage("https://the-internet.herokuapp.com/login");
    }
}
