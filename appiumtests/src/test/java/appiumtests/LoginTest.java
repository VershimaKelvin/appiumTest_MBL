package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

public class LoginTest {

    static AppiumDriver driver;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            opencalculator();
            locateElements();
        } catch (Exception exp) {
            exp.printStackTrace(); // Prints the full stack trace for debugging
            System.out.println(exp.getMessage());
        }
    }

    public static void opencalculator() throws MalformedURLException {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("appium:appActivity", "com.example.mbl.MainActivity");
    	capabilities.setCapability("appium:appPackage", "com.example.mbl");
    	capabilities.setCapability("appium:automationName", "UiAutomator2");
    	capabilities.setCapability("appium:deviceName", "TECNO SPARK 20");
    	capabilities.setCapability("appium:newCommandTimeout", 300);
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("appium:platformVersion", "12");
    	capabilities.setCapability("appium:udid", "0977854319008892");

     

        // Connect to Appium server
        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, capabilities);
        System.out.println("Application started");
    }
    
    public static void locateElements() {
        // Locate an element using MobileBy Acc essibilityId (if available)
    	 driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]\r\n"
    	 		)).sendKeys("vershimakelvin");
        System.out.println("Got username Element");
        // Locate an element using MobileBy.AndroidUIAutomator (example)
        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")).sendKeys("123456789");
        // Interacting with elements
        System.out.println("Got password Element");

    }
}
