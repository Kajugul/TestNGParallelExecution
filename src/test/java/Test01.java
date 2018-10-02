import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Test01
{
    public WebDriver driver;
    public String currentURL = "https://www.google.com";

    @BeforeMethod()
    public void preConditionOfSuite()
    {
        String pathChromeDriver = System.getProperty("user.dir") + "//datafiles//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.SECONDS);
    }

    @Test
    public void openGoogle()
    {
        driver.get(currentURL);
    }

    @AfterMethod
    public void postConditions() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.quit();
    }
}
