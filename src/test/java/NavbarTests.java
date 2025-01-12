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
public class NavbarTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/Korisnik/selenium/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testNavbarNavigation() throws InterruptedException {
        driver.get("https://www.booking.com");
        Thread.sleep(4000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }


        WebElement logoButton = driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[1]/div/span/a"));
        logoButton.click();
        Thread.sleep(1000);


        String[][] navigationSteps = {
                {"//*[@id=\"cars\"]", "https://www.booking.com/cars/index.html"},
                {"//*[@id=\"attractions\"]", "https://www.booking.com/attractions/index.html"},
                {"//*[@id=\"airport_taxis\"]", "https://www.booking.com/taxi/index.html"}
        };


        for (String[] step : navigationSteps) {
            WebElement navButton = driver.findElement(By.xpath(step[0]));
            navButton.click();
            Thread.sleep(1000);

            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = step[1];


            Assertions.assertTrue(actualUrl.startsWith(expectedUrl),
                    "The URLs are not the same. Actual: " + actualUrl + ", Expected: " + expectedUrl);
        }
    }
    @Test
    @Order(2)
    public void currencyTest() throws InterruptedException {
        driver.get("https://www.booking.com");


        Thread.sleep(5000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }


        WebElement currencyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[1]")));
        currencyButton.click();

        WebElement currency1Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Euro']")));
        currency1Button.click();
        WebElement selectedCurrency1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='EUR']")));
        Assertions.assertTrue(selectedCurrency1.isDisplayed(), "Euro currency not correctly selected");


        WebElement currencyButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[1]")));

        currencyButton1.click();

        WebElement currency2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='U.S. Dollar']")));
        currency2Button.click();
        WebElement selectedCurrency2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='USD']")));
        Assertions.assertTrue(selectedCurrency2.isDisplayed(), "U.S. Dollar currency not correctly selected");



        WebElement currencyButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[1]")));

        currencyButton2.click();

        WebElement currency3Button =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Pound Sterling']")));
        currency3Button.click();
        WebElement selectedCurrency3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='GBP']")));
        Assertions.assertTrue(selectedCurrency3.isDisplayed(), "Pound Sterling currency not correctly selected");



        WebElement currencyButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[1]")));

        currencyButton3.click();

        WebElement currency4Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Australian Dollar']")));
        currency4Button.click();
        WebElement selectedCurrency4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='AUD']")));
        Assertions.assertTrue(selectedCurrency4.isDisplayed(), "Australian Dollar currency not correctly selected");



        WebElement currencyButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[1]")));

        currencyButton4.click();

        WebElement currency5Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Swedish Krona']")));
        currency5Button.click();
        WebElement selectedCurrency5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SEK']")));
        Assertions.assertTrue(selectedCurrency5.isDisplayed(), "Swedish Krona currency not correctly selected");





    }

    @Test
    @Order(3)
    public void languageTest() throws InterruptedException {
        driver.get("https://www.booking.com");


        Thread.sleep(5000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }


        WebElement languageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[2]/button")));
        languageButton.click();

        WebElement language1Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Hrvatski']")));
        language1Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Prijavi se"), "Language not changed to Hrvatski");


        WebElement languageButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[2]/button")));

        languageButton1.click();

        WebElement language2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Srpski']")));
        language2Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Ulogujte se"), "Language not changed to Srpski");



        WebElement languageButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[2]/button")));

        languageButton2.click();

        WebElement language3Button =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Deutsch']")));
        language3Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Anmelden"), "Language not changed to German");



        WebElement languageButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[2]/button")));

        languageButton3.click();

        WebElement language4Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Italiano']")));
        language4Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Accedi"), "Language not changed to Italian");



        WebElement languageButton4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[2]/button")));

        languageButton4.click();

        WebElement language5Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='English (US)']")));
        language5Button.click();
        Assertions.assertTrue(driver.getPageSource().contains("Sign in"), "Language not changed to English (US)");


    }
    @Test
    @Order(4)
    public void supportTest() throws InterruptedException {
        driver.get("https://www.booking.com");


        Thread.sleep(5000);
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }


        WebElement customerSupportButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/div/nav[1]/div[2]/span[3]/a")));
        customerSupportButton.click();

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Continue without an account']")));
        continueButton.click();

        WebElement confirmNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"confirmationNumber\"]")));
        confirmNumber.clear();
        confirmNumber.sendKeys("872012631");

        WebElement pinNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pinCode\"]")));
        pinNumber.clear();
        pinNumber.sendKeys("8201");

        WebElement continue2Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Continue']")));
        continue2Button.click();
        Thread.sleep(2000);
    }


}

