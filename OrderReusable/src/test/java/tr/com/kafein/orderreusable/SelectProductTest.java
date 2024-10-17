package tr.com.kafein.orderreusable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class SelectProductTest {

    private WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void  setUp()
    {
        ChromeOptions options= new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage= new HomePage(driver);

    }

    @Test
    public  void selectProduct(){
        homePage.selectProduct();
        homePage.addToCard();
        homePage.goToCheckout();

    }
}
