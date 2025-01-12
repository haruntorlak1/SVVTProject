
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
public class BookingProcessTests {
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
    public void testFormWithValidInfo() throws InterruptedException {

        driver.get("https://secure.booking.com/book.html?hotel_id=828564&occupancy_setup_issue_flags=3&aid=304142&label=gen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ApXSi7wGwAIB0gIkYzE2ODZlNjUtZWYwZC00NGFlLWFmMWUtMDYwZjE3ZmQ0NGFi2AIF4AIB&sid=55da831e680121100860d2ea00a5ea3b&room1=A&room2=A%2CA&error_url=%2Fhotel%2Fba%2Fpansion-jadranka.html%3Faid%3D304142%26label%3Dgen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ApXSi7wGwAIB0gIkYzE2ODZlNjUtZWYwZC00NGFlLWFmMWUtMDYwZjE3ZmQ0NGFi2AIF4AIB%26sid%3D55da831e680121100860d2ea00a5ea3b%26srpvid%3D15c59a4e086904e8%26%26&hostname=www.booking.com&stage=1&checkin=2025-02-07&interval=1&children_extrabeds=&srpvid=15c59a4e086904e8&hp_visits_num=1&rt_pos_selected=1&rt_pos_selected_within_room=1&rt_selected_block_position=1&rt_num_blocks=2&rt_num_rooms=2&rt_num_blocks_per_room=%7B%2282856404%22%3A1%2C%2282856405%22%3A1%7D&rt_selected_blocks_info=%7B%2282856405_203595803_0_2_0%22%3A%7B%22rt_selected_block_position_in_rt%22%3A1%2C%22rt_selected_block_position_in_room_group%22%3A0%2C%22count%22%3A1%2C%22rt_room_symmetry_category%22%3A%22one_rate%22%7D%7D&rt_relevance_metric_id=032e9ed7-34b6-47d3-98e1-fe791d3f3c4d&rt_pageview_id=9c889a52d119029d&rt_pos_final=1.1&rt_selected_total_price=50&rt_cheapest_search_price=100&rt_with_no_dimensions=1&from_source=hotel&basket_id=97dbdbfa-7f0f-4969-a2ba-59459a04767b&nr_rooms_82856405_203595803_0_2_0=1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\":rp:\"]"));
        firstName.clear();
        firstName.sendKeys("Saban");

        WebElement lastName = driver.findElement(By.xpath("//*[@id=\":rq:\"]"));
        lastName.clear();
        lastName.sendKeys("Saulic");

        WebElement email = driver.findElement(By.xpath("//*[@id=\":rr:\"]"));
        email.clear();
        email.sendKeys("saban.saulic@gmail.com");
        Thread.sleep(1000);
        WebElement phoneNum = driver.findElement(By.xpath("//*[@id=\":r13:\"]"));
        phoneNum.clear();
        phoneNum.sendKeys("47197241");
        Thread.sleep(1000);




        WebElement checker2=driver.findElement(By.xpath("//*[@id=\":r19:\"]"));
        checker2.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checker2);

        Thread.sleep(1000);


        WebElement checker4=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[4]/div/div/ul/li[1]/div/div/div[1]/div[1]/div/div/label")));
        checker4.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checker4);

        Thread.sleep(1000);


        WebElement checker5=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[4]/div/div/ul/li[1]/div/div/div[1]/div[1]/div/div/label")));
        checker5.click();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checker5);
        WebElement checker6=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[4]/div/div/ul/li[2]/div/div/div[1]/div[1]/div/div/label")));
        checker6.click();
        Thread.sleep(1000);
        WebElement checker7=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[4]/div/div/ul/li[3]/div/div/div[1]/div[1]/div/div/label")));
        checker7.click();
        Thread.sleep(1000);

        WebElement info = driver.findElement(By.xpath("//*[@id=\"remarks\"]"));

        info.sendKeys("Test info 1 2 3");

        Thread.sleep(1000);
        WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[7]/div/div[2]/button")));
        submit.click();

        WebElement confirmationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'How do you want to pay?')]")));


        Assertions.assertTrue(confirmationText.isDisplayed(), "The confirmation text 'You'll pay directly to the property' is not displayed.");
    }

    @Order(2)
    @Test
    public void testFormWithInvalidInfo() throws InterruptedException {
        driver.get("https://secure.booking.com/book.html?hotel_id=828564&occupancy_setup_issue_flags=3&aid=304142&label=gen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ApXSi7wGwAIB0gIkYzE2ODZlNjUtZWYwZC00NGFlLWFmMWUtMDYwZjE3ZmQ0NGFi2AIF4AIB&sid=55da831e680121100860d2ea00a5ea3b&room1=A&room2=A%2CA&error_url=%2Fhotel%2Fba%2Fpansion-jadranka.html%3Faid%3D304142%26label%3Dgen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ApXSi7wGwAIB0gIkYzE2ODZlNjUtZWYwZC00NGFlLWFmMWUtMDYwZjE3ZmQ0NGFi2AIF4AIB%26sid%3D55da831e680121100860d2ea00a5ea3b%26srpvid%3D15c59a4e086904e8%26%26&hostname=www.booking.com&stage=1&checkin=2025-02-07&interval=1&children_extrabeds=&srpvid=15c59a4e086904e8&hp_visits_num=1&rt_pos_selected=1&rt_pos_selected_within_room=1&rt_selected_block_position=1&rt_num_blocks=2&rt_num_rooms=2&rt_num_blocks_per_room=%7B%2282856404%22%3A1%2C%2282856405%22%3A1%7D&rt_selected_blocks_info=%7B%2282856405_203595803_0_2_0%22%3A%7B%22rt_selected_block_position_in_rt%22%3A1%2C%22rt_selected_block_position_in_room_group%22%3A0%2C%22count%22%3A1%2C%22rt_room_symmetry_category%22%3A%22one_rate%22%7D%7D&rt_relevance_metric_id=032e9ed7-34b6-47d3-98e1-fe791d3f3c4d&rt_pageview_id=9c889a52d119029d&rt_pos_final=1.1&rt_selected_total_price=50&rt_cheapest_search_price=100&rt_with_no_dimensions=1&from_source=hotel&basket_id=97dbdbfa-7f0f-4969-a2ba-59459a04767b&nr_rooms_82856405_203595803_0_2_0=1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\":rp:\"]"));
        firstName.clear();
        firstName.sendKeys("12345");

        WebElement lastName = driver.findElement(By.xpath("//*[@id=\":rq:\"]"));
        lastName.clear();
        lastName.sendKeys("!@#$%");

        WebElement email = driver.findElement(By.xpath("//*[@id=\":rr:\"]"));
        email.clear();
        email.sendKeys("invalidemail");

        WebElement phoneNum = driver.findElement(By.xpath("//*[@id=\":r13:\"]"));
        phoneNum.clear();
        phoneNum.sendKeys("abcdef");

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[7]/div/div[2]/button")));
        submit.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Fill in all required fields to continue')]")));
        Assertions.assertNotNull(errorMessage, "Error message not displayed for invalid input.");

    }

    @Order(3)
    @Test
    public void testFormWithoutInput() throws InterruptedException {
        driver.get("https://secure.booking.com/book.html?hotel_id=828564&occupancy_setup_issue_flags=3&aid=304142&label=gen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ApXSi7wGwAIB0gIkYzE2ODZlNjUtZWYwZC00NGFlLWFmMWUtMDYwZjE3ZmQ0NGFi2AIF4AIB&sid=55da831e680121100860d2ea00a5ea3b&room1=A&room2=A%2CA&error_url=%2Fhotel%2Fba%2Fpansion-jadranka.html%3Faid%3D304142%26label%3Dgen173nr-1FCAEoggI46AdIM1gEaBKIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ApXSi7wGwAIB0gIkYzE2ODZlNjUtZWYwZC00NGFlLWFmMWUtMDYwZjE3ZmQ0NGFi2AIF4AIB%26sid%3D55da831e680121100860d2ea00a5ea3b%26srpvid%3D15c59a4e086904e8%26%26&hostname=www.booking.com&stage=1&checkin=2025-02-07&interval=1&children_extrabeds=&srpvid=15c59a4e086904e8&hp_visits_num=1&rt_pos_selected=1&rt_pos_selected_within_room=1&rt_selected_block_position=1&rt_num_blocks=2&rt_num_rooms=2&rt_num_blocks_per_room=%7B%2282856404%22%3A1%2C%2282856405%22%3A1%7D&rt_selected_blocks_info=%7B%2282856405_203595803_0_2_0%22%3A%7B%22rt_selected_block_position_in_rt%22%3A1%2C%22rt_selected_block_position_in_room_group%22%3A0%2C%22count%22%3A1%2C%22rt_room_symmetry_category%22%3A%22one_rate%22%7D%7D&rt_relevance_metric_id=032e9ed7-34b6-47d3-98e1-fe791d3f3c4d&rt_pageview_id=9c889a52d119029d&rt_pos_final=1.1&rt_selected_total_price=50&rt_cheapest_search_price=100&rt_with_no_dimensions=1&from_source=hotel&basket_id=97dbdbfa-7f0f-4969-a2ba-59459a04767b&nr_rooms_82856405_203595803_0_2_0=1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b2indexPage\"]/div[43]/div/div/div/div[1]/div[1]/div/button")));
            popupButton.click();
        } catch (Exception e) {
            System.out.println("Popup did not appear, skipping popup handling.");
        }
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bookForm\"]/div[7]/div/div[2]/button")));
        submit.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Fill in all required fields to continue')]")));
        Assertions.assertNotNull(errorMessage, "Error message not displayed for invalid input.");

    }
}
