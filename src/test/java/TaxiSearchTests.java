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
public class TaxiSearchTests {

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

        driver.get("https://www.booking.com/taxi/index.en-gb.html?selected_currency=BAM&adplat=www-runway_internal_action-web_shell_header-taxi-missing_creative-xzo2cDRB1s1Sg5YoYsTcI&aid=304142&client_name=b-web-shell-bff&etStateBlob=EqX2FOii9Ygv1Q6nSfDGUsxVBxL_6DMrPQCAwSdnmjKA61GPOu4BXpp2XYVd8GOJr&distribution_id=xzo2cDRB1s1Sg5YoYsTcI");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement SearchField1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pickup-input-id\"]")));
        SearchField1.click();
        SearchField1.sendKeys("@@@###!!!");

        WebElement SearchField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropoff-input-id\"]")));
        SearchField2.click();
        SearchField2.sendKeys("@@@###!!!");

        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[2]/div/button")));
        dateField.click();


        WebElement dateField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[2]/div/div[2]/div[1]/div/button")));
        dateField2.click();

        WebElement dateField3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[2]/div/div[2]/div[1]/div/div/div/table/tbody/tr[3]/td[3]")));
        dateField3.click();

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[5]/button")));
        submit.click();

        Thread.sleep(3000);


        Assertions.assertTrue(driver.getPageSource().contains("Please provide a drop-off location"), "Expected error message not displayed.");


    }

    @Order(2)
    @Test
    public void testSearchWithValidLocation() throws InterruptedException {
        driver.get("https://www.booking.com/taxi/index.en-gb.html?selected_currency=BAM&adplat=www-runway_internal_action-web_shell_header-taxi-missing_creative-xzo2cDRB1s1Sg5YoYsTcI&aid=304142&client_name=b-web-shell-bff&etStateBlob=EqX2FOii9Ygv1Q6nSfDGUsxVBxL_6DMrPQCAwSdnmjKA61GPOu4BXpp2XYVd8GOJr&distribution_id=xzo2cDRB1s1Sg5YoYsTcI");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement SearchField1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pickup-input-id\"]")));
        SearchField1.click();
        SearchField1.sendKeys("Sarajevo");
        Thread.sleep(2000);
        WebElement Search1Field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"taxi-autocomplete-search-drop-down-pickup\"]/li[1]/div/button/div/div[2]")));
        Search1Field.click();


        WebElement SearchField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropoff-input-id\"]")));
        SearchField2.click();
        SearchField2.sendKeys("Bulevar B");
        Thread.sleep(2000);
        WebElement Search2Field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"taxi-autocomplete-search-drop-down-dropoff\"]/li[1]/div/button/div/div[2]")));
        Search2Field.click();

        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[2]/div/button")));
        dateField.click();

        Thread.sleep(2000);
        WebElement dateField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[2]/div/div[2]/div[1]/div/button")));
        dateField2.click();

        WebElement dateField3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[2]/div/div[2]/div[1]/div/div/div/table/tbody/tr[3]/td[3]")));
        dateField3.click();
        Thread.sleep(2000);
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[5]/button")));
        submit.click();

        Thread.sleep(3000);


        Assertions.assertTrue(driver.getPageSource().contains("The latest prices from our trusted partners"), "Expected page not displayed.");


    }

    @Order(3)
    @Test
    public void testSearchWithoutInput() throws InterruptedException {
        driver.get("https://www.booking.com/taxi/index.en-gb.html?selected_currency=BAM&adplat=www-runway_internal_action-web_shell_header-taxi-missing_creative-xzo2cDRB1s1Sg5YoYsTcI&aid=304142&client_name=b-web-shell-bff&etStateBlob=EqX2FOii9Ygv1Q6nSfDGUsxVBxL_6DMrPQCAwSdnmjKA61GPOu4BXpp2XYVd8GOJr&distribution_id=xzo2cDRB1s1Sg5YoYsTcI");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bodyconstraint\"]/div[1]/div/div/div[2]/div/div/div/form/div/div[5]/button")));
        submit.click();

        Thread.sleep(3000);


        Assertions.assertTrue(driver.getPageSource().contains("Please provide a drop-off location"), "Expected page not displayed.");

    }



}