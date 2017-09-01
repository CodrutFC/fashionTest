package com.page.contact;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test base that contains global test vars
 * driver initialisation and the set up and tear
 * down methods that are being called in the
 * runner
 */

public class TestBase {

    public final static String siteUrl = "http://qaworks.com";
    public static WebDriver driver;

    // Setup Chrome Driver for the test
    public static void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().to(siteUrl);
    }

    // Tear down method -  quiting the driver instance
    public static void tearDownTest() {
        driver.quit();
    }
}
