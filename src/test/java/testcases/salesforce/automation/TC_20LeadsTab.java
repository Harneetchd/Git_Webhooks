package testcases.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_20LeadsTab
{
	static WebDriver driver;
	public static void main(String[] args)
	{ 
		login();
		leadsTab();
		validateLeadsTab();
		driver.close();
		
	}
	public static void login()
	{
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
	public static void leadsTab()
	{
		WebElement leadtab=driver.findElement(By.xpath("//a[text()='Leads']"));
		leadtab.click();
	}
	public static void validateLeadsTab()
	{
		String actualvalue= driver.getTitle();
		String expectedvalue= "Leads: Home ~ Salesforce - Developer Edition";
		if(actualvalue.equals(expectedvalue))
		{
			System.out.println("Lead Title Page Successful :"+actualvalue);
		}else
		{
			System.out.println("Lead Title Page Fail :"+actualvalue);
		}
	}

}
