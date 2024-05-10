package com.course.selenium.FindElementsTests.By;

import com.course.selenium.BrowserFactory;
import com.course.selenium.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterNegativeTest {
    @FindBy(id="newsletter-input")
    private static WebElement notificationEnterEmailElement;

    @FindBy(css = ".newsletter-btn")
    private static WebElement newsletterButtonElement;

    @FindBy(css = ".alert.alert-danger")
    private static WebElement alertDangerElement;

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.initializeDriver("FIREFOX");
        driver.manage().window().maximize();

        // Initialize driver in our test class
        PageFactory.initElements(driver, this);

    }

    @Test
    public void chceck_email_alreadyRegistered_test() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        notificationEnterEmailElement.sendKeys("test@test.com");
        newsletterButtonElement.click();

        Helper.waitForWebElement(driver, alertDangerElement, 20);
        Assert.assertEquals("Newsletter : This email address is already registered.", alertDangerElement.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
