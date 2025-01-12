import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

/*couldn't make a test for every single of the filters because when i click on one it moves and/or makes duplicate buttons
* sometimes the test fails because of the popup appears and sometimes it doesn't
* i made code to check if the popup appears it clicks on it and if it doesnt it skips the popup handling
*
* */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingFilterTests {

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

    @Order(1)
    @Test
    public void testSortFilters() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.booking.com");

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

        WebElement sortButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[1]/div/div/div/span/button/span"));
        sortButton.click();
        Thread.sleep(1000);
        WebElement sortOption1=driver.findElement(By.xpath("//*[text()='Homes & apartments first']"));
        Thread.sleep(1000);
        sortOption1.click();
        Thread.sleep(1000);
        sortButton.click();
        WebElement sortOption2=driver.findElement(By.xpath("//*[text()='Price (highest first)']"));
        Thread.sleep(1000);
        sortOption2.click();
        Thread.sleep(1000);
        sortButton.click();
        WebElement sortOption3=driver.findElement(By.xpath("//*[text()='Property rating (high to low)']"));
        Thread.sleep(1000);
        sortOption3.click();
        Thread.sleep(1000);
        sortButton.click();
        WebElement sortOption4=driver.findElement(By.xpath("//*[text()='Property rating (low to high)']"));
        Thread.sleep(1000);
        sortOption4.click();
        Thread.sleep(1000);
        sortButton.click();
        WebElement sortOption5=driver.findElement(By.xpath("//*[text()='Distance from downtown']"));
        Thread.sleep(1000);
        sortOption5.click();
        Thread.sleep(1000);
        sortButton.click();
        WebElement sortOption6=driver.findElement(By.xpath("//*[text()='Top reviewed']"));
        Thread.sleep(1000);
        sortOption6.click();
        Thread.sleep(1000);
        sortButton.click();
        WebElement sortOption7=driver.findElement(By.xpath("//*[text()='Distance from closest beach']"));
        sortOption7.click();
        Thread.sleep(1000);


        WebElement appliedSortOption = driver.findElement(By.xpath("//*[text()='Distance from closest beach']"));
        Assertions.assertNotNull(appliedSortOption, "Sort option was not applied correctly.");
    }

    @Order(2)
    @Test
    public void testFilters() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.booking.com");
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
        WebElement sortOption1=driver.findElement(By.xpath("//*[text()='Sea view']"));
        sortOption1.click();
        Thread.sleep(1000);
        sortOption1.click();
        Thread.sleep(1000);
        WebElement sortOption2=driver.findElement(By.xpath("//*[text()='Free Wifi']"));
        sortOption2.click();
        Thread.sleep(1000);
        sortOption2.click();
        Thread.sleep(1000);
        WebElement sortOption3=driver.findElement(By.xpath("//*[text()='Apartments']"));
        sortOption3.click();
        Thread.sleep(1000);
        sortOption3.click();
        Thread.sleep(1000);
        WebElement sortOption4=driver.findElement(By.xpath("//*[text()='Guesthouses']"));
        sortOption4.click();
        Thread.sleep(1000);
        sortOption4.click();
        WebElement sortOption5=driver.findElement(By.xpath("//*[text()='Restaurant']"));
        sortOption5.click();
        Thread.sleep(1000);
        sortOption5.click();
        WebElement sortOption6=driver.findElement(By.xpath("//*[text()='4 stars']"));
        sortOption6.click();
        Thread.sleep(1000);
        sortOption6.click();
        WebElement sortOption7=driver.findElement(By.xpath("//*[text()='Less than 1 km']"));
        sortOption7.click();
        Thread.sleep(1000);
        sortOption7.click();


        WebElement appliedFilter = driver.findElement(By.xpath("//*[text()='Less than 1 km']"));
        Assertions.assertNotNull(appliedFilter, "Filter was not applied correctly.");
    }


}
