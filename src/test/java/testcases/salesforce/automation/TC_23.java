package testcases.salesforce.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_23
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{ 
		login();
		leadsTab();
		todayslead();
		clickOnGo();
		validateTodaysLeadPage();
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
	public static void todayslead()
	{
			List<WebElement> viewleaddropdown= driver.findElements(By.xpath("//select[@id='fcf']/option"));
			for(WebElement element : viewleaddropdown)
			{
				if(element.getText().equalsIgnoreCase("Today's Leads"))
				{
					System.out.println("Dropdown Option Selected :"+element.getText());
					element.click();
					break;
				}
			}
	}
	public static void clickOnGo()
	{
		WebElement go=driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click();
	}
	public static void validateTodaysLeadPage()
	{
		List<WebElement> viewleaddropdown= driver.findElements(By.xpath("//select[@id='00B5f00000GkRm7_listSelect']/option"));
		for(WebElement element : viewleaddropdown)
		{
			if(element.getText().equalsIgnoreCase("Today's Leads"))
			{
				System.out.println("Page Validated:Populated Info :"+element.getText());
				element.click();
				break;
			}
		}
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
