package mavenseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class Example {
    
       //public static void main (String[] args) throws InterruptedException 
	//{
	@Test
	public void maven() throws InterruptedException 
	{
        //System.setProperty("webdriver.chrome.driver","C:C:\Users\durgade\eclipse-workspace_learning_selenium\selenium project\drivers\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C:\\Users\\durgade\\eclipse-workspace_learning_selenium\\selenium project\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Welcome Meghana")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);
        driver.close();
    }
	
 

}

