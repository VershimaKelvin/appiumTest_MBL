package appiumtests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateItemTest extends BaseClass {

    private AndroidDriver driver;
    private WebDriverWait wait;
    
    @Before
    public void setUp() throws Exception {
        setup(); // Initialize driver from BaseClass
    }


    @Test
    public void testLogin() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        enterUsername("testuser");
        enterPassword("password123");
        clickLogin();

        // Assertion to verify successful login, e.g., checking a specific element is displayed
        MobileElement homeScreenElement = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("homeScreenElementId"))
        );
        Assert.assertTrue("Login failed, home screen element not displayed.", homeScreenElement.isDisplayed());
    }

    public void enterUsername(String username) {
        MobileElement usernameField = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("usernameFieldId"))
        );
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        MobileElement passwordField = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("passwordFieldId"))
        );
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        MobileElement loginButton = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(By.id("loginButtonId"))
        );
        loginButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
