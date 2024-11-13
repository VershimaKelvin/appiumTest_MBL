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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        
        WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[1]")));
        userNameField.sendKeys("vsnnnennses");
        System.out.println("Loaded username");

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[2]")));
        passwordField.sendKeys("ddfdssff");
        System.out.println("Loaded password");

        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[3]")));
        confirmPassword.sendKeys("ddfdssff");
        System.out.println("Loaded confirm password");

        try {
            WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.View[@content-desc=\"Register\"]")));
            System.out.println("Attempting to click the signup button.");
            signupButton.click();
            System.out.println("Clicked signup button.");
        } catch (Exception e) {
            System.out.println("Error during click: " + e.getMessage());
            e.printStackTrace();
        }

        // Wait for success indicator or screen navigation
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[@content-desc='Register']")));

        System.out.println("Account Created Successfully");
    }

}
