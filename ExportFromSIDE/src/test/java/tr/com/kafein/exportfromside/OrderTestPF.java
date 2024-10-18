package tr.com.kafein.exportfromside;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class OrderTestPF {

    private WebDriver driver;
    private HomePagePF homePage;
    private OrderPagePF orderPage;
    private ExcelReader excelReader;
    private final String excelFilePath = "src/test/resources/testData.xlsx";
    private final String sheetName = "OrderData";
    @BeforeEach
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage = new HomePagePF(driver);
        orderPage = new OrderPagePF(driver);

        excelReader = new ExcelReader(excelFilePath, sheetName);

    }


    @Test
    public void order() throws IOException {

        List<String[]> testData = excelReader.getData();
        for (int i = 0; i < testData.size(); i++) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = now.format(formatter);

            // Create a unique screenshot file name using index `i` or UUID
            String fileName = "sc_" + i + "_" + timestamp + "_" + UUID.randomUUID() + ".png";

            takeScreenShot(fileName);

            String[] dataRow = testData.get(i);
            if (dataRow.length < 8) {
                throw new RuntimeException("Invalid data in Excel file");
            }
            String name = dataRow[0];
            String line1 = dataRow[1];
            String line2 = dataRow[2];
            String line3 = dataRow[3];
            String city = dataRow[4];
            String state = dataRow[5];
            String zip = dataRow[6];
            String country = dataRow[7];

            homePage.selectProduct();
            homePage.addToCart();
            homePage.goToCheckOut();

            // Enter order details
            orderPage.enterDetails(name, line1, line2, line3, city, state, zip, country);
            orderPage.submitOrder();

            Assertions.assertEquals(orderPage.getConfirmationText(), "Thanks!");

            // Take a screenshot after the order submission
            takeScreenShot(fileName);

            orderPage.returnToStore();
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenShot(String fileName) throws IOException {
        TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
        File screenshotFile = screenshotTaker.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/test/resources/" + fileName);

        // Overwrite existing files
        Files.copy(screenshotFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
