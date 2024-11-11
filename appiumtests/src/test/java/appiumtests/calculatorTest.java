package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

public class calculatorTest {

    static AppiumDriver driver;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            opencalculator();
        } catch (Exception exp) {
            exp.printStackTrace(); // Prints the full stack trace for debugging
            System.out.println(exp.getMessage());
        }
    }

    public static void opencalculator() throws MalformedURLException {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("appium:appActivity", "org.telegram.ui.LaunchActivity");
    	capabilities.setCapability("appium:appPackage", "org.telegram.messenger");
    	capabilities.setCapability("appium:automationName", "UiAutomator2");
    	capabilities.setCapability("appium:deviceName", "TECNO SPARK 20");
    	capabilities.setCapability("appium:newCommandTimeout", 300);
    	capabilities.setCapability("appium:noReset", true);
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("appium:platformVersion", "12");
    	capabilities.setCapability("appium:udid", "0977854319008892");

     

        // Connect to Appium server
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, capabilities);
        System.out.println("Application started");
    }
}
