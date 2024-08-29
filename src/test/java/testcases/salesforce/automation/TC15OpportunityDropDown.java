package testcases.salesforce.automation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC15OpportunityDropDown 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		opportunity();
		verification();
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
	
	public static void opportunity() throws InterruptedException
	{
		WebElement opportunitytab=driver.findElement(By.xpath("//a[text()='Opportunities']"));
		opportunitytab.click();
		
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
		
		WebElement oppportunitydropdown=driver.findElement(By.id("fcf"));
		oppportunitydropdown.click();
	}
	public static void verification()
	{	
		//Select options = new Select(oppportunitydropdown);
		List<String> expectedoptions = new ArrayList<String>() ;
		List<String> actualoptions= new ArrayList<String>();
		expectedoptions.add("All Opportunities");
		expectedoptions.add("Closing Next Month");
		expectedoptions.add("Closing This Month");
		expectedoptions.add("My Opportunities");
		expectedoptions.add("New Last Week");
		expectedoptions.add("New This Week");
		expectedoptions.add("Opportunity Pipeline");
		expectedoptions.add("Private");
		expectedoptions.add("Recently Viewed Opportunities");
		expectedoptions.add("Won");
		
		List<WebElement> dropdownoptions = driver.findElements(By.xpath("//select[@id='fcf']/option"));
		for(WebElement element : dropdownoptions)
		{
			actualoptions.add(element.getText());
		}
		if (actualoptions.equals(expectedoptions))
		{
			System.out.println("Test Pass: Dropdown Verified");
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
