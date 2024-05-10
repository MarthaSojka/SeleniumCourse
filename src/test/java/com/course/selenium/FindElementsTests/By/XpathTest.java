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


public class XpathTest {
    Faker faker = new Faker();
    WebDriver driver;
    String email, password;
    String name, surname;
    String selectDays, selectMonth, selectYears;
    private static final By SIGN_IN_BUTTON = By.xpath("//a[@class='user_login navigation-link']");
    private static final By EMAIL_ADDRESS_INPUT = By.xpath("//input[@id='email_create']");
    private static final By CREATE_ACCOUNT = By.xpath("//button[@id='SubmitCreate']");
    private static final By TITLE = By.xpath("//input[@id='id_gender2']");
    private static final By FIRST_NAME_INPUT = By.xpath("//input[@id='customer_firstname']");
    private static final By LAST_NAME_INPUT = By.xpath("//input[@id='customer_lastname']");
    private static final By EMAIL = By.xpath("//input[@id='email']");
    private static final By PASSWORD = By.xpath("//input[@id='passwd']");
    private static final By SELECT_DAYS = By.xpath("//select[@id='days']");
    private static final By SELECT_MONTH = By.xpath("//select[@id='months']");
    private static final By SELECT_YEAR = By.xpath("//select[@id='years']");
    private static final By REGISTER = By.xpath("//button[@id='submitAccount']");
    private static final By SUCCESS_ALERT = By.cssSelector(".alert.alert-success");


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
    public void createAccountByXpath_Test() {

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

        WebElement alertElement = driver.findElement(SUCCESS_ALERT);
        String alertMessage = alertElement.getText();
        Assert.assertEquals("Your account has been created.", alertMessage);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
