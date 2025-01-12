import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AttractionsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/Korisnik/selenium/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testAttractionsNavbar() throws InterruptedException {
        driver.get("https://www.booking.com/attractions");



        WebElement navbar1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"1-tab-trigger\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", navbar1);

        navbar1.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("New York"), "New York is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Las Vegas"), "Las Vegas is not displayed on the page.");

        WebElement navbar2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"8-tab-trigger\"]")));
        navbar2.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Kuala Lumpur"), "Kuala Lumpur is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Jakarta"), "Jakarta is not displayed on the page.");

        WebElement navbar3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"5-tab-trigger\"]")));
        navbar3.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Cape Town"), "Cape Town is not displayed on the page.");

        WebElement navbar4= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"9-tab-trigger\"]")));
        navbar4.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Gold Coast"), "Gold Coast is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Sydney"), "Sydney is not displayed on the page.");

        WebElement navbar5= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"7-tab-trigger\"]")));
        navbar5.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Dubai"), "Dubai is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Abu Dhabi"), "Abu Dhabi is not displayed on the page.");

        WebElement navbar6= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"10-tab-trigger\"]")));
        navbar6.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Punta Cana"), "Punta Cana is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Nassau"), "Nassau is not displayed on the page.");

        WebElement navbar7= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"3-tab-trigger\"]")));
        navbar7.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Santiago"), "Santiago is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Cusco"), "Santiago is not displayed on the page.");


        WebElement navbar8= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"2-tab-trigger\"]")));
        navbar8.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Panama City"), "Panama City is not displayed on the page.");

        WebElement navbar9= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"6-tab-trigger\"]")));
        navbar9.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("London"), "London is not displayed on the page.");


    }


    @Test
    @Order(2)
    public void testRecommendedFilters() throws InterruptedException {
        driver.get("https://www.booking.com/attractions");

        WebElement recommendedButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/section[1]/div[1]/a")));
        recommendedButton.click();


        WebElement sortOption1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Tours']")));
        sortOption1.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getPageSource().contains("Tours"), "Tours filter not applied.");
        sortOption1.click();
        Thread.sleep(1000);

        WebElement sortOption3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div[3]/div/fieldset/div/div[1]/label/span[3]/div")));
        sortOption3.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getPageSource().contains("Free"), "Free Cancelation filter not applied.");

        sortOption3.click();
        Thread.sleep(1000);

        WebElement sortOption4=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/fieldset/div/div[1]")));
        sortOption4.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getPageSource().contains("4.5"), "4.5 and up filter not applied.");
        sortOption3.click();
        Thread.sleep(1000);
        WebElement sortOption5=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div[5]/div/fieldset/div/div[1]/label/span[3]")));
        sortOption3.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getPageSource().contains("Morning"), "Morning filter not applied.");

        sortOption5.click();
        Thread.sleep(1000);

        WebElement sortOption6=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='English']")));
        sortOption6.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getPageSource().contains("English"), "English filter not applied.");




    }


}