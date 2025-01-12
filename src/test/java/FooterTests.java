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
public class FooterTests {

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
    public void testFooterNavigation() throws InterruptedException {
        driver.get("https://www.booking.com");
        Thread.sleep(4000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }


        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Coronavirus (COVID-19) FAQs']")));
        button1.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Coronavirus"), "Navigated to incorrect page.");
        driver.navigate().back();

        WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Manage your trips']")));
        button2.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Booking.com Help Center"), "Navigated to incorrect page.");
        driver.navigate().back();

        WebElement button3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Contact Customer Service']")));
        button3.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Booking.com Help Center"), "Navigated to incorrect page.");
        driver.navigate().back();

        WebElement button4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[1]/ul/li[4]/div/a")));
        button4.click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Trust and Safety Resource Center | Booking.com"), "Navigated to incorrect page.");
        driver.navigate().back();

        WebElement button5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[2]/ul/li[1]/div/a")));
        button5.click();

        Thread.sleep(1000);

        driver.navigate().back();

        WebElement button6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[2]/ul/li[2]/div/a")));
        button6.click();

        Thread.sleep(1000);
        driver.navigate().back();

        WebElement button7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[2]/ul/li[3]/div/a")));
        button7.click();

        Thread.sleep(1000);
        driver.navigate().back();

        WebElement button8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[2]/ul/li[4]/div/a")));
        button8.click();

        Thread.sleep(1000);
        driver.navigate().back();

        WebElement button9 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[2]/ul/li[5]/div/a")));
        button9.click();

        Thread.sleep(1000);
        driver.navigate().back();


        WebElement button10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[2]/div/div[4]/ul/li[2]/div/a")));
        button9.click();

        Thread.sleep(1000);
        driver.navigate().back();



    }
    @Test
    @Order(2)
    public void testFooterCurrency() throws InterruptedException {
        driver.get("https://www.booking.com");
        Thread.sleep(4000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement currencyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[2]/button")));
        currencyButton.click();

        WebElement currency1Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Euro']")));
        currency1Button.click();
        WebElement selectedCurrency1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='EUR']")));
        Assertions.assertTrue(selectedCurrency1.isDisplayed(), "Euro currency not correctly selected");


        WebElement currencyButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[2]/button")));

        currencyButton1.click();

        WebElement currency2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='U.S. Dollar']")));
        currency2Button.click();
        WebElement selectedCurrency2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='USD']")));
        Assertions.assertTrue(selectedCurrency2.isDisplayed(), "U.S. Dollar currency not correctly selected");


        WebElement currencyButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[2]/button")));

        currencyButton2.click();

        WebElement currency3Button =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Pound Sterling']")));
        currency3Button.click();
        WebElement selectedCurrency3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='GBP']")));
        Assertions.assertTrue(selectedCurrency3.isDisplayed(), "Pound Sterling currency not correctly selected");



        WebElement currencyButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[2]/button")));

        currencyButton3.click();

        WebElement currency4Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Australian Dollar']")));
        currency4Button.click();
        WebElement selectedCurrency4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='AUD']")));
        Assertions.assertTrue(selectedCurrency4.isDisplayed(), "Australian Dollar currency not correctly selected");


        WebElement currencyButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[2]/button")));

        currencyButton4.click();

        WebElement currency5Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Swedish Krona']")));
        currency5Button.click();

        WebElement selectedCurrency5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SEK']")));
        Assertions.assertTrue(selectedCurrency5.isDisplayed(), "Swedish Krona currency not correctly selected");
    }

    @Test
    @Order(3)
    public void testFooterLanguage() throws InterruptedException {
        driver.get("https://www.booking.com");
        Thread.sleep(4000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement languageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[1]/button")));
        languageButton.click();
        Thread.sleep(1000);
        WebElement language1Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Hrvatski']")));
        language1Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Prijavi se"), "Language not changed to Hrvatski");


        Thread.sleep(1000);
        WebElement languageButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[1]/button")));
        Thread.sleep(1000);
        languageButton1.click();
        Thread.sleep(1000);
        WebElement language2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Srpski']")));
        language2Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Ulogujte se"), "Language not changed to Srpski");


        Thread.sleep(1000);

        WebElement languageButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[1]/button")));

        languageButton2.click();
        Thread.sleep(1000);
        WebElement language3Button =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Deutsch']")));
        language3Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Anmelden"), "Language not changed to German");


        Thread.sleep(1000);

        WebElement languageButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[1]/button")));

        languageButton3.click();
        Thread.sleep(1000);
        WebElement language4Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Italiano']")));
        language4Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Accedi"), "Language not changed to Italian");


        Thread.sleep(1000);

        WebElement languageButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer_menu_track\"]/div[2]/div[2]/footer/div[3]/div/div[1]/span[1]/button")));

        languageButton4.click();
        Thread.sleep(1000);
        WebElement language5Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='English (US)']")));
        language5Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Sign in"), "Language not changed to English (US)");


        Thread.sleep(1000);



    }

}