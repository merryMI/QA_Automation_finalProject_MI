package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Header;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected RegisterPage registerPage;
    protected Header headerPage;
    protected LoginPage loginPage;
    private final String URL = "http://training.skillo-bg.com/posts/all";

    protected HomePage homePage;
    @BeforeClass
    protected void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        headerPage = new Header(driver);
        loginPage = new LoginPage(driver);



    }


    @AfterClass
    public void cleanUp(){
        this.driver.close();
    }
}
