package appiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UpdateItemTest extends BaseClass {

    private AppiumDriver driver;
    private AppNavigationHelpers navHelpers;

    @Before
    public void setUp() {
        super.setup();  // Call the setup method from BaseTest
        navHelpers = new AppNavigationHelpers(driver);  // Initialize helper class
    }

    @Test
    public void testNavigateToUpdateScreen() {
        // Locate the 'Update' button on the ItemDetailScreen
        By updateButtonLocator = By.xpath("//android.widget.TextView[@text='Update']");
        
        // Verify that the Update button is present
        Assert.assertTrue(isElementPresent(updateButtonLocator), "Update button is not present on the ItemDetailScreen");

        // Click the Update button
        driver.findElement(updateButtonLocator).click();

        // Wait for the UpdateScreen to load
        try {
            Thread.sleep(2000); // Replace with an explicit wait if possible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the presence of the title or a field on UpdateScreen to confirm navigation
        By updateScreenTitleLocator = By.xpath("//android.widget.TextView[@text='Create an Item']");
        Assert.assertTrue(isElementPresent(updateScreenTitleLocator), "Failed to navigate to the UpdateScreen");
    }

    @Test
    public void testFieldsPopulated() {
        // Assume that we've navigated to UpdateScreen after the first test
        By nameFieldLocator = By.id("com.example.mbl:id/name_input_field"); // Replace with correct ID
        By descriptionFieldLocator = By.id("com.example.mbl:id/description_input_field"); // Replace with correct ID

        // Verify that the name and description fields are pre-populated with the correct data
        String expectedName = "Sample Item Name"; // Replace with actual item name from test data
        String expectedDescription = "Sample Item Description"; // Replace with actual description

        Assert.assertEquals(driver.findElement(nameFieldLocator).getText(), expectedName, "Name field is not pre-populated correctly");
        Assert.assertEquals(driver.findElement(descriptionFieldLocator).getText(), expectedDescription, "Description field is not pre-populated correctly");
    }

    @Test
    public void testUpdateButtonEnabled() {
        // Assume that we've navigated to UpdateScreen after the first test
        By nameFieldLocator = By.id("com.example.mbl:id/name_input_field");
        By descriptionFieldLocator = By.id("com.example.mbl:id/description_input_field");
        By updateButtonLocator = By.id("com.example.mbl:id/update_button"); // Replace with the correct ID of the Update button

        // Test with both fields empty (button should be disabled)
        driver.findElement(nameFieldLocator).clear();
        driver.findElement(descriptionFieldLocator).clear();
        Assert.assertFalse(driver.findElement(updateButtonLocator).isEnabled(), "Update button should be disabled with empty fields");

        // Test with valid data (button should be enabled)
        driver.findElement(nameFieldLocator).sendKeys("New Item Name");
        driver.findElement(descriptionFieldLocator).sendKeys("New Item Description");
        Assert.assertTrue(driver.findElement(updateButtonLocator).isEnabled(), "Update button should be enabled with valid fields");
    }

    // Helper method to check if an element is present
    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

