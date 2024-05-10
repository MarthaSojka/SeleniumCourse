package com.course.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    public static void fillInput(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static void clickButton(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public static void fillSelect(WebDriver driver, By locator, String text) {

        WebElement selectDays = driver.findElement(locator);
        Select select = new Select(selectDays);
        select.selectByValue(text);
    }

    public static void selectRadioButton(WebDriver driver, By locator, String parentText) {

        WebElement radioButtonElement = driver.findElement(locator);

        WebElement radioButtonElementParent = radioButtonElement.findElement(By.xpath(".."));


        String radioButtonElementAttribute = radioButtonElementParent.getAttribute("class");

        if (!radioButtonElementAttribute.equals(parentText)) {
            radioButtonElement.click();
        } else {
            System.out.println("RadioButton is selected");
        }
    }

    public static String getElementText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }


    // Gorsza metoda czekania na element
    public static void waitForElementLoaded(WebElement element, Integer milliseconds) {
        int attempts = 0;

        while (attempts < 3) {
            try {
                if (element.isDisplayed()) {
                    System.out.println("Found element: " + element.toString());
                    break;
                }
                Thread.sleep(milliseconds);
            } catch (Exception e) {
                System.out.println("Element not found by cause " + e.getMessage() + " attemts [" + attempts + "/3]");
            } finally {
                attempts++;
            }
        }
    }

    public static WebElement waitForElement(WebDriver driver, By locator, int timeOutSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));

        return wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public static WebElement waitForWebElement(WebDriver driver, WebElement element, int timeOutSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));

        return wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
