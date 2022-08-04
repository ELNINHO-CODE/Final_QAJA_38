import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /* **************************************
     *************** Locators ***************
     ***************************************/

    private static final String HOME_PAGE_WRAPPER = "//div[@id='allrecords']";
    private static final String FREE_BUTTON = HOME_PAGE_WRAPPER + "//div[@class='t396__elem tn-elem tn-elem__4567460551658239202580']";
    private static final String TRAINING_BUTTON = HOME_PAGE_WRAPPER + "//div[@class='t396__elem tn-elem tn-elem__4693509551613396199965']";
    private static final String COURSES_BUTTON = HOME_PAGE_WRAPPER + "//div[@class='t396__elem tn-elem tn-elem__4353675611608735104375']";
    private static final String CONTACTS_BUTTON = HOME_PAGE_WRAPPER + "//div[@class='t396__elem tn-elem tn-elem__4693509551613396199943']";
    private static final String SEARCH_EMAIL_FIELD = HOME_PAGE_WRAPPER + "//input[@class='t-input js-tilda-rule']";
    private static final String CLICK_EMAIL_ENTER = HOME_PAGE_WRAPPER + "//input[@class='t-input js-tilda-rule']";
    private static final String SEARCH_RESULT_ERROR_MESSAGE = HOME_PAGE_WRAPPER + "//div[@class='t-form__errorbox-text t-text t-text_xs']";

    /* **************************************
     *************** Methods ****************
     ***************************************/

    public void clickFreeButton() {
        driver.findElement(By.xpath(FREE_BUTTON)).click();
    }
    public void clickTrainingButton() {
        driver.findElement(By.xpath(TRAINING_BUTTON)).click();
    }
    public void clickCoursesButton() {
        driver.findElement(By.xpath(COURSES_BUTTON)).click();
    }
    public void clickContactsButton() {
        driver.findElement(By.xpath(CONTACTS_BUTTON)).click();
    }

    public void EnteringEmailField(String emailAddress){
        driver.findElement(By.xpath(SEARCH_EMAIL_FIELD)).sendKeys(emailAddress);
    }

    public String getSearchResultMarkerFieldAttribute() {
        return driver.findElement(By.xpath(SEARCH_EMAIL_FIELD)).getAttribute("value");
    }
    public int getResultsCount() {
        List<WebElement> results = driver.findElements(By.xpath(SEARCH_EMAIL_FIELD));
        return results.size();
    }
    public String getResultErrorMessage() {
        return driver.findElement(By.xpath(SEARCH_RESULT_ERROR_MESSAGE)).getText();
    }
}
