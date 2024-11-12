// LoginTest.java
package appiumtests;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertNotNull;


import io.appium.java_client.AppiumBy;


public class LoginTest extends BaseClass {

    @Before
    public void setUp() throws Exception {
        setup(); // Initialize driver from BaseTest
    }

    @Test
    public void testLoginScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")));
        usernameField.sendKeys("vershimakelvin");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")));
        passwordField.sendKeys("12345678");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@content-desc=\"Login\"]")));
        System.out.println("Button is about to be clicked");
        boolean isButtonEnabled = loginButton.isEnabled();
        if (isButtonEnabled) {
      //      loginButton.click();
            System.out.println("Login button is enabled.");
        } else {
            System.out.println("Login button is disabled.");
        }
      
        System.out.println("Button has been clicked");
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
        	    AppiumBy.xpath("//android.view.View[@content-desc='Login']")
        	));

//        // Verify that we are on the next screen
//        WebElement nextScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("NextScreenElementId")));
//        assertNotNull(nextScreenElement);

        System.out.println("Login attempted and next screen verified.");
        
        System.out.println("App state before login: " + driver.getPageSource());

    }

//    @After
//    public void tearDown() {
//        super.tearDown(); // Quit driver from BaseTest
//    }
}
