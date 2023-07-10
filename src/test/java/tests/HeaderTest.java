package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;
import pages.HomePage;

import java.time.Duration;

public class HeaderTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void checkHeaderBtn(){
        System.out.println("1. Navigate to Home page");
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        System.out.println("2. Click the logo btn");

        Header headerBtn = new Header(driver);
        headerBtn.clickToLogo();

        System.out.println("3. Check the url is correct");
        homePage.verifyURL();

        System.out.println("4. Click the Home btn");
        headerBtn.clickToHome();

        System.out.println("5. Check the url is correct");
        homePage.verifyURL();

        System.out.println("6. Click the Login btn");
        headerBtn.clickToLogin();

        System.out.println("7. Check the url is correct");
        headerBtn.verifyLoginUrl();




    }
    @AfterMethod
    public void cleanUp(){
        this.driver.close();
    }
}
