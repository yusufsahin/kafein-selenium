package tr.com.kafein.basicgooglesearch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class SearchTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @Test
    public void testSearch() throws InterruptedException {

        driver.get("https://www.google.com.tr");
        //driver.manage().window().setSize(new Dimension(1040, 800));
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("Kafein");
        driver.findElement(By.name("q")).submit();

        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(5000);
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

      //  System.out.println(driver.getPageSource());
        driver.navigate().refresh();
        Thread.sleep(2000);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
