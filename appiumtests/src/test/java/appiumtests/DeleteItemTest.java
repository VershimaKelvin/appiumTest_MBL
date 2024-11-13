package appiumtests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.flutter.android.FlutterAndroidDriver;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DeleteItemTest extends BaseClass {

    private AndroidDriver driver;
    private AppNavigationHelpers navHelpers;

    @Before
    public void setUp() {
        super.setup();  // Call the setup method from BaseTest
        navHelpers = new AppNavigationHelpers(driver);  // Initialize helper class
    }

    @Test
    public void testDeleteItem() {
        // Locate the item to delete
        String itemToDelete = "Item Name or Identifier"; // Replace with the exact item name or an identifying attribute
        By itemLocator = By.xpath("//android.widget.TextView[@text='" + itemToDelete + "']");

        // Verify that the item is present before deletion
        Assert.assertTrue(isElementPresent(itemLocator), "Item is not present before deletion");

        // Locate and tap the delete button/icon associated with the item
        By deleteButtonLocator = By.xpath("//android.widget.TextView[@text='" + itemToDelete + "']/following-sibling::android.widget.Button[@content-desc='delete']");
        driver.findElement(deleteButtonLocator).click();

        // Wait a moment to allow the delete action to process (adjust as necessary)
        try {
            Thread.sleep(2000); // Consider using an explicit wait instead
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the item is no longer present after deletion
        Assert.assertFalse(isElementPresent(itemLocator), "Item was not deleted successfully");
    }

    // Helper method to check if an element is present
    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
}

