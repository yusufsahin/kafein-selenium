package tr.com.kafein.orderreusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails()
    {
        driver.findElement(By.id("Name")).click();
        // 15 | type | id=Name | John Doe
        driver.findElement(By.name("Name")).sendKeys("John Doe");
        // 16 | click | id=Line1 |
        driver.findElement(By.id("Line1")).click();
        // 17 | type | id=Line1 | Abc Bulv
        driver.findElement(By.name("Line1")).sendKeys("Abc Bulv");
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
    }

    public  void submitOrder()
    {
        //input.btn

       //.btn-primary
        ///html/body/div[2]/div[2]/form/div[10]/input
       // driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div[10]/input")).click();

        // 31 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 32 | waitForElementPresent | css=h2 | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        }
    }

    public  void returnToStore()
    {
        driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();
    }

    public String getConfirmationText() {

        return  driver.findElement(By.cssSelector("h2")).getText();
    }
}
