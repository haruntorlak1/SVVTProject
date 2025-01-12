import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*testSecureCookies test fails because Cookie _pin_unauth is not marked as Secure.*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecurityTests {
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    @Order(1)
    public void testEnforceHttps() {
        driver.get("http://www.booking.com");
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        String currentUrl = driver.getCurrentUrl();


        assertTrue(currentUrl.startsWith("https://"),
                "The site did not enforce HTTPS. Current URL: " + currentUrl);
    }


    @Test
    @Order(2)
    public void testSecureCookies() {
        driver.get("https://www.booking.com");

        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        wait.until(driver -> {
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.equals("https://www.booking.com") || currentUrl.equals("https://www.booking.com/");
        });

        Set<Cookie> cookies = driver.manage().getCookies();

        cookies.forEach(cookie -> {
            System.out.println("Cookie: " + cookie.getName() + ", Secure: " + cookie.isSecure());
            if (!cookie.isSecure()) {
                System.out.println("Non-secure cookie: " + cookie.getName() + ", Domain: " + cookie.getDomain() + ", Path: " + cookie.getPath());
            }
        });

        for (Cookie cookie : cookies) {
            assertTrue(cookie.isSecure(),
                    "Cookie " + cookie.getName() + " is not marked as Secure.");
        }
    }





    @Test
    @Order(3)
    public void testHstsHeader() {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.responseReceived(), response -> {

            Object hstsHeaderObject = response.getResponse().getHeaders().get("Strict-Transport-Security");

            if (hstsHeaderObject != null) {
                String hstsHeader = hstsHeaderObject.toString();


                assertNotNull(hstsHeader, "HSTS header is missing.");
                assertTrue(hstsHeader.contains("max-age"),
                        "HSTS header does not specify max-age. Value: " + hstsHeader);
            } else {
                Assertions.fail("HSTS header is missing.");
            }
        });

        driver.get("https://www.booking.com");
    }


}
