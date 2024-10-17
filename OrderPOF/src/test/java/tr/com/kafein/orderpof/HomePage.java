package tr.com.kafein.orderpof;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    //private By homeLink = By.linkText("Home");
    @FindBy(linkText = "Home")
    private WebElement homeLink;

   // private By firstProductCard = By.cssSelector(".card:nth-child(1) h4");
    @FindBy(css = ".card:nth-child(1) h4")
    private List<WebElement> firstProductCard;

    //private By cartPriceLocator = By.xpath("/html/body/div[2]/div[2]/div[1]/div/h4/span/small");
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div/h4/span/small")
    private WebElement cartPrice;

    //private By submitButton = By.xpath("//button[@type='submit']");
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

   // private By checkOutButton = By.xpath("/html/body/div[2]/div/a[2]");
    @FindBy(xpath = "/html/body/div[2]/div/a[2]")
    private WebElement checkOutButton;

    //private By checkOutHeader = By.cssSelector("h2");
    @FindBy(css = "h2")
    private WebElement checkOutHeader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void selectProduct() {
        homeLink.click();
        Assertions.assertTrue(firstProductCard.size() > 0, "Product not found");
    }

    public void addToCart() {
        wait.until(ExpectedConditions.textToBePresentInElement(cartPrice, "$275.00"));
        submitButton.click();
    }

    public void goToCheckOut() {
        checkOutButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(checkOutHeader, "Check out now"));
    }
}