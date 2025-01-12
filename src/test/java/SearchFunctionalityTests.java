import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchFunctionalityTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/Korisnik/selenium/chromedriver-win64/chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Order(1)
    @Test
    public void testSearchWithInvalidLocation() {
        try {
            driver.get("https://www.booking.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
                popupButton.click();
            } catch (Exception e) {
                System.out.println("Popup did not appear, skipping popup handling.");
            }

            WebElement SearchField = driver.findElement(By.xpath("//*[@placeholder=\"Where are you going?\"]"));
            SearchField.click();
            SearchField.sendKeys("@@@###!!!");
            WebElement checkInField = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[2]/div/div"));
            checkInField.click();
            WebElement flexible = driver.findElement(By.xpath("//*[@id=\"flexible-searchboxdatepicker-tab-trigger\"]/span/div/span"));
            flexible.click();
            WebElement weekend = driver.findElement(By.xpath("//*[@id=\"flexible-searchboxdatepicker\"]/div/div[1]/div[1]/div/fieldset/div/div[1]/label/span[2]"));
            weekend.click();
            WebElement month = driver.findElement(By.xpath("//*[@id=\":r4e:\"]/li[2]/label"));
            month.click();
            WebElement people = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[3]/div/button/span[1]"));
            people.click();
            WebElement adults = driver.findElement(By.xpath("//*[@id=\":ri:\"]/div/div[1]/div[2]/button[2]"));
            adults.click();
            WebElement rooms = driver.findElement(By.xpath("//*[@id=\":ri:\"]/div/div[3]/div[2]/button[2]"));
            rooms.click();
            WebElement doneButton = driver.findElement(By.xpath("//*[@id=\":ri:\"]/button"));
            doneButton.click();
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[4]/button"));
            searchButton.click();

            Thread.sleep(1000);
            WebElement noResultsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bodyconstraint-inner']/div[2]/div/div[2]/div[3]/div[2]/div[1]/h1")));
            Assertions.assertEquals("We couldn’t find any results", noResultsHeader.getText(), "Error: Invalid location did not result in the expected message.");

        } catch (Exception e) {
            System.out.println("Error occurred in invalid location test: " + e.getMessage());
        }
    }
    @Order(2)
    @Test
    public void testSearchWithValidLocation() {
        try {
            driver.get("https://www.booking.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();

            WebElement SearchField = driver.findElement(By.xpath("//*[@placeholder=\"Where are you going?\"]"));
            SearchField.click();
            SearchField.sendKeys("Neum");


            WebElement checkInField = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[2]/div/div"));
            checkInField.click();
            WebElement flexible = driver.findElement(By.xpath("//*[@id=\"flexible-searchboxdatepicker-tab-trigger\"]/span/div/span"));
            flexible.click();
            WebElement weekend = driver.findElement(By.xpath("//*[@id=\"flexible-searchboxdatepicker\"]/div/div[1]/div[1]/div/fieldset/div/div[1]/label/span[2]"));
            weekend.click();
            WebElement month = driver.findElement(By.xpath("//*[@id=\":r4e:\"]/li[2]/label"));
            month.click();
            WebElement people = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[3]/div/button/span[1]"));
            people.click();
            WebElement adults = driver.findElement(By.xpath("//*[@id=\":ri:\"]/div/div[1]/div[2]/button[2]"));
            adults.click();
            WebElement rooms = driver.findElement(By.xpath("//*[@id=\":ri:\"]/div/div[3]/div[2]/button[2]"));
            rooms.click();
            WebElement doneButton = driver.findElement(By.xpath("//*[@id=\":ri:\"]/button"));
            doneButton.click();
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[4]/button"));
            searchButton.click();

            WebElement resultsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[2]/div/div[2]/div[3]/div[2]/div[1]/h1")));
            Assertions.assertTrue(resultsHeader.getText().contains("Neum"), "Error: Valid location search did not return expected results.");

        } catch (Exception e) {
            System.out.println("Error occurred in valid location test: " + e.getMessage());
        }
    }
    @Order(3)
    @Test
    public void testSearchWithoutInput() {
        try {
            driver.get("https://www.booking.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();

            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[4]/button"));
            searchButton.click();


            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Enter a destination')]")));
            Assertions.assertTrue(errorMessage.isDisplayed(), "Error: No input search did not display expected error message.");

        } catch (Exception e) {
            System.out.println("Error occurred in no input test: " + e.getMessage());
        }
    }
}
