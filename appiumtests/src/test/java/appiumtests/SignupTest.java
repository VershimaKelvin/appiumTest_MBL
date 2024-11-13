package appiumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import java.time.Duration;
import org.junit.Before;
import org.junit.Test;

public class SignupTest extends BaseClass {

    private AppNavigationHelpers navHelpers;

    @Before
    public void setUp() {
        super.setup();  // Call the setup method from BaseTest
        navHelpers = new AppNavigationHelpers(driver);  // Initialize helper class
    }

    @Test
    public void testSignupFlow() {
        navHelpers.navigateToSignup();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        try {
            // Locate the fields with retry to avoid stale element issues
            WebElement userNameField = locateElementWithRetry(wait, AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
            WebElement passwordField = locateElementWithRetry(wait, AppiumBy.xpath("//android.widget.EditText[2]"));
            WebElement confirmPassword = locateElementWithRetry(wait, AppiumBy.xpath("//android.widget.EditText[3]"));

            confirmPassword.sendKeys("ddfdssff");
            System.out.println("Loaded confirm password");

            // Attempt to interact with the signup button
            WebElement signupButton = locateElementWithRetry(wait, By.xpath("//android.view.View[@content-desc=\"Register\"]"));

            // Interact with the userNameField with retries
//            userNameField.click();
            userNameField.clear();
            userNameField.sendKeys("12345678");

            System.out.println("Attempting to click the signup button.");
            signupButton.click();
            System.out.println("Clicked signup button.");

            // Wait for success indicator or screen navigation
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    AppiumBy.xpath("//android.view.View[@content-desc='Register']")));

            System.out.println("Account Created Successfully");
        
        } catch (Exception e) {
            System.out.println("An error occurred during signup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to locate elements with retry logic for staleness
    private WebElement locateElementWithRetry(WebDriverWait wait, By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Encountered StaleElementReferenceException. Retrying... Attempt " + (attempts + 1));
                attempts++;
            }
        }
        throw new RuntimeException("Element could not be located due to repeated stale references.");
    }
}
