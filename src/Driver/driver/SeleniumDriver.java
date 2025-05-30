package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver extends Driver{
    // Driver flag
    private static SeleniumDriver instance;

    // Base driver
    private static WebDriver driver;

    // Timeout
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    // Test number
    public static int TEST_NUMBER = 0;

    private SeleniumDriver() throws Exception{
        driver = driverSettings();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static SeleniumDriver setUp() throws Exception{
        if(instance == null){
            instance = new SeleniumDriver();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        instance = null;
    }

    public static void openPage(String url){
        driver.get(url);
    }

    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT,1));
        wait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public void updateTestNumber() {
        TEST_NUMBER++;
    }

    public static int getTestNumber() {
        return TEST_NUMBER;
    }
}
