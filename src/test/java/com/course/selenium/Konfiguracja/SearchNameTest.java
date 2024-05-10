package com.course.selenium.Konfiguracja;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class SearchNameTest {

    WebDriver driver;

    //GIVEN
    @Before
    public void setUp() {
    // Object WebDriver is a new instance of ChromeDriver()
    driver =new ChromeDriver();
    // Maximise window
    driver.manage().window().maximize();
    // Global wait for element if not already exists
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    // Open page
    driver.get("http://www.google.com");
    // Close cookie window
    }

    // WHEN
    @Test
    public void googleSearchName_test() {

        WebElement elementCookiesWindow = driver.findElement(By.xpath("//button/*[contains(text(),'Zaakceptuj')]"));
        elementCookiesWindow.click();
        // Find element "q"
        WebElement element = driver.findElement(By.name("q"));
        // Clear textarea
        element.clear();
        // Type text
        element.sendKeys("Marta");
        // Submit
        element.submit();

        // THEN
        // Add assertion
        Assert.assertEquals("Title is incorrect", "Marta - Szukaj w Google", driver.getTitle());

        // Close driver and browser - prevent leak of memory!!!
        driver.quit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
