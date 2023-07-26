package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest{

    @DataProvider(name = "registeredUser")

    public Object[][] dpMethod() {
        return new Object[][]{
                {"neos3","t275@abv.bg","123456","123456"}
        };
    }



    @Test(dataProvider = "registeredUser", dependsOnMethods = "navigateToRegisterPage")

    public void sendRegisteredUser(String username, String email, String password, String confirmPassword) {

        System.out.println("6. Enter user name");
        registerPage.enterUserName(username);

        System.out.println("7. Enter mail address");
        registerPage.enterEmail(email);

        System.out.println("8. Enter password");
        registerPage.enterPass(password);

        System.out.println("9. Enter confirm-password");
        registerPage.enterConfirmPassword(confirmPassword);

        System.out.println("10. Click sign in btn");
        registerPage.clickignUpBtn();

        System.out.println("11. Check the URL is correct");
        homePage.verifyURL();


    }
    @Test
    public void navigateToRegisterPage(){
        System.out.println("1. Navigate to home page");
        homePage.navigateTo();

        System.out.println("2. Navigate to login page");
        headerPage.clickToLogin();

        System.out.println("3. Check the URL is correct");
        headerPage.verifyLoginUrl();

        System.out.println("4. Check the Registration link that is visible and clickable.");
        loginPage.registerBtn();

        System.out.println("5. Sign in is displayed ");
        String headerText = loginPage.getSignInHeaderText();
        Assert.assertEquals(headerText, "Sign up", "Incorrect Sign up header text!");


    }
@Test(dependsOnMethods = "navigateToRegisterPage")
    public void sendEmptyForm()
    {
        System.out.println("6.Click Sign In btm with empty fields");
        registerPage.clickignUpBtn();

        System.out.println("7. Validate an unsuccessful pop-up message.");

        String message = registerPage.failedToastMessage().trim();
        Assert.assertEquals(message, "Registration failed!", "Registration is successful: " + message);


    }
    @DataProvider(name = "incorrectFieldValue")

    public Object[][] incorrectValue() {
        return new Object[][]{
                {"k", "m", "12","54"}
        };
    }
    @Test(dataProvider = "incorrectFieldValue", dependsOnMethods = "navigateToRegisterPage")

    public void incorrectFields(String username, String email, String password, String confirmPassword) {

        System.out.println("6. Enter user name");
        registerPage.enterUserName(username);

        System.out.println("7. Enter mail address");
        registerPage.enterEmail(email);

        System.out.println("8. Enter password");
        registerPage.enterPass(password);

        System.out.println("9. Enter confirm-password");
        registerPage.enterConfirmPassword(confirmPassword);

        System.out.println("10. Click sign in btn");
        registerPage.clickignUpBtn();

        System.out.println("11. Validate an unsuccessful pop-up message.");

        String message = registerPage.failedToastMessage().trim();
        Assert.assertEquals(message, "Registration failed!", "Registration is successful: " + message);


    }

    @Test(dataProvider = "incorrectFieldValue", dependsOnMethods = "navigateToRegisterPage")

    public void incorrectUserNameFieldsRedMessage(String username, String email,String password, String confirmPassword) {
        System.out.println("6. Enter user name");
        registerPage.enterUserName(username);
        String nameMessage = registerPage.failedFieldMessage().trim();
        Assert.assertEquals(nameMessage, "Minimum 2 characters !");

    }
    @Test(dataProvider = "incorrectFieldValue", dependsOnMethods = "navigateToRegisterPage")

    public void incorrectEmailFieldsRedMessage(String username, String email,String password, String confirmPassword ) {

        System.out.println("7. Enter mail address");
        registerPage.enterEmail(email);
        String emailMessage = registerPage.failedFieldMessage().trim();
        Assert.assertEquals(emailMessage, "Email invalid!");

    }
    @Test(dataProvider = "incorrectFieldValue", dependsOnMethods = "navigateToRegisterPage")
    public void incorrectPassFieldsRedMessage(String username, String email,String password, String confirmPassword) {

        System.out.println("8. Enter password");
        registerPage.enterPass(password);
        String passMessage = registerPage.failedFieldMessage().trim();
        Assert.assertEquals(passMessage, "Minimum 6 characters !", "Message is: " + passMessage);

    }
    @Test(dataProvider = "incorrectFieldValue", dependsOnMethods = "navigateToRegisterPage")
    public void incorrectConfPassFieldsRedMessage(String username, String email,String password, String confirmPassword) {

        System.out.println("9. Enter confirm-password");
        registerPage.enterConfirmPassword(confirmPassword);
        String confPassMessage = registerPage.failedFieldMessage().trim();
        Assert.assertEquals(confPassMessage, "Passwords do not match!", "Message is: " + confPassMessage);

    }


}
