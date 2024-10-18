package tr.com.kafein.ordertestbdd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    @FindBy(linkText = "Chess")
    private WebElement selectCategory;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private  WebElement addToCartButton;

    @FindBy(linkText = "Checkout")
    private WebElement checkoutButton;

    @FindBy(css = "h2")
    private WebElement pageHeader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage selectCatergory(String catergory) {
        selectCategory.click();

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card:nth-child(1) h4")));

        return this;
    }

    public HomePage addtoCart(int productIndex) {
        addToCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        return this;
    }

    public HomePage goToCheckOut() {
        checkoutButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        return this;
    }
}
