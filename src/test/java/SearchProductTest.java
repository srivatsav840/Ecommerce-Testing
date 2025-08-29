import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchProductTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void testSearchProduct() {
        driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        boolean result = driver.getPageSource().contains("laptop");
        Assert.assertTrue(result);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
