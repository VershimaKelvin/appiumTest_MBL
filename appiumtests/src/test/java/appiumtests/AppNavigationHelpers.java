package appiumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

// Assuming this is part of a test class
public class AppNavigationHelpers {

    private AppiumDriver driver;

    // Constructor to initialize the driver
    public AppNavigationHelpers(AppiumDriver driver) {
        this.driver = driver;
    }

    // Helper method to perform login steps
    public void login(String username, String password) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")));
    	 WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")));
    	 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")));

       
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Optionally, add a wait or assert to confirm login succeeded
    }
    
    public void navigateToSignup() {
        WebElement signupText = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Sign Up\"]")); // Replace with the actual ID
        signupText.click();
    }
}
