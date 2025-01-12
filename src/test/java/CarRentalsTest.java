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
public class CarRentalsTest {

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
    public void testCarsNavbar() throws InterruptedException {
        driver.get("https://www.booking.com/cars/index.html?label=gen173nr-1FEgRjYXJzKIICOOgHSDNYBGgSiAEBmAExuAEXyAEM2AEB6AEB-AECiAIBqAIDuALJ0JC8BsACAdICJDI3MTE1OGM0LTNkMzItNDBlYy04N2JiLWFkN2FkY2ZlZWI0NtgCBeACAQ&sid=950cad7ab7dbdc437a944f1bd29947e7&keep_landing=1&");


        Thread.sleep(1000);
        WebElement navbar1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-1-tab-trigger\"]")));
        Thread.sleep(1000);

        navbar1.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Banja Luka"), "Banja Luka is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Mostar"), "Mostar is not displayed on the page.");

        WebElement navbar2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-2-tab-trigger\"]")));
        navbar2.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Sarajevo Canton"), "Sarajevo Canton is not displayed on the page.");

        WebElement navbar3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-3-tab-trigger\"]")));
        navbar3.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Phoenix"), "Phoenix is not displayed on the page.");

        WebElement navbar4= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-4-tab-trigger\"]")));
        navbar4.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Malaga Airport"), "Malaga Airport is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Faro Airport"), "Faro Airport is not displayed on the page.");

        WebElement navbar5= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-0-tab-trigger\"]")));
        navbar5.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Sarajevo"), "Sarajevo is not displayed on the page.");
        Assertions.assertTrue(driver.getPageSource().contains("Ilidža"), "Ilidža is not displayed on the page.");



    }


    @Test
    @Order(2)
    public void testCarsQuestions() throws InterruptedException {
        driver.get("https://www.booking.com/cars/index.html?label=gen173nr-1FEgRjYXJzKIICOOgHSDNYBGgSiAEBmAExuAEXyAEM2AEB6AEB-AECiAIBqAIDuALJ0JC8BsACAdICJDI3MTE1OGM0LTNkMzItNDBlYy04N2JiLWFkN2FkY2ZlZWI0NtgCBeACAQ&sid=950cad7ab7dbdc437a944f1bd29947e7&keep_landing=1&");


        Thread.sleep(1000);
        WebElement question1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='How much does it cost to rent a car in Bosnia and Herzegovina for a week?']")));
        Thread.sleep(2000);

        question1.click();

        Thread.sleep(2000);
        Assertions.assertTrue(driver.getPageSource().contains("Based on the average daily cost"), "The sentence is not on the page");
        question1.click();


        WebElement question2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='How much does it cost to rent a car in Bosnia and Herzegovina for a month?']")));
        Thread.sleep(1000);

        question2.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Based on the average daily cost"), "The sentence is not on the page");
        question2.click();

        WebElement question3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='What car do people usually book in Bosnia and Herzegovina?']")));
        Thread.sleep(1000);

        question3.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("Medium is the most popular car group to rent in Bosnia and Herzegovina"), "The sentence is not on the page");
        question3.click();


        WebElement question4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='How much does it cost to rent medium car in Bosnia and Herzegovina?']")));
        Thread.sleep(1000);

        question4.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("On average, renting Medium car in Bosnia and Herzegovina"), "The sentence is not on the page");
        question4.click();


        WebElement question5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Can I pick up the car from one location but return it to a different one in in Bosnia and Herzegovina?']")));
        Thread.sleep(1000);

        question5.click();
        Thread.sleep(500);
        Assertions.assertTrue(driver.getPageSource().contains("It's usually possible to return rental cars to a different location, but it depends on each company’s policy and might cost extra."), "The sentence is not on the page");
        question5.click();


    }


}