# Appium UI Testing Project

This project demonstrates how to automate UI testing of an Android app using Appium with Java and Maven in IntelliJ IDEA.

## Prerequisites

Make sure you have the following installed:

- **Java**: JDK 8 or higher
- **IntelliJ IDEA**: For Java development
- **Maven**: For managing dependencies
- **Appium**: Version 1.22.3
- **Android Studio**: With Android Emulator
- **Appium Desktop**: For inspecting elements and managing Appium sessions
- **Calculator app** (`com.google.android.calculator`) on Android Emulator

## Setup Instructions

### 1. Install Dependencies

- **Java JDK**: Install JDK 8 or higher and set up the JAVA_HOME environment variable.
- **Maven**: Install Maven by following the instructions on the [official site](https://maven.apache.org/install.html).
- **Appium**: Install Appium globally using the following command:
  ```bash
  npm install -g appium@1.22.3
Appium Desktop: Download and install Appium Desktop from here.

2. Create a New Maven Project in IntelliJ IDEA
Open IntelliJ IDEA and create a new Maven project.

Add the necessary dependencies in your pom.xml file.

3. Update pom.xml
xml

<dependencies>
    <!-- Appium Dependency -->
    <dependency>
        <groupId>io.appium</groupId>
        <artifactId>java-client</artifactId>
        <version>8.2.1</version>
    </dependency>
    <!-- Selenium WebDriver Dependency -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    <!-- TestNG Dependency (for running tests) -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
4. Configure Appium
Start Appium server using the following command:

5. Run the Test
To run the test:

Start the Appium server (if you haven't already).

Run the test class in IntelliJ IDEA using TestNG.

7. Using Appium Inspector
Appium Inspector is a tool to inspect elements in your mobile application. Here's how you can use it:

Open Appium Desktop and start the server.

Click on the "Start New Session" button.

Enter the desired capabilities (same as those used in your test).

Click "Start Session."

Use the Inspector to find element locators for your test (e.g., id, xpath, etc.).

Troubleshooting
Ensure the Appium server is running before you execute tests.

Check the device/emulator is connected and has the app installed.

If the test fails, inspect the logs for detailed error messages.

Conclusion
This project provides a simple example of how to automate UI testing on an Android app using Appium and Java. You can expand on this by adding more test cases, integrating with CI tools, and writing advanced tests.

