package tr.com.kafein.orderreusablev2;

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
    private WebDriverWait wait;

    // Locators
    private By homeLink = By.linkText("Home");
    private By firstProductCard = By.cssSelector(".card:nth-child(1) h4");
    private By cartPriceLocator = By.xpath("/html/body/div[2]/div[2]/div[1]/div/h4/span/small");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By checkOutButton = By.xpath("/html/body/div[2]/div/a[2]");
    private By checkOutHeader = By.cssSelector("h2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectProduct() {
        driver.findElement(homeLink).click();
        List<WebElement> elements = driver.findElements(firstProductCard);
        Assertions.assertTrue(elements.size() > 0, "Product not found");
    }

    public void addToCart() {
        wait.until(ExpectedConditions.textToBe(cartPriceLocator, "$275.00"));
        driver.findElement(submitButton).click();
    }

    public void goToCheckOut() {
        driver.findElement(checkOutButton).click();
        wait.until(ExpectedConditions.textToBe(checkOutHeader, "Check out now"));
    }
}