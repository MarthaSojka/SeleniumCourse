package com.course.selenium.FindElementsTests.By;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class ClassTest {

    WebDriver driver;
    Faker faker = new Faker();
    private static final By SIGN_IN = By.className("hide_xs");
    private static final By EMAIL_ADDRESS = By.className("form-control");
    private static final By CREATE_ACCOUNT = By.id("SubmitCreate");
    String emailAddress = faker.internet().emailAddress();

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void fillInputByClass_test() {

        WebElement signInButton = driver.findElement(SIGN_IN);
        signInButton.click();

        WebElement emailInput = driver.findElement(EMAIL_ADDRESS);
        emailInput.clear();
        emailInput.sendKeys(emailAddress);

        WebElement createAccount = driver.findElement(CREATE_ACCOUNT);
        createAccount.click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
