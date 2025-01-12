import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
/*Test with valid location fails because of a captcha*/
public class AttractionsSearchTest {

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
    public void testSearchWithInvalidLocation() throws InterruptedException {

        driver.get("https://www.booking.com/attractions");
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

        WebElement dateField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div/form/div/div[1]/div[2]/div/div/button"));
        dateField.click();

        WebElement dateField2 = driver.findElement(By.xpath("//*[@id=\":r1b:\"]/div/div[1]/div/button"));
        dateField2.click();

        WebElement dateField3 = driver.findElement(By.xpath("//*[@id=\":r1b:\"]/div/div[1]/div/div/div[1]/table/tbody/tr[4]/td[5]"));
        dateField3.click();

        WebElement dateField4 = driver.findElement(By.xpath("//*[@id=\":r1b:\"]/div/div[1]/div/div/div[1]/table/tbody/tr[5]/td[4]"));
        dateField4.click();

        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div/form/div/div[2]/button"));
        submit.click();

        Thread.sleep(5000);
        Assertions.assertTrue(driver.getPageSource().contains("No results found for @@@###!!!"), "Expected page not displayed.");


    }

    @Order(2)
    @Test
    public void testSearchWithValidLocation() throws InterruptedException {
        driver.get("https://www.booking.com/attractions");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement SearchField = driver.findElement(By.xpath("//*[@placeholder=\"Where are you going?\"]"));
        SearchField.click();
        SearchField.sendKeys("Sarajevo");

        WebElement dateField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div/form/div/div[1]/div[2]/div/div/button"));
        dateField.click();

        WebElement dateField2 = driver.findElement(By.xpath("//*[@id=\":r1b:\"]/div/div[1]/div/button"));
        dateField2.click();

        WebElement dateField3 = driver.findElement(By.xpath("//*[@id=\":r1b:\"]/div/div[1]/div/div/div[1]/table/tbody/tr[4]/td[5]"));
        dateField3.click();

        WebElement dateField4 = driver.findElement(By.xpath("//*[@id=\":r1b:\"]/div/div[1]/div/div/div[1]/table/tbody/tr[5]/td[4]"));
        dateField4.click();
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div/form/div/div[2]/button"));
        submit.click();

        Thread.sleep(5000);
        String expectedUrl = "https://www.booking.com/attractions/searchresults/ba/sarajevo.html?start_date=2025-02-21&end_date=2025-02-27&source=search_box";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl(), "URL does not match the expected URL.");
    }

}