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

public class TC_31 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{ 
		login();
		contactTab();
		clickOnCreateNewView();
		enterInViewName();
		enterViewUniqueName();
		clickOnCancel();
		validationCancelEntry();
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
	public static void clickOnCreateNewView()
	{
		WebElement clickoncreatenewview=driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickoncreatenewview.click();
		
		System.out.println("Validation :"+driver.getTitle());
	}
	public static void enterInViewName()
	{
		WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.sendKeys("ABCD");
	}
	public static void enterViewUniqueName()
	{
		WebElement uniquename=driver.findElement(By.xpath("//input[@id='devname']"));
		uniquename.sendKeys("EFGH");
	}
	public static void clickOnCancel()
	{
		WebElement cancel=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
		cancel.click();
	}
	public static void validationCancelEntry()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle= "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("Validation Contact View Cancel :"+driver.getTitle());
		}
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
