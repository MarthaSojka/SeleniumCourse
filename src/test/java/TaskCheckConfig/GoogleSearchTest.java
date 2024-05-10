package TaskCheckConfig;

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

public class GoogleSearchTest {

    WebDriver driver;

    // GIVEN
    // Preparing browser
    @Before
    public void setUp() {
        // Object WebDriver is a new instance of ChromeDriver()
        driver = new ChromeDriver();
        // Maximise window
        driver.manage().window().maximize();

        // In case of slow computer
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Open page
        driver.get("http://www.google.com");
        // Close cookie window
        WebElement elementCookiesWindow = driver.findElement(By.xpath("//button/*[contains(text(),'Zaakceptuj')]"));
        elementCookiesWindow.click();
    }

    // WHEN
    @Test
    public void googleSearchConfig_test() {


        // Find element "q"
        WebElement element = driver.findElement(By.name("q"));
        // Clear textarea
        element.clear();
        // Type text
        element.sendKeys("Coderslab");
        // Submit
        element.submit();

        // THAN
        // Add assertion about title
        Assert.assertEquals("Title is incorrect", "Coderslab - Szukaj w Google", driver.getTitle());

        // Add assertion about search result
        WebElement searchResult = driver.findElement(By.cssSelector(".RNNXgb textarea"));
        Assert.assertEquals("Coderslab", searchResult.getText());

        // Add assertion about logo
        WebElement logoGoogle = driver.findElement(By.cssSelector(".logo #logo"));
        Assert.assertTrue(logoGoogle.isDisplayed());
        Assert.assertEquals("Przejdź do strony głównej Google", logoGoogle.getAttribute("title"));

    }

    @After

    public void tearDown() {

        // Close driver and browser - prevent leak of memory!!!
        driver.quit();
    }
}
