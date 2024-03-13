package testcases.salesforce.automation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountTC10
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		accounts();
		newaccount();
		customerpriority();
		save(); // Pass
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
			System.out.println(element.getAttribute("value"));
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
	
	public static void newaccount() 
	{
		WebElement newaccount=driver.findElement(By.xpath("//input[@value=' New ']"));//finding element for new 
		newaccount.click();
		
		WebElement accountname=driver.findElement(By.id("acc2"));
		accountname.sendKeys("Tekarch1"); // sending information/keys to the accountname
		
		WebElement type=driver.findElement(By.id("acc6"));
		Select optiontype= new Select(type); // Select class is imported as its a drop down
		optiontype.selectByVisibleText("Technology Partner");// we can select by visible text,value or index
	}
	public static void customerpriority() 
	{
		WebElement customerpriority=driver.findElement(By.id("00N5f00000Shnzk"));
		Select priorityoptions= new Select(customerpriority); // dropdown :select class
		priorityoptions.selectByVisibleText("High");
	}
	public static void save()
	{
		List<WebElement> save = driver.findElements(By.xpath("//td[@id='bottomButtonRow']/input")); // save is in table hence :list
		for(WebElement element:save)
		{
			System.out.println(element.getAttribute("value"));
			if(element.getAttribute("value").equalsIgnoreCase(" Save "))
			{
				element.click();
				String titlename= driver.getTitle();
				System.out.println(titlename);
				break;// Pass : New Account:Tekarch, type:TechnologyPartner , Priority:high  is created
			}
			
		}
	}

}
