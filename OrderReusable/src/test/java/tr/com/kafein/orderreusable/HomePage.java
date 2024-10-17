package tr.com.kafein.orderreusable;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void selectProduct() {
        driver.findElement(By.linkText("Home")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".card:nth-child(1) h4"));
            Assertions.assertTrue(elements.size() > 0);
        }
    }
        public void addToCard(){
            {
                WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.textToBe( By.xpath("/html/body/div[2]/div[2]/div[1]/div/h4/span/small"),"$275.00"));
            }
            driver.findElement(By.xpath("//button[@type=\'submit\']")).click();

        }

        public void goToCheckout() {
           driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

            {
                WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
                wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"),"Check out now"));
            }
        }
}
