package testcases.salesforce.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC14CreateAccountReport
{
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		login();
		accounts();
		report();
		createdate();
		
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
	public static void report() 
	{
		WebElement report=driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
		report.click();
		
		String actualvalue=driver.getTitle();
		String expectedvalue="Unsaved Report ~ Salesforce - Developer Edition";
		if(actualvalue.equals(expectedvalue))
		{
			System.out.println("Successful Loading :"+actualvalue);
		}
		else
		{
			System.out.println("Failed Loading :"+actualvalue);
		}
	}
	public static void createdate() throws InterruptedException
	{
		WebElement datefield=driver.findElement(By.id("ext-gen148"));
		datefield.click();
		
		WebElement accountgeneral=driver.findElement(By.xpath("//div[text()='Created Date']"));
		Actions action = new Actions(driver);
		action.moveToElement(accountgeneral).build().perform();
		accountgeneral.click();
		
		WebElement fromdate=driver.findElement(By.id("ext-gen152"));
		fromdate.click();
		
		WebElement todaysdate=driver.findElement(By.id("ext-gen281"));
		todaysdate.click();
		
		//WebElement todate=driver.findElement(By.id("ext-gen154"));
		//todate.click();
		
		
		//WebElement todaysdateto=driver.findElement(By.xpath("//button[@id='ext-gen279']"));
		//todaysdateto.click();
		 //button[@id='ext-gen279']
		
		WebElement save = driver.findElement(By.id("ext-gen49"));
		save.click();
		
		
		List<WebElement> report=driver.findElements(By.xpath("//div[@id='x-form-el-saveReportDlg_reportNameField']/input"));
		for(WebElement element: report)
		{
			System.out.println(element.getAttribute("id"));
			if(element.getAttribute("id").equalsIgnoreCase("saveReportDlg_reportNameField"))
			{
				element.sendKeys("Report March 28th");
				break;
			}
		}
		
		List<WebElement> reportuniquename= driver.findElements(By.xpath("//div[@id='x-form-el-saveReportDlg_DeveloperName']/input"));
		for(WebElement element: reportuniquename)
		{
			if(element.getAttribute("id").equalsIgnoreCase("saveReportDlg_DeveloperName"))
			{
				element.clear();
				element.sendKeys("_20231");//change the value everytime*or delete after every run
				break;
			}
		}
		
		WebElement saveandrun=driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]//button"));
		Thread.sleep(8000);
		saveandrun.click();
		/*
		 * WebElement saveandrun=driver.findElement(By.xpath(
		 * "//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]/em/button"));
		 * explicitwait(30,saveandrun); saveandrun.click();
		 */
		 
		/*
		 * List<WebElement> saveandrun = driver .findElements(By.xpath(
		 * "//td[@class='x-btn-mc']/em/button[contains(text(),'Save')]")); for
		 * (WebElement element : saveandrun) { System.out.println(element.getText());
		 * if(element.getText().equalsIgnoreCase("Save and Run Report")) {
		 * System.out.println(element.getText()); element.click(); break; } }
		 */
	}
	
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
