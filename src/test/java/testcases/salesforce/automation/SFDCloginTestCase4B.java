package testcases.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCloginTestCase4B 
{
	static WebDriver driver;

	public static void main(String[] args)
	{
		login();
	}
	public static void login()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("123");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("22131");
		
		WebElement loginclick=driver.findElement(By.id("Login"));
		loginclick.click();
		
		WebElement errormsg=driver.findElement(By.xpath("//div[@id='error']"));
		String actualmessage=errormsg.getText();
		String expectedmesssage="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if (actualmessage.equals(expectedmesssage))
		{
			System.out.println("Error Validation Message :"+actualmessage);
		}else
		{
			System.out.println("Error Validation Failed :"+actualmessage);
		}
}
}
