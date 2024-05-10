package com.course.selenium.FindElementsTests.By;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NameTest {

    WebDriver driver;
    Faker faker = new Faker();
    private static final By HOTEL_LOCATION = By.name("hotel_location");
    private static final By SEARCH_NOW = By.name("search_room_submit");
    private static final By NEWSLETTER_INPUT = By.name("email");
    private static final By NEWSLETTER_SUBMIT = By.name("submitNewsletter");

    String emailAddress = faker.internet().emailAddress();

    //GIVEN
    @Before
    public void setUp() {
        // Object WebDriver is a new instance of ChromeDriver()
        driver = new ChromeDriver();
        // Maximise window
        driver.manage().window().maximize();
        // Global wait for element if not already exists
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Open page
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        // Close cookie window
    }

    // WHEN
    @Test
    public void googleSearchName_test() {

        WebElement hotelLocationInput = driver.findElement(HOTEL_LOCATION);
        WebElement searchNowButton = driver.findElement(SEARCH_NOW);
        WebElement newsletterInput = driver.findElement(NEWSLETTER_INPUT);
        WebElement newsletterSubmitButton = driver.findElement(NEWSLETTER_SUBMIT);

        hotelLocationInput.clear();
        hotelLocationInput.sendKeys("Warsaw");

        newsletterInput.clear();
        newsletterInput.sendKeys(emailAddress);

        searchNowButton.submit();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
