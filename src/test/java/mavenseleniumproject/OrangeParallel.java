package mavenseleniumproject;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
 
 
public class OrangeParallel{

    private WebDriver driver;
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Parameters({ "browser" })
    @BeforeTest

    public void openBrowser(String browser) {
        try {
            if(browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver","C:\\Users\\durgade\\eclipse-workspace_learning_selenium\\selenium project\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("Chrome"));
            System.setProperty("webdriver.chrome.driver","C:\\Users\\durgade\\eclipse-workspace_learning_selenium\\selenium project\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

            }
    catch(WebDriverException e) {
        System.out.println(e.getMessage());

    }
}
 
@Test
 
public void login_TestCase() {
    driver.navigate().to(baseURL);
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();

}
@Test
 
public void search_TestCase() throws InterruptedException {
	Thread.sleep(2000);
	driver.navigate().to(baseURL);
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();

}
@AfterTest
public void closeBrowser() {
    driver.close();
}
}
