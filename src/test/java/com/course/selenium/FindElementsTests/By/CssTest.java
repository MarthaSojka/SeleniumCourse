package com.course.selenium.FindElementsTests.By;

import com.course.selenium.Helper;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CssTest {
    WebDriver driver;
    Faker faker = new Faker();

    String email, password;
    String name, surname;
    String selectDays, selectMonth, selectYears;
    private static final By SIGN_IN_BUTTON = By.cssSelector(".hide_xs");
    private static final By EMAIL_ADDRESS_INPUT = By.cssSelector("#email_create");
    private static final By CREATE_ACCOUNT = By.cssSelector("#SubmitCreate");
    private static final By TITLE = By.cssSelector("#id_gender1");
    private static final By FIRST_NAME_INPUT = By.cssSelector("#customer_firstname");
    private static final By LAST_NAME_INPUT = By.cssSelector("#customer_lastname");
    private static final By EMAIL = By.cssSelector("#email");
    private static final By PASSWORD = By.cssSelector("#passwd");
    private static final By SELECT_DAYS = By.cssSelector("#days");
    private static final By SELECT_MONTH = By.cssSelector("#months");
    private static final By SELECT_YEAR = By.cssSelector("#years");

    private static final By REGISTER = By.cssSelector("#submitAccount");
    private static final By SUCCESS_ALERT = By.cssSelector(".alert.alert-success");
    private static final By MY_PERSONAL_INFORMATION = By.cssSelector(".myaccount-link-list > li:nth-child(5) > a > span");
    private static final By MY_ADDRESSES = By.cssSelector(".myaccount-link-list > li:nth-child(4) > a > span");

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://hotel-testlab.coderslab.pl/en");
        email = faker.internet().emailAddress();
        name = faker.name().firstName();
        surname = faker.name().lastName();
        password = "Password1";
        selectDays = "21";
        selectMonth = "6";
        selectYears = "2000";
    }

    @Test
    public void fillInputByCss_Test() {

        WebElement signInButton = driver.findElement(SIGN_IN_BUTTON);
        signInButton.click();

        // Instead of:
        /*
        WebElement emailInput = driver.findElement(EMAIL_ADDRESS_INPUT);
        emailInput.clear();
        emailInput.sendKeys(email);
         */
        // Better
        Helper.fillInput(driver, EMAIL_ADDRESS_INPUT, email);



        Helper.clickButton(driver, CREATE_ACCOUNT);

        // RADIO_BUTTON
        Helper.selectRadioButton(driver, TITLE, "checked");

        Helper.fillInput(driver, FIRST_NAME_INPUT, name);

        Helper.fillInput(driver, LAST_NAME_INPUT, surname);

        Helper.fillInput(driver, PASSWORD, password);

        // DROPDOWN MENU - SELECT:
        /* Instead of:
        WebElement selectDays = driver.findElement(SELECT_DAYS);
        Select days = new Select(selectDays);
        days.selectByValue("21");
        */
        // Better select:
        Helper.fillSelect(driver, SELECT_DAYS, selectDays);
        Helper.fillSelect(driver, SELECT_MONTH, selectMonth);
        Helper.fillSelect(driver, SELECT_YEAR, selectYears);

        Helper.clickButton(driver, REGISTER);


        String alertMessage = Helper.getElementText(driver, SUCCESS_ALERT);
        Assert.assertEquals("Your account has been created.", alertMessage);

        Assert.assertEquals("MY PERSONAL INFORMATION", Helper.getElementText(driver, MY_PERSONAL_INFORMATION));

        Assert.assertEquals("MY ADDRESSES", Helper.getElementText(driver, MY_ADDRESSES));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
