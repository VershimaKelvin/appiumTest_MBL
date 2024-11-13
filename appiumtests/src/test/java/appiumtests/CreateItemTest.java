package appiumtests;

import io.appium.java_client.android.AndroidDriver;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateItemTest extends BaseClass{
	
    private AndroidDriver driver;
    private AppNavigationHelpers navHelpers;
    

    @Before
    public void setUp() {
        super.setup();  // Call the setup method from BaseTest
        navHelpers = new AppNavigationHelpers(driver);  // Initialize helper class
    }

    
    @Test
    public void testCreateItemScreen() {
        // Locate elements
        WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Enter item name']"));
        WebElement descriptionField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Item description']"));
        WebElement createButton = driver.findElement(By.xpath("//android.widget.Button[@text='Create Item']"));

        // Verify that the "Create Item" button is initially disabled
        Assert.assertFalse(createButton.isEnabled(), "Create Item button should be disabled initially.");

        // Enter valid input into the Name field
        nameField.sendKeys("Sample Item Name");

        // Verify that the Create button is still disabled without description
        Assert.assertFalse(createButton.isEnabled(), "Create Item button should be disabled if description is empty.");

        // Enter valid input into the Description field
        descriptionField.sendKeys("This is a sample item description.");

        // Verify that the Create button is enabled after valid inputs
        Assert.assertTrue(createButton.isEnabled(), "Create Item button should be enabled after valid input.");

        // Tap the "Create Item" button
        createButton.click();

        // Verify the item creation was successful - for example, checking for a confirmation message
        WebElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Item created successfully']"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should appear after item creation.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
