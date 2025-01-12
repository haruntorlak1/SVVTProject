import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests {
// The login test cannot pass because we have a captcha on the login page
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/Korisnik/selenium/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @Order(1)
    public void testLogin() {

        driver.get("https://account.booking.com/");


        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        emailField.sendKeys("harun.torlak@stu.ibu.edu.ba");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[contains(text(),'Continue with email')]]")));
        continueButton.click();


        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        passwordField.sendKeys("password123");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_button")));
        signInButton.click();


        wait.until(ExpectedConditions.urlContains("account"));
        WebElement userProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile')]"))); // Example element


        assertTrue(userProfile.isDisplayed(), "Login failed: Profile element not found.");
    }

    @Test
    @Order(2)
    public void testLoginButtons() {
        driver.get("https://account.booking.com/");


        String mainWindowHandle = driver.getWindowHandle();
        String[][] buttonsAndUrls = {
                {"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/form/div[2]/div[2]/div[2]/a[1]", "accounts.google.com"},  // Google
                {"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/form/div[2]/div[2]/div[2]/a[2]", "appleid.apple.com"},   // Apple
                {"//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/form/div[2]/div[2]/div[2]/a[3]", "facebook.com"}       // Facebook
        };

        for (String[] buttonAndUrl : buttonsAndUrls) {
            String buttonXPath = buttonAndUrl[0];
            String expectedUrlPart = buttonAndUrl[1];


            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonXPath)));
            loginButton.click();


            wait.until(driver -> driver.getWindowHandles().size() > 1);


            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }


            wait.until(ExpectedConditions.urlContains(expectedUrlPart));


            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains(expectedUrlPart),
                    "The button did not navigate to the expected URL. Actual URL: " + currentUrl);

            driver.close();
            driver.switchTo().window(mainWindowHandle);
        }
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
