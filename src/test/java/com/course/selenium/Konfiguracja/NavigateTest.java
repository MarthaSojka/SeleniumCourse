package com.course.selenium.Konfiguracja;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://coderslab.pl");
    }

    @Test
    public void Navigate_test() {
        Assert.assertEquals("Kursy programowania – szkolenia, kursy IT (informatyczne) online, bootcamp programistyczny – Szkoła Programowania Coders Lab", driver.getTitle());

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Assert.assertEquals("mystore-testlab.coderslab.pl", driver.getTitle());


        driver.get("https://hotel-testlab.coderslab.pl/en/");
        Assert.assertEquals("MyBooking", driver.getTitle());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
