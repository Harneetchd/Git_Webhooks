package testcases.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuDropDownTC09 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		logout();
		validateusername();
	}

	public static void login() {
		// launch and Login :
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("harneetkaur@capitalforce.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Benihina1018@");
		
		WebElement rememberme=driver.findElement(By.xpath("//input[@class='r4 fl mr8']"));
		rememberme.click();

		WebElement loginclick = driver.findElement(By.id("Login"));
		loginclick.click(); // Pass
	}
	
	public static void logout()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		userhover.click(); // Dropdown Available : Pass
		
		WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
	}
	public static void validateusername() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
	
		String actualvalue = username.getText();
		String expectedvalue = "harneetkaur@capitalforce.com";
		if (actualvalue.equals(expectedvalue)) 
		{
			System.out.println("Username Validated: " + actualvalue);
		} 
		else 
		{
			System.out.println("Username Validation Failed");
		}
     }
}
