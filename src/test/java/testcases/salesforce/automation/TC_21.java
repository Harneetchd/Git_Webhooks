package testcases.salesforce.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_21 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{ 
		login();
		leadsTab();
		leadsContentView();
		leadContentValidation();
		clickusermenudropdown();
		clickLogout();
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
	public static void leadsTab() throws InterruptedException
	{
		WebElement leadtab=driver.findElement(By.xpath("//a[text()='Leads']"));
		leadtab.click();
		
         Thread.sleep(1000);
		
		List<WebElement> nothanks= driver.findElements(By.xpath("//div[@class='buttonBar']/input"));
		for(WebElement element: nothanks)//the pop up inside table
		{
			//System.out.println(element.getAttribute("value"));
			if(element.getAttribute("value").equalsIgnoreCase("No Thanks"))
			{
				element.click();
				break;
			}
		}
		
		List<WebElement> promptdisplay=driver.findElements(By.xpath("//div[@class='displayContent screen']/fieldset/div/span"));
		for(WebElement element:promptdisplay ) // nextpage display
		{
			//System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("My team/company doesn't use Lightning Experience"))
			{
				element.click();
				break;
			}
		}
		
		WebElement submit=driver.findElement(By.id("lexSubmit"));// submitting
		explicitwait(20,submit);
		submit.click();
		
	}
	public static void leadsContentView()
	{
		WebElement leadcontent=driver.findElement(By.xpath("//select[@id='fcf']"));
		leadcontent.click();
	}
	public static void leadContentValidation()
	{
		List<String>expectedoptions= new ArrayList<String>();
		List<String>actualoptions= new ArrayList<String>();
		expectedoptions.add("All Open Leads");
		expectedoptions.add("My Unread Leads");
		expectedoptions.add("Recently Viewed Leads");
		expectedoptions.add("Today's Leads");
		expectedoptions.add("View - Custom 1");
		expectedoptions.add("View - Custom 2");
		
		List<WebElement> viewleaddropdown= driver.findElements(By.xpath("//select[@id='fcf']/option"));
		for (WebElement element : viewleaddropdown)
		{
			actualoptions.add(element.getText());
		}
		if (actualoptions.equals(expectedoptions))
		{
			System.out.println(" Lead view content Pass: Dropdown Verified "+ actualoptions);
		}else
		{
			System.out.println(" Lead view content Fail");
		}
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
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	

}
