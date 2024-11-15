// LoginTest.java
package appiumtests;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver; 
import io.appium.java_client.clipboard.ClipboardContentType;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

public class LoginTest extends BaseClass {

    @Before
    public void setUp() throws Exception {
        setup(); 
    }

    @Test
    public void testLoginScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        try {
            // Locate and enter userName
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")));
            usernameField.click();
            driver.executeScript("mobile: performEditorAction", 
            	    ImmutableMap.of("action", "setText", "text", "vershimakelvin"));
            usernameField.clear();
            
            //You can change the key here to whatever userName you want to use
            usernameField.sendKeys("vershimakelvin");
            System.out.println("Username added");

         

            // Locate and enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")));
            usernameField.click();
            driver.executeScript("mobile: performEditorAction", 
            	    ImmutableMap.of("action", "setText", "text", "12345678"));
            passwordField.click();
            
            //You can change the key here to the password of the account
            passwordField.sendKeys("12345678");
            System.out.println("Password added");

         
            // Locate and click the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")));
            System.out.println("Attempting to click the login button.");
            System.out.println(passwordField.getText());
            System.out.println(usernameField.getText());
            loginButton.click();
            System.out.println("Clicked login button.");

            
            // Wait until the login button is no longer visible, indicating navigation to the next screen
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    AppiumBy.xpath("//android.view.View[@content-desc='Login']")));
            System.out.println("Login screen is no longer visible.");

            System.out.println("Login attempted and next screen verified.");

        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
            e.printStackTrace();
        }

        // Debug the app state to review layout before and after login
        System.out.println("App state after attempting login: " + driver.getPageSource());
    }
}
