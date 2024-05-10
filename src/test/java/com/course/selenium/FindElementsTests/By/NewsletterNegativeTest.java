package com.course.selenium.FindElementsTests.By;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterNegativeTest {
    @FindBy(id="newsletter-input")
    private static WebElement notificationEnterEmailElement;

    @FindBy(css = ".newsletter-btn")
    private static WebElement newsletterButtonElement;

    @FindBy(css = ".alert.alert-danger")
    private static WebElement alertDangerElement;

    private static WebDriver driver;

    @Before
    public void chceck_email_alreadyRegistered_test() {
        driver.get("https://hotel-testlab.coderslap.pl/en/");
        notificationEnterEmailElement.sendKeys("test@test.com");
        newsletterButtonElement.click();



    }
}
