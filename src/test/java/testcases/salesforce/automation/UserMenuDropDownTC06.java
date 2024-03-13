package testcases.salesforce.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserMenuDropDownTC06 
{
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		
		login();
		profiledisplay();
		edit();
		//post();
		//fileupload();
		//photo();
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
		password.sendKeys("Hello@123");
		
		WebElement loginclick=driver.findElement(By.id("Login"));
		loginclick.click(); //Pass
	}
	public static void profiledisplay()
	{
		WebElement userhover=driver.findElement(By.id("userNav"));
		userhover.click(); // Dropdown Available : Pass
		
		
		  WebElement myprofile=driver.findElement(By.xpath("//a[text()='My Profile']"));
		  explicitwait(100,myprofile);
		  myprofile.click(); // profile page displayed :Pass	 	
	}
	public static void edit()
	{
		WebElement editdisplay=driver.findElement(By.id("moderatorMutton"));
		explicitwait(20,editdisplay);
		editdisplay.click(); // EditDisplay click :works :Pass
		
		WebElement editprofile=driver.findElement(By.xpath("//a[text()='Edit Profile']"));
		explicitwait(10,editprofile);
		editprofile.click();  // Edit Profile clicked: Pass
		
		WebElement iframe=driver.findElement(By.id("aboutMeContentId"));
		driver.switchTo().frame(iframe); // iframe present before about me
		
		
		WebElement abouttab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		abouttab.click();
		
		WebElement editlastname=driver.findElement(By.id("lastName"));
		editlastname.clear();
		editlastname.sendKeys("Kaur");// sending keys to edit last name: pass
		
		WebElement saveall=driver.findElement(By.xpath("//input[@value='Save All']"));
		saveall.click(); // Saving the Information
	}
	public static void post() 
	{
		
		  WebElement feed=driver.findElement(By.id("profileTab_sfdc.ProfilePlatformFeed"));
		  explicitwait(60,feed); 
		  feed.click();
		 
		
		WebElement post=driver.findElement(By.xpath("//span[text()='Post']"));
		explicitwait(100,post);
		post.click();
		
		WebElement iframe=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		explicitwait(100,iframe);
		driver.switchTo().frame(iframe);
		
		WebElement writetext= driver.findElement(By.xpath("//body[text()='Share an update, @mention someone...']"));
		explicitwait(1000,writetext);
		writetext.sendKeys("Hello, Welcome to Salesforce Automation.");
		
		
		WebElement shareclick= driver.findElement(By.id("publishersharebutton"));
		
		//input[@onclick='chatter.getPublisher().submit();']
		//publishersharebutton
		explicitwait(200,shareclick);
		
	}
	public static void fileupload()
	{
		WebElement feed = driver.findElement(By.id("profileTab_sfdc.ProfilePlatformFeed"));
		explicitwait(100, feed);
		feed.click();
		
		WebElement file=driver.findElement(By.xpath("//span[text()='File']"));
		  file.click();  // clicking on file :Pass
		  
		  /*
		   * WebElement fileclick= driver.findElement(By.xpath("//ul[@class='publisherFeedItemTypeChoices']/li[2]")); 
		   * fileclick.click(); // This Table Method works too :Pass
		   */
		
		 WebElement uploadfromcomp= driver.findElement(By.id("chatterUploadFileAction"));
		 uploadfromcomp.click();   // clicking on upload file tab :Pass
		  
		 WebElement choosefile=driver.findElement(By.id("chatterFile"));
		 choosefile.sendKeys("/Users/harneetkaur/eclipse-workspace/SFDC_TestCases"); // Uploading a file by sending keys by providing 
		
	}
	public static void photo()
	{
		WebElement photohover=driver.findElement(By.xpath("//div[@class='leftContent']/div"));
		explicitwait(800,photohover);
		Actions action = new Actions(driver);  // Hover on the photo :Pass 
		action.moveToElement(photohover).build().perform();
		
		WebElement addphoto=driver.findElement(By.id("uploadLink"));
		explicitwait(110,addphoto);
		String display=addphoto.getText(); // ToolTip: getting the text when you hover:Pass
		System.out.println(display); // just to check if its working 
		addphoto.click();
		
		WebElement iframe=driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(iframe);
		
		
		WebElement choosephotoclick=driver.findElement(By.xpath("//input[@class='fileInput']"));
		explicitwait(100,choosephotoclick);
		choosephotoclick.sendKeys("/Users/harneetkaur/Desktop");
		
		WebElement save=driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		save.submit();
	}
	public static void explicitwait(int time,WebElement element)
	   {
		   WebDriverWait wait= new WebDriverWait(driver,time);
		   wait.until(ExpectedConditions.visibilityOf(element));
	   }
}
