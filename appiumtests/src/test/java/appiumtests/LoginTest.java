// LoginTest.java
package appiumtests;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;

public class LoginTest extends BaseClass {

    @Before
    public void setUp() throws Exception {
        setup(); // Initialize driver from BaseClass
    }

    @Test
    public void testLoginScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        try {
            // Locate and enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.EditText[1]")));
            usernameField.sendKeys("vershimakelvin");
            System.out.println("Username added");

            // Validate username entry
            String enteredUsername = usernameField.getText();
            if (!"vershimakelvin".equals(enteredUsername)) {
                System.out.println("Username entry failed, retrying...");
                usernameField.clear();
                usernameField.sendKeys("vershimakelvin");
            }
            
            System.out.println(usernameField.getText());

            // Locate and enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.EditText[2]")));
            passwordField.sendKeys("12345678");
            System.out.println("Password added");

            // Validate password entry
            String enteredPassword = passwordField.getText();
            if (!"12345678".equals(enteredPassword)) {
                System.out.println("Password entry failed, retrying...");
                passwordField.clear();
                passwordField.sendKeys("12345678");
            }
            System.out.println(passwordField.getText());
         
            // Locate and click the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")));
            System.out.println("Attempting to click the login button.");
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
