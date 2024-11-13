// BaseTest.java
package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

    protected static AppiumDriver driver;

    public void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:appActivity", "com.example.mbl.MainActivity");
            capabilities.setCapability("appium:appPackage", "com.example.mbl");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:deviceName", "TECNO SPARK 20");
            capabilities.setCapability("appium:platformVersion", "12");
            capabilities.setCapability("appium:udid", "192.168.1.101:5555");
           // capabilities.setCapability("newCommandTimeout", 200);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            System.out.println("Application started");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("The URL for Appium server is malformed.");
        }
    }

}
