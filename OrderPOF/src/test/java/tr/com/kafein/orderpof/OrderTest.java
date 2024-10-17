package tr.com.kafein.orderpof;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class OrderTest {

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void order() {
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheckOut();

        // Order details
        orderPage.enterDetails("John Doe", "ABC Blv.", "12436 St.", "No 5436", "Austin", "TX", "56432", "USA");
        orderPage.submitOrder();
        Assertions.assertEquals(orderPage.getConfirmationText(), "Thanks!");

        orderPage.returnToStore();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}