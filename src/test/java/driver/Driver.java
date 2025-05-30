package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class Driver {
    public WebDriver driver;

    private String OS = System.getProperty("os.name").toLowerCase();

    public WebDriver driverSettings() throws Exception {
        String browser = System.getProperty("browser","chrome");

        try {
            //setDriverPath(browser);
            switch (browser){
                case "firefox":
                    return firefoxDriver();
                case "chrome":
                    return chromeDriver();
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    private WebDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-file-for-fake-video-capture=src/files/sample.mjpeg");

        // Local environment
        // Ignore ssl
        options.addArguments("--ignore-ssl-error=yes");
        options.addArguments("--ignore-certificate-errors");

        // Fixing issue Netty v5.x
        options.addArguments("--remote-allow-origins=*");

        // The argument to enable or disable the UI
        //if(!ui) options.addArguments("--headless");

        HashMap prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        //Full Screen
        driver.manage().window().maximize();
        return  driver;
    }

    private WebDriver firefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("permissions.default.microphone", 1);
        options.addPreference("permissions.default.camera", 1);
        options.addArguments("--remote-allow-origins=*");

        //if(!ui) options.addArguments("--headless");

        driver = new FirefoxDriver();
        //Full Screen
        driver.manage().window().maximize();
        return  driver;
    }

    private void setDriverPath(String specificDriver){
        System.out.println(OS);
        System.out.println(specificDriver);
        // Identify OS
        if(isWindows()){
            switch (specificDriver) {
                case "firefox" -> System.setProperty("webdriver.gecko.driver", "..\\..\\..\\drivers\\windows");
                case "chrome" -> System.setProperty("webdriver.chrome.driver", "..\\..\\..\\drivers\\windows");
            }
        } else if (isMac() || isLinux()) {
            switch (specificDriver) {
                case "firefox" -> System.setProperty("webdriver.gecko.driver", "../../../drivers/macos");
                case "chrome" -> System.setProperty("webdriver.chrome.driver", "../../../drivers/macos");
            }
        } else {
            throw new RuntimeException("Unsupported OS: " + OS);
        }
    }

    private boolean isWindows(){
        return OS.contains("win");
    }

    private boolean isMac(){
        return OS.contains("mac");
    }

    private boolean isLinux(){
        return (
                OS.contains("nix")
                        || OS.contains("nux")
                        || OS.contains("aix")
        );
    }
}
