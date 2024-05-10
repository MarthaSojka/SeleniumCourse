package com.course.selenium.Konfiguracja;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateMethodsTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.get("https://coderslab.pl/pl");
    }

    @Test
    public void NavigateMethods_test() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());

        driver.get("https://coderslab.pl/pl");
        Assert.assertEquals("Kursy programowania – szkolenia, kursy IT (informatyczne) online, bootcamp programistyczny – Szkoła Programowania Coders Lab", driver.getTitle());

        driver.navigate().back();
        Assert.assertEquals("Google", driver.getTitle());

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Assert.assertEquals("mystore-testlab.coderslab.pl", driver.getTitle());

        driver.navigate().back();
        Assert.assertEquals("Google", driver.getTitle());

        driver.navigate().forward();
        Assert.assertEquals("mystore-testlab.coderslab.pl", driver.getTitle());

        driver.navigate().refresh();
        Assert.assertEquals("mystore-testlab.coderslab.pl", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
