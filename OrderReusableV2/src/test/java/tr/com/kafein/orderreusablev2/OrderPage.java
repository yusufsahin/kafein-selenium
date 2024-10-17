package tr.com.kafein.orderreusablev2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.name("Name");
    private By line1Field= By.id("Line1");
    private By line2Field= By.id("Line2");
    private By line3Field = By.id("Line3");
    private By cityField = By.name("City");
    private By stateField = By.name("State");
    private By zipField = By.name("Zip");
    private By countryField = By.name("Country");
    private By submitOrderButton = By.xpath("/html/body/div[2]/div[2]/form/div[10]/input");
    private By thanksMessage = By.cssSelector("h2");
    private By returnToStoreLink = By.xpath("/html/body/div[2]/div/a");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterDetails(String name, String line1, String line2, String line3, String city, String state, String zip, String country) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(line1Field).sendKeys(line1);
        driver.findElement(line2Field).sendKeys(line2);
        driver.findElement(line3Field).sendKeys(line3);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(countryField).sendKeys(country);
    }

    public void submitOrder() {
        driver.findElement(submitOrderButton).click();
        wait.until(ExpectedConditions.textToBe(thanksMessage, "Thanks!"));
    }

    public void returnToStore() {
        driver.findElement(returnToStoreLink).click();
    }

    public String getConfirmationText() {
        return driver.findElement(thanksMessage).getText();
    }

}
