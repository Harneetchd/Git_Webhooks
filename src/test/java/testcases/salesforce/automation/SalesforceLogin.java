package testcases.salesforce.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceLogin 
{
	static WebDriver driver;
	
	public static void main(String[] args)
	{
		login();
		//rememberme();
	}
	public static void login()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("harneetkaur@capitalforce.com");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Benihina1018@");
		
		rememberme();
		
		WebElement loginclick=driver.findElement(By.id("Login"));
		loginclick.click();
	}
	public static void rememberme()
	{
		WebElement rememberme=driver.findElement(By.name("rememberUn"));
		explicitwait(10,rememberme);
		rememberme.click();
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
