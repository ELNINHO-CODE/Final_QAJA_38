import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chromedriver", "D:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }


    @Test(description = "Search for valid result")
    public void testSearchForValidResult() {

        System.out.println("Step 1. Open 'SkillFactory' Home Page");
        driver.get("https://www.skillfactory.ru/");
        System.out.println("Step 2. Click the 'Бесплатно' button");
        homePage.clickFreeButton();
        System.out.println("Attempting to confirm that the page was opened 'Бесплатно'");
        System.out.println("Step 3. Click the 'Корпоративное обучение' button");
        homePage.clickTrainingButton();
        System.out.println("Attempting to confirm that the page was opened 'Корпоративное обучение'");
        System.out.println("Step 4. Click the 'Курсы' button");
        homePage.clickCoursesButton();
        System.out.println("Attempting to confirm that the page was opened 'Курсы'");
        System.out.println("Step 5. Click the 'Контакты' button");
        homePage.clickContactsButton();
        System.out.println("Attempting to confirm that the page was opened 'Контакты'");

    }

    @Test(description = "Search for invalid result")
    public void testSearchForInvalidResult() {
        String emailAddress = "тут должен быть email";
        String errorMessage = "Укажите, пожалуйста, корректный email";

        System.out.println("Step 1. Open 'skillfactory' Home Page");
        driver.get("https://www.skillfactory.ru/");

        System.out.println("Step 2. Fill in the mail field with an invalid value and click Подписаться");
        homePage.clickFreeButton();
        homePage.clickTrainingButton();
        System.out.println("Attempt to confirm search result is not empty and search value is visible in search result");
        Assert.assertEquals(homePage.getResultErrorMessage(), errorMessage,
                "Error message is not visible");
        Assert.assertEquals(homePage.getResultsCount(), 0, "The address is incorrect");
    }

     /*   @AfterTest
        public void tearDown(){
            driver.quit();
        }*/
    }
