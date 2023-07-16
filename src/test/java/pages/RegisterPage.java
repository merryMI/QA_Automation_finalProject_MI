package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{
    public final String REGISTER_URL = "http://training.skillo-bg.com/users/register";

    // 1. Navigate to Login page http://training.skillo-bg.com/


    // 2. Click Login btn.
    // 3. Check that loading page is : http://training.skillo-bg.com/users/login.
    // 4. Check the Registration link that is visible and clickable.


    //5. Check that loading page is: http://training.skillo-bg.com/users/register
    // 6. Check that the "Sign up" header is displayed
    @FindBy(tagName = "h4")
    WebElement signUpHeader;
@FindBy(name = "username")
    WebElement userName;

@FindBy(css = "[formcontrolname='email']")
WebElement emailField;

@FindBy(name = "password")
WebElement password;
@FindBy(name = "verify-password")
WebElement confirmPassword;

@FindBy(id = "sign-in-button")
WebElement signUpBtn;
    // 7. Enter a username with less than 2 characters. Validate that a red check is displayed after entering the value.
    // 8. Enter email. Validate that a red check is displayed after entering the value.
    // 9. Enter a password with less than 6 characters. Validate that a red check is displayed after entering the value.
    // 10. Enter incorrect confirm password. Validate that a red check is display after entering the value.
    // 11. Click Sign up btn.
    //12. Click Sign with empty form.
    //13. 13. Sending empty form. Validate an unsuccessful pop-up message.
    // 14. Enter registered user. Validate an unsuccessful pop-up message.

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUserNameField(WebElement userName, String value){
    visibilityOf(userName,value);
    }

   public String getText(){
       return getElementText(signUpBtn);
   }
   public void enterUserName(String name){
       visibilityOf(userName, name);
   }
   public void enterEmail(String email){
       visibilityOf(emailField, email);
   }
   public void enterPass(String pass){
       visibilityOf(password, pass);
   }
   public void enterConfirmPassword(String confirmPass){
       visibilityOf(confirmPassword, confirmPass);
   }

   public void clickignUpBtn(){
       clickBtn(signUpBtn);

   }

}
