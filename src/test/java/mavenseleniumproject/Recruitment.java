
package mavenseleniumproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Recruitment {
	WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver",
					"C:\\\\Users\\\\durgade\\\\eclipse-workspace_learning_selenium\\\\selenium project\\\\drivers\\\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\durgade\\eclipse-workspace_learning_selenium\\selenium project\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
//To load orange hrm website
		driver.get("https://opensource-demo.orangehrmlive.com/");
//To maximize
		driver.manage().window().maximize();
		Thread.sleep(2000);
//Verifying the page for heading and logo
		WebElement Logo = driver.findElement(By.tagName("img"));
		System.out.println("Is Orange HRM website logo visible?" + Logo.isDisplayed());
//Login to the page
		WebElement username = driver.findElement(By.name("txtUsername"));
		if (username.isEnabled());
			username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("txtPassword"));
		if (password.isEnabled());
			password.sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();
//Navigating to recruitment Tab
		WebElement Recruitment_tab = driver.findElement(By.cssSelector("#menu_recruitment_viewRecruitmentModule > b"));
		Recruitment_tab.click();
		Thread.sleep(1000);
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("btnAdd")).click();
		WebElement checkbox_active = driver.findElement(By.name("addJobVacancy[status]"));
		Thread.sleep(3000);
		if ((!checkbox_active.isSelected()))
			checkbox_active.click();
		System.out.println("The Vacancy State is active : " + checkbox_active.isSelected());
		Thread.sleep(2000);
		WebElement Publish = driver.findElement(By.name("addJobVacancy[publishedInFeed]"));
		if ((!Publish.isSelected()))
			Publish.click();
		System.out.println("The Vacancy Status is published : " + Publish.isSelected());
		WebElement DropDown = driver.findElement(By.id("addJobVacancy_jobTitle"));
		Thread.sleep(3000);
		Select job = new Select(DropDown);
		job.selectByValue("9");
		WebElement option = job.getFirstSelectedOption();
		String choosen = option.getText();
		Thread.sleep(3000);
//Adding new vacancy details
		driver.findElement(By.id("addJobVacancy_name")).sendKeys("Senior QA Lead");
		Thread.sleep(3000);
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("David Morris");
		Thread.sleep(3000);
		driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("5");
		Thread.sleep(3000);
		driver.findElement(By.id("addJobVacancy_description")).sendKeys(
				"The QA Lead establishes metrics, mentors team members and manages outside resources, as well as developing test programs. Lead and mentor QA team members, as well as manage outside contract testers");
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnBack")).click();
		Thread.sleep(5000);
//Searching Vacancy
		WebElement Job_Title = driver.findElement(By.name("vacancySearch[jobTitle]"));
		Select objj = new Select(Job_Title);
		objj.selectByValue("9");
		Thread.sleep(3000);
		WebElement Vacancy = driver.findElement(By.name("vacancySearch[jobVacancy]"));
		Select obje = new Select(Vacancy);
		obje.selectByVisibleText("Senior QA Lead");
		Thread.sleep(3000);
		WebElement Hiring_Manager = driver.findElement(By.name("vacancySearch[hiringManager]"));
		Select objec = new Select(Hiring_Manager);
		objec.selectByValue("17");
		Thread.sleep(3000);
		WebElement Status = driver.findElement(By.name("vacancySearch[status]"));
		Select object = new Select(Status);
		object.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.name("btnSrch")).click();
		Thread.sleep(5000);
//Deleting Vacancy
		driver.findElement(By.xpath("//th/input")).click();
		driver.findElement(By.name("btnDelete")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
