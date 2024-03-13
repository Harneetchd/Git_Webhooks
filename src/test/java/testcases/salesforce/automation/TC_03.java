package testcases.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		launchBrowser();
		enterIntoUsernameSuccess();
		clickusermenudropdown();
		clickLogout();
		validateusername();
		driver.close();
	}

	public static void launchBrowser() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");

		String actualvalue = driver.getTitle();
		String expectedvalue = "Login | Salesforce";
		Assert.assertEquals(actualvalue, expectedvalue);
		if (actualvalue.equals(expectedvalue))

			System.out.println("Success:Salesforce Browser Launched");
		else
			System.out.println("Fail:Salesforce Browser failed to Launch");

	}

	public static void enterIntoUsernameSuccess() 
	{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("harneetkaur@capitalforce.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Benihina1018@");
		
		WebElement rememberme=driver.findElement(By.xpath("//input[@class='r4 fl mr8']"));
		rememberme.click();
		
		WebElement loginclick = driver.findElement(By.id("Login"));
		loginclick.click();

		String expectedvalue = "Home Page ~ Salesforce - Developer Edition";
		String actualvalue = driver.getTitle();

		if (actualvalue.equals(expectedvalue))

			System.out.println("Success: " + actualvalue);
		else
			System.out.println("Fail");
	}
	public static void clickusermenudropdown()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		//Actions action = new Actions(driver);
		//action.moveToElement(userhover).build().perform();;// Checking for usermenu dropdown(hover) :Pass
		
		explicitwait(20,userhover);
		userhover.click(); // Dropdown Available : Pass	
		
	}
	public static void clickLogout()
	{
		WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
	}
	public static void validateusername() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement populatedusername = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
	
		String actualvalue = populatedusername.getText();
		String expectedvalue = "harneetkaur@capitalforce.com";
		if (actualvalue.equals(expectedvalue)) 
		{
			System.out.println("Username Validated: " + actualvalue);
		} else 
		{
			System.out.println("Username Validation Failed");
		}
	}
	
	public static void explicitwait(int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
