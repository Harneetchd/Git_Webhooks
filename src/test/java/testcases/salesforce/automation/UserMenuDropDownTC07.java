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
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuDropDownTC07
{
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		
		login();
		profiledisplay();
		//email();
		//calenderandreminder();
		//verificationpopup();
	}

	public static void login()
	{
		//launch and Login :
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("harneetkaur@capitalforce.com");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("Benihina1018@");
		
		WebElement loginclick=driver.findElement(By.id("Login"));
		loginclick.click(); //Pass
}
	public static void profiledisplay()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		userhover.click(); // Dropdown Available : Pass
		
		WebElement mysettings= driver.findElement(By.xpath("//a[text()='My Settings']"));
		explicitwait(100,mysettings);
		mysettings.click();  // my setting page displayed : Pass
		
	    List<WebElement> displayandlayout=driver.findElements(By.xpath("//div[@id='AutoNumber5']/div"));//since its in a table hence we call list of elements inside
		for(WebElement element: displayandlayout) // we call each element inside the list 
		{
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Display & Layout"))// we check our element with if condition
			{
				element.click(); 
				break;  
			}
		}
		
		List<WebElement> customizemytabs=driver.findElements(By.xpath("//div[@id='DisplayAndLayout_child']/div"));
		for(WebElement element:customizemytabs)
		{
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Customize My Tabs"))
			{
				element.click();
				break;
			}
		}
		
		WebElement customapp=driver.findElement(By.id("p4")); 
		Select dropdownoptions = new Select(customapp); // dropdown hence Select imported
		dropdownoptions.selectByVisibleText("Salesforce Chatter"); // selected by visibility of text
		
		
		List<WebElement> availabletabs=driver.findElements(By.xpath("//select[@id='duel_select_0']/option"));
		for(WebElement element:availabletabs)
		{
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase("Reports"))
			{
				element.click();
				break;
			}
		}
		
		List<WebElement> addbutton=driver.findElements(By.xpath("//td[@class='zen-phs buttonCell']/div/a/img"));
		for(WebElement element:addbutton)
		{
			System.out.println(element.getAttribute("title"));
			if(element.getAttribute("title").equalsIgnoreCase("Add"))
			{
				element.click();
				break;
			}
		}
		
		List<WebElement>save=driver.findElements(By.xpath("//td[@id='bottomButtonRow']/input"));
		for(WebElement element:save)
		{
			System.out.println(element.getAttribute("title"));
			if(element.getAttribute("title").equalsIgnoreCase("Save"))
			{
				element.click();
				break;
			}
		}
	
		}
	
	public static void email()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		userhover.click(); // Dropdown Available : Pass
		
		WebElement mysettings= driver.findElement(By.xpath("//a[text()='My Settings']"));
		explicitwait(100,mysettings);
		mysettings.click();  // my setting page displayed : Pass
		
		WebElement email=driver.findElement(By.id("EmailSetup_font"));// finding email element and clicking
		explicitwait(30,email); 
		email.click();
		
		WebElement emailsettings=driver.findElement(By.id("EmailSettings_font"));// finding email settings element and clicking
		explicitwait(10,emailsettings);
		emailsettings.click();
		
		WebElement emailname=driver.findElement(By.id("sender_name"));// sending keys to fill in name 
		emailname.clear();// we are first clearing any information present
		emailname.sendKeys("Harneet Kaur"); // sending keys
		
		WebElement emailaddress=driver.findElement(By.id("sender_email"));// filling in email id 
		emailaddress.clear();// ciearing any prior information
		emailaddress.sendKeys("chdniti@gmail.com"); // sending email
		
		
		WebElement radiobuttonyes=driver.findElement(By.id("auto_bcc1"));
		radiobuttonyes.click(); //clicking on yes by finding its element
		
		WebElement save=driver.findElement(By.xpath("//input[@value=' Save ']"));
		save.click();// saving the filled in information: Pass
	}
	public static void calenderandreminder()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		userhover.click(); // Dropdown Available : Pass
		
		WebElement mysettings= driver.findElement(By.xpath("//a[text()='My Settings']"));
		explicitwait(200,mysettings);
		mysettings.click();  // my setting page displayed : Pass
		
		WebElement calenderandreminder=driver.findElement(By.id("CalendarAndReminders_font"));
		explicitwait(50,calenderandreminder);
		calenderandreminder.click();// finding element by inspect and clicking the button
		
		WebElement activityreminder=driver.findElement(By.id("Reminders_font"));// finding element
		activityreminder.click();// clicking on activity reminder button
		
		WebElement opentestbutton=driver.findElement(By.id("testbtn"));// finding element for test button
		opentestbutton.click();//clicking on the button : Pass
	}
	
	public static void verificationpopup() throws InterruptedException
	{
		
		/*
		 *  WebElement popupwindow=driver.findElement(By.
		 * xpath("//body[@class='hasMotif homeTab  ActivityReminderPage  brandNoBgrImg']"
		 * )); explicitwait(50,popupwindow); popupwindow.getText();
		 */
		
		WebElement sampleelement=driver.findElement(By.xpath("//div[@id='summary0']/div[1]"));
		String actualvalue= driver.getTitle();
		String expectedvalue= "2 Reminders";
		
		//Assert.assertEquals(actualvalue, expectedvalue);
		//if(actualvalue.equalsIgnoreCase(expectedvalue))
		/*
		 * { System.out.println("Test Result: Verification Confirmed"); }else {
		 * System.out.println("Test Result: Verification Failed"); }
		 */
		
		
		
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

