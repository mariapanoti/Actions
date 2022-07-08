import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class actionsTest
{
    private WebDriver driver;

    @BeforeEach
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void userLoginTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
      //  wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();
        WebElement searchTxt = driver.findElement(By.name("q"));
        searchTxt.sendKeys("automation");
        System.out.println("Current URL is:" + driver.getCurrentUrl());
        System.out.println("Current Title is:" + driver.getTitle());
    }

    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
