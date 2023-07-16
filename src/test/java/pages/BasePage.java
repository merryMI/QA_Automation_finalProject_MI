package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

   protected WebDriverWait wait;
   protected  WebDriverWait mediumWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void clickBtn(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }
    public void visibilityOf(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
         element.sendKeys(value);
    }
    public String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void elementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


}
