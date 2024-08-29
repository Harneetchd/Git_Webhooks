package testcases.salesforce.automation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuDropDownTC05 
{
static WebDriver driver;
	
	public static void main(String[] args)
	{
		login();
		userhover();
		verificationdropdown();
	}
	public static void login()
	{
		//launch and Login :
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("harneetkaur@capitalforce.com");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Benihina1018@");
		
		WebElement loginclick=driver.findElement(By.id("Login"));
		loginclick.click(); //Pass
	}
	public static void userhover()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		//Actions action = new Actions(driver);
		//action.moveToElement(userhover).build().perform();;// Checking for usermenu dropdown(hover) :Pass
		
		explicitwait(20,userhover);
		userhover.click(); // Dropdown Available : Pass	
		
	}
	public static void verificationdropdown()
	{
		//div[@id='userNavMenu']/div[3]/a
		List<String> actualoptions= new ArrayList<String>();
		List<String> expectedoptions = new ArrayList<String>();
		expectedoptions.add("My Profile");
		expectedoptions.add("My Settings");
		expectedoptions.add("Developer Console");
		expectedoptions.add("Switch to Lightning Experience");
		expectedoptions.add("Logout");
		
		List<WebElement> usermenudropdown= driver.findElements(By.xpath("//div[@id='userNavMenu']/div[3]/a"));
		for(WebElement element: usermenudropdown)
		{
			actualoptions.add(element.getText());
		}
		if (actualoptions.equals(expectedoptions))
				{
			       System.out.println("Test Pass");
				}else
				{
				   System.out.println("Test Fail");
				}
	}
	
	public static void explicitwait(int time,WebElement element)
	   {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		   wait.until(ExpectedConditions.visibilityOf(element));
	   }
}
