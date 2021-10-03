package mavenseleniumproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataManagement {
	static WebDriver driver;
	 
	/**
	* This function will execute before each Test tag in testng.xml
	* @param browser
	* @throws Exception
	*/
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
//create firefox instance
	if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\\\durgade\\\\eclipse-workspace_learning_selenium\\\\selenium project\\\\drivers\\\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
	 
//Check if parameter passed as 'chrome'
	else if (browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\santhoshg\\eclipse-workspace-learnings-selenium\\SeleniumProject\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	}

	else{
//If no browser passed throw exception
	throw new Exception("Browser is not correct");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public static void Ether() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,60);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
   //Login
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#txtUsername"))).sendKeys("Admin");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=txtPassword]"))).sendKeys("admin123");
       //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("button"))).click();
 
        
   //PDM  
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewPimModule']"))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewPimModule']"))).click();
    	
    	
   //AddEmployee
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_addEmployee"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("formInputText"))) .sendKeys("ether");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))) .sendKeys("teams1");
    	WebElement e1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='employeeId']")));
    	//WebElement e2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input")));name
    	//String s4 = e2.getAttribute("value");
    	//System.out.println(" : "+s4);
   //IsDisplayed 	
    	boolean s1= e1.isDisplayed();
    	if(s1==true) 
    	{
    		System.out.println("Assertion Passed successfully");
    	}
    	
    	String s2 = e1.getAttribute("value");
    	System.out.println("empid : "+s2);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btnSave']"))).click();
       	
       	
      	
   //EMPLOYEE SEARCH
       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewEmployeeList"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("empsearch[employee_name][empName]"))).sendKeys("ether teams1");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("empsearch[id]"))).sendKeys(s2);
     	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchBtn']"))).click();
     	
     	
   //ADMIN
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_viewAdminModule"))).click();   	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_UserManagement"))).click();
    	
    	
   //ADD
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAdd"))).click();
    	Select UserRole = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='systemUser_userType']"))));
    	UserRole.selectByIndex(0);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_employeeName_empName"))).sendKeys("ether teams1");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_userName"))).sendKeys("ether1");
    	Select Addstatus = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='systemUser_status']"))));
    	Addstatus.selectByIndex(0);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_password"))).sendKeys("iplmatch2000");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_confirmPassword"))).sendKeys("iplmatch2000");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnSave']"))).click();
    	
    	
   //ADDSearch
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_viewAdminModule"))).click();   	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_UserManagement"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchSystemUser_userName"))).sendKeys("ether1");
    	Select UserRoleSearch = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='searchSystemUser_userType']"))));
    	UserRoleSearch.selectByIndex(0);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchSystemUser_employeeName_empName"))).sendKeys("ether teams1");
    	Select AddstatusSearch = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='searchSystemUser_status']"))));
    	AddstatusSearch.selectByIndex(1);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchBtn']"))).click();

    //LOGOUT
      	//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Welcome Elakkiya12SA"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //a[@id='welcome']"))).click(); //using partial linktext
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click();
        driver.close();


	}

}
