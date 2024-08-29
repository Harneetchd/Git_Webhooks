package testcases.salesforce.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_32 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{ 
		login();
		contactTab();
		clickOnNew();
		lastName();
		accountName();
		saveAndNew();
		validateFailedMessage();
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
	public static void contactTab() throws InterruptedException
	{
		WebElement clickcontact= driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		clickcontact.click();
		
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
		
		System.out.println("Validation :"+driver.getTitle());// page validation through driver.getTitle
	}
	public static void clickOnNew() 
	{
		WebElement clicknew=driver.findElement(By.xpath("//input[@title='New']"));
		clicknew.click();
	}
	public static void lastName()
	{
		// entering in lastname
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Indian"); 
	}
	public static void accountName()
	{
		// entering account name
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("Global Media"); 
	}
	public static void saveAndNew()
	{
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save & New']")).click();
	}
	public static void validateFailedMessage()
	{
		WebElement errormsg=driver.findElement(By.xpath("//div[@id='errorDiv_ep']"));
		String actualvalue = errormsg.getText();
		String expectedvalue = "Error: Invalid Data.\n"
				+ "Review all error messages below to correct your data.";
		if(actualvalue.equals(expectedvalue))
			{
			  System.out.println("Error Validated :"+actualvalue);
			}
	
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
