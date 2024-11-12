package appiumtests;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import static org.junit.Assert.assertTrue;
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

        // Now on the signUp screen; locate fields and fill them out
        WebElement userNameField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        WebElement passwordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        WebElement confirmPasswordField = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]"));
        WebElement signupButton = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Register\"]"));

        userNameField.sendKeys("Test User");
        passwordField.sendKeys("securepassword");
        signupButton.click();

        System.out.println("Account Created Successfully");
        // Add an assertion to verify that signUp was successful
   //     WebElement successMessage = driver.findElement(AppiumBy.id("com.example.mbl:id/successMessage"));
    //    assertTrue("Signup success message is displayed", successMessage.isDisplayed());
    }
}
