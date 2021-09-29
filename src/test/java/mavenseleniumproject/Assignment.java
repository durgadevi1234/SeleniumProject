package mavenseleniumproject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	WebDriver driver;
	public static void main(String[]args)throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//URL into chrome
		driver.get("https://www.saucedemo.com/");
		//login
		WebElement UserName= driver.findElement(By.id("user-name"));
		WebElement Password= driver.findElement(By.name("password"));
		WebElement login= driver.findElement(By.xpath("//input[@value='Login']"));
		UserName.sendKeys("standard_user");
		Password.sendKeys("secret_sauce");
		login.click();
		Thread.sleep(2000);
		//verifying home page
		WebElement logo= driver.findElement(By.className("app_logo"));
		if(logo.isDisplayed()) {
			System.out.println("The logo is verified");
		}
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("shopping_cart_link")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		WebElement firstName =driver.findElement(By.id("first-name"));
		WebElement lastName =driver.findElement(By.id("last-name"));
		WebElement pincode =driver.findElement(By.id("postal-code"));
		firstName.sendKeys("Durga");
		lastName.sendKeys("Devi M");
		pincode.sendKeys("600056");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);
			
	}

}
