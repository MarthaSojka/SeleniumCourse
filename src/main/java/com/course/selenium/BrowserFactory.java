package com.course.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

    public static WebDriver initializeDriver(String driverType) {


        switch (driverType) {
            case "CHROME":
                return new ChromeDriver();
            case "FIREFOX":
                return new FirefoxDriver();

            default:
                throw new WebDriverException("->error: Browser name not found! Cannot initialize browser driver");
        }
    }

        /*
               return switch (driverType) {
            case "CHROME" -> new ChromeDriver();
            case "FIREFOX" -> new FirefoxDriver();

            default ->
                throw new WebDriverException("->error: Browser name not found! Cannot initialize browser driver");
            };
        }
         */

        // Można w niej zawrzeć maximize window, confirm cookies
/*
        switch (driverType) {
            case "CHROME":
            {
                // Dla starszych wersji
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
            }
            case "FIREFOX":
            {
                // Dla starszych werjsji
//                System.setProperty("webdriver.geco.driver", "src/main/resources/drivers/gecodriver.exe");
//
//                String pathBinary = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
//
                DesiredCapabilities desired = new DesiredCapabilities();
                FirefoxOptions options = new FirefoxOptions();
                desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(pathBinary));
                return new FirefoxDriver(options);
            }
            default:
                throw new WebDriverException("->error: Browser name not found! Cannot initialize browser driver");
        }
    }
*/

}
