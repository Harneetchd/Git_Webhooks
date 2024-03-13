package testcases.salesforce.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_25 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{ 
		login();
		contactTab();
		clickNew();
		createNewAccount();
		Thread.sleep(5000);
		iframe1();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.close();
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
		
		System.out.println("Page Validation :"+driver.getTitle());// page validation through driver.getTitle
	}
	
	public static void clickNew()
	{
		WebElement clicknew=driver.findElement(By.xpath("//input[@title='New']"));
		clicknew.click();
		
		System.out.println("Validation :"+driver.getTitle());
	}
	
	public static void createNewAccount() throws InterruptedException
	{
		WebElement lastname=driver.findElement(By.xpath("//input[@id='name_firstcon2']"));
		lastname.sendKeys("Burry");
		
		WebElement accountlookup=driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		accountlookup.click();
		
		Thread.sleep(5000);
		for(String handle : driver.getWindowHandles())//Getting the child window from account look up
		{
			driver.switchTo().window(handle);
		}
		String title =driver.getTitle();
		System.out.println(title); //printing the child window title
	}
		public static void iframe1() throws InterruptedException 
		{
		 Thread.sleep(5000);
		 WebElement iframe=driver.findElement(By.xpath("//frame[@id='searchFrame']"));
		 explicitwait(10,iframe); 
		 driver.switchTo().frame(iframe);
		 
		 
		  WebElement entersearch=driver.findElement(By.xpath("//div[@class='pBody']/input[1]"));
		  explicitwait(10,entersearch); 
		  entersearch.sendKeys("k");
		
		  WebElement clickgo=driver.findElement(By.xpath("//input[@title='Go!']"));
		  explicitwait(10,clickgo); 
		  clickgo.click();
		 
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
