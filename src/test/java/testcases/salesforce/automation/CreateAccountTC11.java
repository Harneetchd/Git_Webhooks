package testcases.salesforce.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountTC11 
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		accounts();
		createnewview();
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
		submit.click();
	}
	
	public static void createnewview()
	{
		WebElement createnewview=driver.findElement(By.xpath("//a[text()='Create New View']"));// finding element
		createnewview.click(); // click on new view
		
		WebElement viewname=driver.findElement(By.id("fname"));
		viewname.sendKeys("The Accounts"); //  sending information/keys to viewname 
		
		WebElement viewuniquename=driver.findElement(By.id("devname"));
		viewuniquename.sendKeys("ACC");// sending information/keys to viewuniquename
		
		WebElement save=driver.findElement(By.xpath("//input[@data-uidsfdc='4']"));
		save.click();// saving the page  :Pass
		
		
	}
	
}
