package testcases.salesforce.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_33 
{
	static WebDriver driver;
 public static void main(String[] args) throws InterruptedException 
  {
	 login();
	 clickHomeTab();
	 validateUsernameAndMyProfileInfo();
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
public static void clickHomeTab() throws InterruptedException
{
	driver.findElement(By.xpath("//a[@title='Home Tab']")).click();
	
	Thread.sleep(5000);
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
public static void loggedInUser()
{
	WebElement userinfo=driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Harneet Kaur']"));
	System.out.println("Validate User Info :"+userinfo.getText());
	
	userinfo.click();
	String userinfolink=driver.getTitle();
	System.out.println(userinfolink);
}
public static void profiledisplay()
{
	WebElement userhover=driver.findElement(By.id("userNav"));
	userhover.click(); // Dropdown Available : Pass
	
	
	  WebElement myprofile=driver.findElement(By.xpath("//a[text()='My Profile']"));
	  explicitwait(100,myprofile);
	  myprofile.click(); // profile page displayed :Pass	 	
}
public static void validateUsernameAndMyProfileInfo() throws InterruptedException
{
	WebElement userinfo=driver.findElement(By.xpath("//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Harneet Kaur']"));
	System.out.println("Validate User Info :"+userinfo.getText());
	
	userinfo.click();
	String userinfolink=driver.getTitle(); // hometab userinformation 
	//System.out.println(userinfolink);
	
	Thread.sleep(5000);
	WebElement userhover=driver.findElement(By.id("userNav"));
	userhover.click(); // Dropdown Available : Pass
	
	
	WebElement myprofile=driver.findElement(By.xpath("//a[text()='My Profile']"));
    explicitwait(100,myprofile);
	myprofile.click(); // profile page displayed :Pass
	String myprofiletitle= driver.getTitle(); // my profile from usermenu title information
	//comparing if userinfo matches my profileinfo : comparing both titles
	if(userinfolink.equals(myprofiletitle))
	{
		System.out.println("UserInfo Validated :"+userinfolink);
	}
	
}


public static void explicitwait(int time,WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
