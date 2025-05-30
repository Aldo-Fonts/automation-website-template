package MandatoryActions;

import driver.SeleniumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class BeforeActions {
    @Before
    public void beforeSteps(Scenario scenario){
        try {
            SeleniumDriver.setUp();
            if( SeleniumDriver.getTestNumber() > 1 ) {
                FileUtils.deleteDirectory(new File("./reports"));
            }
        } catch (Exception error){
            error.printStackTrace();
        }
    }
}
