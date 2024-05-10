package TaskCheckConfig;

import com.course.selenium.Helper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchHelpersTest {
    WebDriver driver;

    private static final By BUTTON_NARZEDZIA = By.xpath("//*[contains(text(), 'Narzędzia')]");

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

    @Test
    public void googleSearchHelpers_test() {
        Helper.fillInput(driver, By.name("q"), "Jarek");
        Helper.waitForElement(driver, BUTTON_NARZEDZIA, 20);
        Assert.assertEquals("Title is incorrect", "Jarek - Szukaj w Google", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
