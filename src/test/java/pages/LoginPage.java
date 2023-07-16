package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private final String URLLogin = "http://training.skillo-bg.com/users/login";
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "form>h4")
    WebElement signInText;
    @FindBy(name = "usernameOrEmail")
    WebElement userNameField;
    @FindBy(name = "password")
    WebElement passField;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;
    @FindBy(linkText = "Register")
    WebElement registerBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void enterUserNameOrEmail(String userName) {
//        wait.until(ExpectedConditions.visibilityOf(userNameField));
//        userNameField.sendKeys(userName);
        visibilityOf(userNameField, userName);
    }

    public void enterPass(String pass) {
//        wait.until(ExpectedConditions.visibilityOf(passField));
//        passField.sendKeys(pass);
        visibilityOf(passField, pass);

    }

    public void clickSignInBtn() {
//        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
//        signInBtn.click();
        elementClickable(signInBtn);
    }

    public void checkURL() {
        wait.until(ExpectedConditions.urlToBe(URLLogin));

    }

    public String getSignInHeaderText() {
//        wait.until(ExpectedConditions.visibilityOf(signInText));
//        return signInText.getText();
        return getElementText(signInText);


    }
    public void registerBtn() {
        clickBtn(registerBtn);
    }
}
