package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @DataProvider(name = "registeredUser")

    public Object[][] dpMethod() {
        return new Object[][]{
                {"pomd","a@a.bg","123456","123456"}
        };
    }

    @Test(dataProvider = "registeredUser")

    public void sendRegisteredUser(String username, String email, String password, String confirmPassword) {
        System.out.println("1. Navigate to home page");
        HomePage homePage = new HomePage(driver);

        homePage.navigateTo();

        System.out.println("2. Navigate to login page");
        Header headerPage = new Header(driver);
        headerPage.clickToLogin();

        System.out.println("3. Check the URL is correct");
        headerPage.verifyLoginUrl();

        // 4. Check the Registration link that is visible and clickable.
        System.out.println("4. Check the Registration link that is visible and clickable.");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.registerBtn();

        System.out.println("5. Sign in is displayed ");
        String headerText = loginPage.getSignInHeaderText();
        Assert.assertEquals(headerText, "Sign up", "Incorrect Sign up header text!");

        System.out.println("6. Enter user name");
        RegisterPage registerPage = new RegisterPage(driver);
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

    @AfterTest

    public void closed() {
        driver.close();
    }

}
