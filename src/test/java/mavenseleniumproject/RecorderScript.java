package mavenseleniumproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class RecorderScript {
 
WebDriver driver;
 
/**
* This function will execute before each Test tag in testng.xml
* @param browser
* @throws Exception
*/
@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception{
//Check if parameter passed from TestNG is 'firefox'
if(browser.equalsIgnoreCase("firefox")){
//create firefox instance
	WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();
}
 
//Check if parameter passed as 'chrome'
else if (browser.equalsIgnoreCase("chrome")){
//set path to chromedriver.exe
	WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
 
}

else{
//If no browser passed throw exception
throw new Exception("Browser is not correct");
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 
@Test
public void testParameterWithXML() throws InterruptedException, ATUTestRecorderException{
	ATUTestRecorder recorder = new ATUTestRecorder("C:/Users/durgade","myvideo",false);
	recorder.start(); 
	driver.get("https://opensource-demo.orangehrmlive.com/");   

	WebElement uname = driver.findElement(By.id("txtUsername"));
	
	uname.sendKeys("Admin");
	Thread.sleep(2000);
    WebElement passwd = driver.findElement(By.id("txtPassword"));
	
	passwd.sendKeys("admin123");
	
    WebElement submit = driver.findElement(By.id("btnLogin"));
	
	submit.click();
	
	Thread.sleep(3000);
	
	driver.quit();
	recorder.stop();
}
}
