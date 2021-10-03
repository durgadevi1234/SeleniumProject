package mavenseleniumproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelTest {

	private WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	private static final Logger logger = LogManager.getLogger(parallelTest.class);

	@Parameters({ "browser" })
	@BeforeTest
	public void openbrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				// create firefox instance
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver","C:\\Users\\santhoshg\\eclipse-workspace-learnings-selenium\\SeleniumProject\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void login_Testcase() {
		driver.navigate().to(baseURL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name=txtPassword]")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		/*
		 * BasicConfigurator.configure(); logger.info("Inside Login testCase");
		 * logger.info("we are in logger info mode");
		 */

	}

	@Test
	public void search_Testcase() throws InterruptedException {
		driver.navigate().to(baseURL);
		// PDM
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		// AddEmployee
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.className("formInputText")).sendKeys("ether");
		driver.findElement(By.id("lastName")).sendKeys("teams");
		WebElement e1 = driver.findElement(By.xpath("//input[@name='employeeId']"));
		String s2 = e1.getAttribute("value");
		System.out.println("empid : " + s2);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		// EMPLOYEE SEARCH
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		driver.findElement(By.name("empsearch[employee_name][empName]"))
				.sendKeys("ether teams");
		driver.findElement(By.name("empsearch[id]")).sendKeys(s2);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		// ADMIN
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		// ADD
		driver.findElement(By.id("btnAdd")).click();
		Select UserRole = new Select(driver.findElement(By.xpath("//select[@id='systemUser_userType']")));
		UserRole.selectByIndex(0);
		driver.findElement(By.id("systemUser_employeeName_empName"))
				.sendKeys("ether teams");
		driver.findElement(By.id("systemUser_userName")).sendKeys("ether1234");
		Select Addstatus = new Select(
				driver.findElement(By.xpath("//select[@id='systemUser_status']")));
		Addstatus.selectByIndex(0);
		driver.findElement(By.id("systemUser_password")).sendKeys("ether12345");
		driver.findElement(By.id("systemUser_confirmPassword"))
				.sendKeys("ether12345");
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		// ADDSearch
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("ether1234");
		Select UserRoleSearch = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']")));
		UserRoleSearch.selectByIndex(1);
		driver.findElement(By.id("searchSystemUser_employeeName_empName"))
				.sendKeys("ether teams");
		Select AddstatusSearch = new Select(driver.findElement(By.xpath("//select[@id='searchSystemUser_status']")));
		AddstatusSearch.selectByIndex(1);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

	}

	@AfterTest
	public void close_browser() throws InterruptedException {
		// driver.findElement(By.partialLinkText("Paul")).click();
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.quit();

	}

}