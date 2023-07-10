package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

     private WebDriver driver;
     private final String LOGIN_URL = "http://training.skillo-bg.com/users/login";
     WebDriverWait wait;

    @FindBy(id = "homeIcon")
    WebElement logo;

    @FindBy(id = "nav-link-home")
    WebElement homeBtn;

    @FindBy(id = "nav-link-login")
    WebElement loginBtn;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickToLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(logo));
        logo.click();
    }

    public void clickToHome(){
        wait.until(ExpectedConditions.elementToBeClickable(homeBtn));
        homeBtn.click();
    }
    public void clickToLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }
    public void verifyLoginUrl(){
        wait.until(ExpectedConditions.urlContains(LOGIN_URL));
    }
}
