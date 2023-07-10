package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class HomeTest {

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
    public void checkHomeURL(){
        System.out.println("1. Navigate to Base URL");
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        System.out.println("2. Check the Home URl is correct");
        homePage.verifyURL();
    }
    @AfterMethod
    public void cleanUp(){
        this.driver.close();
    }
}