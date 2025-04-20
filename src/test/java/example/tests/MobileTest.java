package example.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileTest {
    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, options);
    }

    @Test
    public void testAddition() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        assertEquals("12", result);
    }

    @Test
    public void testMultiplication() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        assertEquals("12", result);
    }

    @Test
    public void testNegative() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click(); // Division by 0
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_preview']")).getText();
        Assertions.assertTrue(result.contains("Can't divide by 0") || result.contains("Error"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}