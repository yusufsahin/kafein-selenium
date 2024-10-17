package tr.com.kafein.orderreusable;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class OrderTest {
    private WebDriver driver;
    HomePage homePage;
    OrderPage orderPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrder() {
        homePage.selectProduct();
        homePage.addToCard();
        homePage.goToCheckout();

        //Order

        orderPage.enterDetails();
        orderPage.submitOrder();
        Assertions.assertEquals(orderPage.getConfirmationText(),"Thanks!");
        orderPage.returnToStore();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}