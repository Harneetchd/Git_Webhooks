package testcases.salesforce.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC16CreateNewOpportunity 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		opportunity();
		newopportunity();
		driver.close();
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
	}
	
	public static void newopportunity() throws InterruptedException
	{
		WebElement newopportunity=driver.findElement(By.xpath(" //input[@value=' New '] "));
		newopportunity.click();
		
		WebElement opportunityname=driver.findElement(By.id("opp3"));
		opportunityname.sendKeys("FrappeJoes");
		
		WebElement accountnamelookup=driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		Thread.sleep(9000);
		accountnamelookup.click();
		
		Thread.sleep(8000);
		String parenttitle = driver.getTitle();
		String parentwindow = driver.getWindowHandle();
		for(String handle :driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
			WebElement iframe= driver.findElement(By.xpath("//frame[@id='searchFrame']"));
			Thread.sleep(5000);
			driver.switchTo().frame(iframe);
			
			Thread.sleep(4000);
			WebElement searchbox=driver.findElement(By.xpath("//input[@id='lksrch']"));
			searchbox.sendKeys("bl");
			
			WebElement clickongo=driver.findElement(By.xpath("//input[@title='Go!']"));
			clickongo.click();
		}
		
		WebElement iframe2= driver.findElement(By.xpath("//frame[@id='resultsFrame']"));
		driver.switchTo().frame(iframe2);
		
		WebElement companyname=driver.findElement(By.xpath("//a[normalize-space()='Blues Entertainment Corp.']"));
		companyname.click();
		
		driver.switchTo().window(parentwindow);
		
		
		WebElement leadsource=driver.findElement(By.id("opp6"));
		leadsource.click();
		Select leadoptions= new Select(leadsource);
		leadoptions.selectByVisibleText("Purchased List");
		
		

		WebElement closedate=driver.findElement(By.xpath("//a[normalize-space()='3/30/2023']"));
		closedate.click();
		
		
		WebElement stage=driver.findElement(By.id("opp11"));
		stage.click();
		Select stageoptions= new Select(stage);
		stageoptions.selectByVisibleText("Negotiation/Review");
		
		
		
		// Probability is based on stage :autofill
		
		
		
		WebElement primarycampaignsource = driver.findElement(By.xpath("//img[@title='Primary Campaign Source Lookup (New Window)']"));
		primarycampaignsource.click();
		primarycampaignsource.sendKeys("Social Media");
		
		
		List<WebElement> save= driver.findElements(By.xpath("//td[@id='bottomButtonRow']/input"));
		for(WebElement element : save)
		{
			System.out.println(element.getAttribute("name"));
			if(element.getAttribute("name").equalsIgnoreCase("save"))
			{
				System.out.println(element.getAttribute("name"));
				element.submit();
				break;
			}
		}
		
		
	}

	
		public static void explicitwait(int time , WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
}
	
