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
public class HomePageTests {

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
    public void testHomepagePictureDestinations() throws InterruptedException {
        driver.get("https://www.booking.com");
        Thread.sleep(4000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement picture1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basiclayout\"]/div[8]/div/div/div[2]/a[1]/div/div/div/picture/img")));
        picture1.click();
        Assertions.assertTrue(driver.getPageSource().contains("Sarajevo"), "Went on the wrong page.");

        driver.navigate().back();
        WebElement picture2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basiclayout\"]/div[8]/div/div/div[2]/a[2]/div/div/div/picture/img")));
        picture2.click();
        Assertions.assertTrue(driver.getPageSource().contains("Belgrade"), "Went on the wrong page.");

        driver.navigate().back();

        WebElement picture3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basiclayout\"]/div[8]/div/div/div[3]/a[1]/div/div/div/picture/img")));
        picture3.click();
        Assertions.assertTrue(driver.getPageSource().contains("Mostar"), "Went on the wrong page.");

        driver.navigate().back();

        WebElement picture4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basiclayout\"]/div[8]/div/div/div[3]/a[2]/div/div/div/picture/img")));
        picture4.click();
        Assertions.assertTrue(driver.getPageSource().contains("Zagreb"), "Went on the wrong page.");

        driver.navigate().back();

        WebElement picture5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basiclayout\"]/div[8]/div/div/div[3]/a[3]/div/div/div/picture/img")));
        picture5.click();
        Assertions.assertTrue(driver.getPageSource().contains("Banja Luka"), "Went on the wrong page.");

        driver.navigate().back();


    }


    @Test
    @Order(2)
    public void testHomepageNavbarDestinations() throws InterruptedException {
        driver.get("https://www.booking.com");
        Thread.sleep(4000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }


        WebElement navbar1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NATURE_ACTIVE-tab-trigger\"]")));
        navbar1.click();
        Assertions.assertTrue(navbar1.getAttribute("aria-selected").equals("true") || navbar1.getAttribute("class").contains("active"),
                "Nature & Active tab is not selected after clicking.");


        WebElement navbar2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"BEACH-tab-trigger\"]")));
        navbar2.click();
        Assertions.assertTrue(navbar2.getAttribute("aria-selected").equals("true") || navbar2.getAttribute("class").contains("active"),
                "Beach tab is not selected after clicking.");

        WebElement navbar3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CITY-tab-trigger\"]")));
        navbar3.click();
        Assertions.assertTrue(navbar3.getAttribute("aria-selected").equals("true") || navbar3.getAttribute("class").contains("active"),
                "City Breaks tab is not selected after clicking.");


        WebElement navbar4= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"NATURE_RELAX-tab-trigger\"]")));
        navbar4.click();
        Assertions.assertTrue(navbar4.getAttribute("aria-selected").equals("true") || navbar4.getAttribute("class").contains("active"),
                "Nature & Relaxation tab is not selected after clicking.");

    }
}