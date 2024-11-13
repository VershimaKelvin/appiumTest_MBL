# MBL QA Task Test Setup and Execution Guide

This guide will walk you through the process of setting up and running the Appium tests for this project. Follow each step carefully to ensure that the tests are set up correctly on your device. You will need the apk installed on your real device. You can build the apk from this repo [QA Task App Repo](https://appium.io/docs/en/about-appium/intro/) instructions on how to build the apk can be found in the Readme section of the repo. Also we will be using an Android real device to run our test.

---

## Prerequisites
To setup your testing environment follow the steps below. if you run into errors while setting up your testing environment please refer to this youtube playlist for a more detailed walkthrouh [here](https://www.youtube.com/playlist?list=PLhW3qG5bs-L8npSSZD6aWdYFQ96OEduhk)

1. **Java Development Kit (JDK)**
   - Ensure you have **JDK 8 or later** installed.
   - Add the path to the JDK bin in your environment variables under PATH. The path should look like this
     ```bash
     C:\Program Files\Java\jdk-23\bin
     ```
   - Verify Java installation by running:
     ```bash
     java -version
     ```
   - If Java is not installed, download and install it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Android SDK**
   - Install the Android SDK, which can be done via Android Studio.
   - Add Android SDK's `platform-tools` and `tools` to your system path. The path usually looks like this
      platform tools
     ```bash
     C:\Users\Admin\AppData\Local\Android\Sdk\platform-tools
     ```
     command-line tools
     ```bash
     C:\Users\Admin\AppData\Local\Android\Sdk\cmdline-tools\latest\bin
     ```
   - Verify installation by running:
     ```bash
     adb version
     ```

3. **Appium**
   - Install Appium globally via npm:
     ```bash
     npm install -g appium
     ```
   - Verify the installation by running:
     ```bash
     appium -v
     ```

4. **Appium Inspector (Optional)**
   - For inspecting and identifying elements, download Appium Inspector from [here](https://github.com/appium/appium-inspector).

5. **Maven (Build Tool)**
   - Install Maven to manage project dependencies.
   - Verify Maven installation by running:
     ```bash
     mvn -v
     ```
   - If Maven is not installed, you can download and install it from [here](https://maven.apache.org/download.cgi).

6. **Eclipse IDE**
   - Download and install Eclipse IDE
   - Make all necessary configurations and foloow setup as prompted
     
7. **Mobile Device**
   We will be using a real android device to run our test, so you will need to enable developer settings on your device
   - Go to the Settings app on your Android device.
   - Scroll down and tap on About phone (or About device in some devices).
   - Find the Build number section. It's usually located at the bottom of the About phone section.
   - Tap on Build number 7 times in quick succession. You may need to enter your device's PIN or password to confirm.
   - After the seventh tap, you'll see a message that says: "You are now a developer!"
   - Go back to the Settings screen.You will now see a new section called Developer options or System (depending on the Android version).
   - Tap on Developer options and toggle the switch to enable it.
   - Once enabled, you can configure various options, including USB debugging, Stay awake, OEM unlocking, and more.
   - In the Developer options menu, find and enable USB debugging.

---

## Project Setup

1. **Clone the Repository**
   - Clone the project repository to your local machine:
     ```bash
     git clone <repository-url>
     cd <repository-name>
     ```

2. **Install Dependencies**
   - Run the following command to download and install project dependencies:
     ```bash
     mvn clean install
     ```

3. **Configure Desired Capabilities**
   - Update the `BaseClass.java` file to set up the correct **desired capabilities** for your device or emulator.
   - I have done the key configurations, only change where i am specified as <Your device> 
     ```java
     capabilities.setCapability("platformName", "Android");
     capabilities.setCapability("deviceName", "<Your Device Name>");
     capabilities.setCapability("deviceName", "<Your Device uid>");
     capabilities.setCapability("appPackage", "com.example.mbl");
     capabilities.setCapability("appActivity", "com.example.mbl.MainActivity");
     ```
     - to get your device uid, connect your android device and run the command in terminal
        ```bash
         adb devices 
        ```
      - you should get a list of connected devices, the number by the left is your device uid

4. **Start Appium Server**
   - Start the Appium server by running:
     ```bash
     appium
     ```

---

## Running Tests

1. **Connect Your Device**
   - Connect your Android device to your computer via USB
   - Verify that the device is detected by running:
     ```bash
     adb devices
     ```
   - You should see your device listed as connected.
  
2. **Start Appium server
   - Start the Appium server by running:
     ```bash
     appium
     ```

3. **Run the Tests**
   - Open Eclipse IDE and open the folder cloned
   - I have created diffrent files to handle test for diffrent features like login, signup, create item etc
   - You can run test for a particular feature by opening the file of that feature and click run on your eclipse IDE

4. **View Test Results**
   - Test results will be displayed in the console.

---

## Troubleshooting

- **Common Issues**:
  - If you encounter `StaleElementReferenceException`, refer to the codebase for retry mechanisms or increase the wait time in `WebDriverWait`.
  - If Appium doesn’t detect your device, make sure **USB Debugging** is enabled on the device and run `adb devices` to verify the connection.

---

## Additional Tools

- **Appium Inspector**: Useful for locating elements in your mobile application and viewing the application hierarchy. Launch Appium Inspector to connect it to the Appium server and your device.
- **Logs**: Check logs in the console where Appium server is running for debugging details. This includes any output related to your test execution, element locators, or capability configurations.

---

## Sample `BaseClass.java`

Here is a sample configuration for `BaseClass.java` to get you started with the necessary capabilities and configurations.

```java
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    protected AppiumDriver<MobileElement> driver;

    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "YOUR_DEVICE_NAME");
        capabilities.setCapability("appPackage", "com.example.mbl");
        capabilities.setCapability("appActivity", "com.example.mbl.MainActivity");

        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```
Incase of a blocker, reach out to me via whatsapp +2349061140728 or kelvinityavyar@gmail.com
