package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;


    @BeforeTest
    public void Setup() {
        WebDriverManager.chromedriver().setup(); //Goi phien ban browser

        driver = new ChromeDriver(); //Khoi tao browser

        driver.manage().window().maximize();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    @AfterTest
    public void Teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
