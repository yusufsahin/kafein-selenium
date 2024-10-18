package tr.com.kafein.exportfromside;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPagePF {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "Name")
    private WebElement nameField;

    @FindBy(id = "Line1")
    private WebElement line1Field;

    @FindBy(id = "Line2")
    private WebElement line2Field;

    @FindBy(id = "Line3")
    private WebElement line3Field;

    @FindBy(name = "City")
    private WebElement cityField;

    @FindBy(name = "State")
    private WebElement stateField;

    @FindBy(name = "Zip")
    private WebElement zipField;

    @FindBy(name = "Country")
    private WebElement countryField;

    @FindBy(xpath = "/html/body/div[2]/div[2]/form/div[10]/input")
    private WebElement submitOrderButton;

    @FindBy(css = "h2")
    private WebElement thanksMessage;

    @FindBy(xpath = "/html/body/div[2]/div/a")
    private WebElement returnToStoreLink;


    public OrderPagePF(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // Initialize Page Factory

    }

    public void enterDetails(String name, String line1, String line2, String line3, String city, String state, String zip, String country) {
        nameField.sendKeys(name);
        line1Field.sendKeys(line1);
        line2Field.sendKeys(line2);
        line3Field.sendKeys(line3);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zip);
        countryField.sendKeys(country);
    }

    public void submitOrder() {
        submitOrderButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(thanksMessage, "Thanks!"));
    }

    public void returnToStore() {
        returnToStoreLink.click();
    }

    public String getConfirmationText() {
        return thanksMessage.getText();
    }

}
