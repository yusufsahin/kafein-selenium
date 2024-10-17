package tr.com.kafein.googlesearchdatadriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;

public class GoogleSearchTest {
    private WebDriver driver;
    private Workbook workbook;

    @BeforeEach
    public void setup() throws IOException {
        ChromeOptions options= new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com.tr");

        FileInputStream fis= new FileInputStream(new File("src/test/resources/data.xlsx"));
        workbook = new XSSFWorkbook(fis);
    }

    @Test
    @DisplayName("Perform Google Search Test form Excel")
    public  void  performGoogleSearchTest() throws InterruptedException, IOException {

        Sheet sheet=workbook.getSheetAt(0);

        Iterator<Row>  rowIterator = sheet.rowIterator();
        if(rowIterator.hasNext()){
            rowIterator.next();
        }

        while(rowIterator.hasNext()){

            Row row = rowIterator.next();
            Cell cell= row.getCell(0);
            String searchQuery=cell.getStringCellValue();
            WebElement searchBox = driver.findElement(By.name("q"));

            searchBox.clear();
            searchBox.sendKeys(searchQuery);
            searchBox.submit();
            Thread.sleep(3000);

            String expectedTitle = searchQuery+" - Google'da Ara";
            String actualTitle = driver.getTitle();

            Assertions.assertEquals(expectedTitle, actualTitle);


            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = now.format(formatter);

            // Create the full screenshot file name with date and time
            String fileName = "sc" + "_" + timestamp + ".png";


            takeScreenShot(fileName);

            driver.navigate().back();
            Thread.sleep(3000);
        }


    }


    @AfterEach
    public void  tearDown()
    {
        if(driver!=null){
            driver.quit();
        }
    }

    private  void takeScreenShot(String image) throws IOException {
        TakesScreenshot screenshotTaker = (TakesScreenshot)driver;
        File screenshotFile= screenshotTaker.getScreenshotAs(OutputType.FILE);
        File destinationFile= new File("src/test/resources/"+ image);
        Files.copy(screenshotFile.toPath(),destinationFile.toPath());

    }

}
