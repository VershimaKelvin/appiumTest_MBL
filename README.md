# MBL QA Task Test Setup and Execution Guide

This guide will walk you through the process of setting up and running the Appium tests for this project. Follow each step carefully to ensure that the tests are set up correctly on your device. You will need the apk installed on your real device. You can build the apk from this repo [QA Task App Repo](https://appium.io/docs/en/about-appium/intro/) instructions on how to build the apk can be found in the Readme section of the repo.

---

## Prerequisites
To setup your testing environment follow the steps below. if you run into errors while setting up your testing environment please refer to this youtube playlist for a more detailed walkthrouh [here]([https://appium.io/docs/en/about-appium/intro/](https://www.youtube.com/playlist?list=PLhW3qG5bs-L8npSSZD6aWdYFQ96OEduhk))

1. **Java Development Kit (JDK)**
   - Ensure you have **JDK 8 or later** installed.
   - Add the path to the JDK bin in your environment variables.
   - Verify Java installation by running:
     ```bash
     java -version
     ```
   - If Java is not installed, download and install it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Android SDK**
   - Install the Android SDK, which can be done via Android Studio.
   - Add Android SDK's `platform-tools` and `tools` to your system path.
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

6. **Mobile Device or Emulator**
   - A physical Android device with **Developer Mode** and **USB Debugging** enabled, or an Android emulator.
   - For emulators, you can create one using Android Studio.

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
   - Example configuration for an Android device:
     ```java
     capabilities.setCapability("platformName", "Android");
     capabilities.setCapability("deviceName", "<Your Device Name>");
     capabilities.setCapability("appPackage", "<Your App Package>");
     capabilities.setCapability("appActivity", "<Your App Activity>");
     ```

4. **Start Appium Server**
   - Start the Appium server by running:
     ```bash
     appium
     ```
   - Alternatively, you can start Appium Desktop and click on "Start Server".

---

## Running Tests

1. **Connect Your Device**
   - Connect your Android device to your computer via USB or ensure your emulator is running.
   - Verify that the device is detected by running:
     ```bash
     adb devices
     ```
   - You should see your device listed as connected.

2. **Run the Tests**
   - To run the tests, execute the following command:
     ```bash
     mvn test
     ```

3. **View Test Results**
   - Test results will be displayed in the console.
   - Detailed reports (if configured) will be available in the `target/surefire-reports` directory after the tests complete.

---

## Troubleshooting

- **Common Issues**:
  - If you encounter `StaleElementReferenceException`, refer to the codebase for retry mechanisms or increase the wait time in `WebDriverWait`.
  - Ensure that the `appPackage` and `appActivity` values in `BaseClass.java` are accurate and match the application being tested.
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
        capabilities.setCapability("appPackage", "YOUR_APP_PACKAGE");
        capabilities.setCapability("appActivity", "YOUR_APP_ACTIVITY");

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
