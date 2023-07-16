package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    private final String URL = "http://training.skillo-bg.com/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo()
    {
        driver.get(URL);
    }
    public void verifyURL(){
        wait.until(ExpectedConditions.urlToBe(URL));
    }
}
