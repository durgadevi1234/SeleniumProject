package mavenseleniumproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Excelhandlings {

	WebDriver driver;

	Properties prop;

	@BeforeTest

	public void beforeTest() throws IOException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\\\durgade\\\\eclipse-workspace_learning_selenium\\\\selenium project\\\\drivers\\\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get("http://demowebshop.tricentis.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test

	public void testAut() throws InterruptedException {

		readwriteExcel();

	}

	@AfterTest

	public void afterTest() {

		driver.close();

	}

	public String login(String username, String password) throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();

		driver.findElement(By.name("Email")).sendKeys(username);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")).click();
//if(driver.findElements(By.xpath("//input[@id='vote-poll-1']")).size()>0)
//{
		String uname = driver.findElement(By.xpath("//a[@href='/customer/info']")).getText();
		if (uname.equals(username)) {
//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@a");
			driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&b");
		} else {
			driver.findElement(By.xpath("//a[@href='/login']")).click();
			return "Invalid User";
		}
		return "Valid User";
	}

	public void readwriteExcel() throws InterruptedException {
		File file = new File("C:\\Users\\durgade\\Downloads");
		try {
			InputStream is = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet1 = wb.getSheet("Sheet1");
			for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
				String username = sheet1.getRow(i).getCell(0).getStringCellValue();
				String password = sheet1.getRow(i).getCell(1).getStringCellValue();
				String result = login(username, password);
				sheet1.getRow(i).createCell(2).setCellValue(result);
			}
			is.close();
			OutputStream os = new FileOutputStream(file);
			wb.write(os);
			wb.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}