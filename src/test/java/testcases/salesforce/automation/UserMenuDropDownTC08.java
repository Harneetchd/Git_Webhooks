package testcases.salesforce.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuDropDownTC08
{
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		login();
		developerconsole();
	}
	
	public static void login()
	{
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

		WebElement loginclick = driver.findElement(By.id("Login"));
		loginclick.click(); // Pass
	}
	
	public static void developerconsole()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		userhover.click(); // Dropdown Available : Pass
		
		WebElement developerconsole=driver.findElement(By.xpath("//a[text()='Developer Console']"));
		developerconsole.click();//developer console clicked
		String parenttitle= driver.getTitle();
		String parentwindow= driver.getWindowHandle();
		for(String handle : driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		String developerconsoletitle = driver.getTitle();
		System.out.println("DeveloperConsole Title: "+developerconsoletitle);
		driver.close();//closes the child window . driver.quit will close all windows
	
	}

	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
