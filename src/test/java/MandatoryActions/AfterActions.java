package MandatoryActions;

import driver.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AfterActions {
    private int stepsCounter = 1;

    @After
    public void tearDown(){
        SeleniumDriver.tearDown();
    }

    @AfterStep
    public void reportStep(Scenario scenario){
        WebDriver driver = SeleniumDriver.getDriver();
        SimpleDateFormat format = new SimpleDateFormat("_dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            new File("../../reports/" + scenario.getName()).mkdirs();
            FileUtils.copyFile(file, new File("./reports/" + scenario.getName() + "/_step_" + stepsCounter + format.format(date) + ".jpg"));
            stepsCounter++;
        } catch(Exception error) {
            error.printStackTrace();
        }
    }
}
