import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class propertiesOnMapTests {

    private WebDriver driver;
    private WebDriverWait wait;

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


    @Test
    @Order(1)
    public void testMapSearch() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.booking.com");
        Thread.sleep(3000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement SearchField = driver.findElement(By.xpath("//*[@placeholder=\"Where are you going?\"]"));
        SearchField.click();
        SearchField.sendKeys("Neum");
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[4]/button")));
        searchButton.click();
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }
        Thread.sleep(1000);

        WebElement mapButton = driver.findElement(By.xpath("//*[text()='Show on map']"));
        mapButton.click();
        Thread.sleep(1000);


        WebElement mapSearch = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Search on map\"]")));
        mapSearch.clear();
        mapSearch.sendKeys("Zivinice");

        try {
            WebElement mapSearch1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Živinice']")));
            mapSearch1.click();
        } catch (Exception e) {
            System.out.println("Element not found or still stale, retrying...");
        }

        Thread.sleep(1000);


        try {
            WebElement mapSearchResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Živinice')]")));
            mapSearchResult.click();
            Assertions.assertTrue(true, "Search for 'Živinice' was successful.");
        } catch (Exception e) {
            Assertions.fail("Search for 'Živinice' failed: " + e.getMessage());
        }

    }


    @Test
    @Order(2)
public void testMapUsage() throws InterruptedException{
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.booking.com");
        Thread.sleep(3000);
        try {
        WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
        popupButton.click();
    } catch (Exception e) {
        System.out.println("Popup did not appear, skipping popup handling.");
    }

    WebElement SearchField = driver.findElement(By.xpath("//*[@placeholder=\"Where are you going?\"]"));
        SearchField.click();
        SearchField.sendKeys("Neum");
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div/div[4]/button")));
        searchButton.click();
        try {
        WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
        popupButton.click();
    } catch (Exception e) {
        System.out.println("Popup did not appear, skipping popup handling.");
    }
        Thread.sleep(1000);

    WebElement mapButton = driver.findElement(By.xpath("//*[text()='Show on map']"));
        mapButton.click();
        Thread.sleep(1000);


        try {
            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.e1793b8db2")));
            plusButton.click();
            System.out.println("'+' button clicked successfully.");

            WebElement minusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.e1793b8db2 svg path[d='M20.25 12.75H3.75a.75.75 0 0 1 0-1.5h16.5a.75.75 0 0 1 0 1.5']")));
            minusButton.click();
            System.out.println("'-' button clicked successfully.");

            Assertions.assertTrue(true, "Zoom buttons clicked successfully.");
        } catch (Exception e) {
            Assertions.fail("Failed to click zoom buttons: " + e.getMessage());
        }

    }

}