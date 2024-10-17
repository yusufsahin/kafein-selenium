package tr.com.kafein.exportfromseleniumide;
import org.junit.Test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.*;

public class BasicOrderTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void basicOrder() {
        // Test name: BasicOrder
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("http://sportsstore.innovium.net/");
        // 2 | setWindowSize | 1920x981 |
        driver.manage().window().maximize();
        // 3 | click | linkText=Home |
        driver.findElement(By.linkText("Home")).click();
        // 4 | waitForElementVisible | css=.card:nth-child(1) h4 | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card:nth-child(1) h4")));
        }
        // 5 | click | xpath=//button[@type='submit'] |
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        // 6 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 7 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 8 | doubleClick | css=h2 |
        {
            WebElement element = driver.findElement(By.cssSelector("h2"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        // 9 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 10 | verifyElementPresent | css=h2 |
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("h2"));
            assert(elements.size() > 0);
        }
        // 11 | click | linkText=Checkout |
        driver.findElement(By.linkText("Checkout")).click();
        // 12 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 13 | waitForElementPresent | css=h2 | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        }
        // 14 | click | id=Name |
        driver.findElement(By.id("Name")).click();
        // 15 | type | id=Name | John Doe
        driver.findElement(By.id("Name")).sendKeys("John Doe");
        // 16 | click | id=Line1 |
        driver.findElement(By.id("Line1")).click();
        // 17 | type | id=Line1 | Abc Bulv
        driver.findElement(By.id("Line1")).sendKeys("Abc Bulv");
        // 18 | click | id=Line2 |
        driver.findElement(By.id("Line2")).click();
        // 19 | type | id=Line2 | No 5426
        driver.findElement(By.id("Line2")).sendKeys("No 5426");
        // 20 | click | id=Line3 |
        driver.findElement(By.id("Line3")).click();
        // 21 | type | id=Line3 | Block A
        driver.findElement(By.id("Line3")).sendKeys("Block A");
        // 22 | click | id=City |
        driver.findElement(By.id("City")).click();
        // 23 | type | id=City | Austin
        driver.findElement(By.id("City")).sendKeys("Austin");
        // 24 | click | id=State |
        driver.findElement(By.id("State")).click();
        // 25 | type | id=State | TX
        driver.findElement(By.id("State")).sendKeys("TX");
        // 26 | click | id=Zip |
        driver.findElement(By.id("Zip")).click();
        // 27 | type | id=Zip | 874262
        driver.findElement(By.id("Zip")).sendKeys("874262");
        // 28 | click | id=Country |
        driver.findElement(By.id("Country")).click();
        // 29 | type | id=Country | USA
        driver.findElement(By.id("Country")).sendKeys("USA");
        // 30 | click | css=.btn-primary |
        driver.findElement(By.cssSelector(".btn-primary")).click();
        // 31 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 32 | waitForElementPresent | css=h2 | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        }
        // 33 | assertText | css=h2 | Thanks!
       // assert(driver.findElement(By.cssSelector("h2")).getText(), is("Thanks!"));
        // 34 | click | linkText=Return to Store |
        driver.findElement(By.linkText("Return to Store")).click();
        // 35 | click | linkText=Home |
        driver.findElement(By.linkText("Home")).click();
    }
}
