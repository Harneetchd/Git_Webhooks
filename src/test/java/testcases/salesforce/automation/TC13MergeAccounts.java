package testcases.salesforce.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13MergeAccounts
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		accounts();
		mergeaccounts();
		
	}

	public static void login() {
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
	
	public static void accounts() throws InterruptedException
	{
		WebElement account=driver.findElement(By.xpath("//a[@title='Accounts Tab']"));
		account.click();
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
		Thread.sleep(1000);
		submit.click();
	}
	
	public static void mergeaccounts() throws InterruptedException
	{
		List<WebElement> mergeaccount=driver.findElements(By.xpath("//div[@class='toolsContentRight']/div/div/ul/li/span"));
		for(WebElement element: mergeaccount)
		{
			//System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Merge Accounts"))
			{
				System.out.println(element.getText());
				Thread.sleep(1000);
				element.click();
				break;
			}
		}
		
		WebElement enteraccountname=driver.findElement(By.id("srch"));
		enteraccountname.sendKeys("al");
		
		WebElement findaccounts=driver.findElement(By.xpath("//input[@value='Find Accounts']"));
		findaccounts.click();
		
		WebElement checkbox1=driver.findElement(By.id("cid0"));
		checkbox1.click(); // to uncheck the account; taking only first 2 accounts 
		
		WebElement checkbox2=driver.findElement(By.id("cid1"));
		checkbox2.click();
	
		WebElement next=driver.findElement(By.xpath(" //input[@value=' Next '] "));
		next.click();
		
		WebElement merge= driver.findElement(By.xpath("//input[@value=' Merge ']"));
		merge.click();
		
		driver.switchTo().alert().accept();// PopUp accepted (ok clicked)
}
}
