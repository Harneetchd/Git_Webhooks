package testcases.salesforce.automation;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_35 
{
	static WebDriver driver;
	 public static void main(String[] args) throws InterruptedException 
	  {
		 login();
		 Thread.sleep(2000);
		 clickOnPlusTab();
		 clickCustomizeTab();
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
	public static void clickOnPlusTab()
	{
		List<WebElement> plustab=driver.findElements(By.xpath("//nav/ul[@id='tabBar']/li"));
		for(WebElement element : plustab )
		{
			if(element.getAttribute("id").equals("AllTab_Tab"))
			{
				element.click();
			}
		}
		
	}
	public static void clickCustomizeTab()
	{	
		
		  WebElement customizetab=driver.findElement(By.xpath("//td[@class=' oRight']//div[3]//tbody//tr/td[2]/input[@value='Customize My Tabs']" )); 
		 // explicitwait(20,customizetab); 
		  customizetab.click();
		  
		  driver.navigate().refresh();
	      //fix exception with try−catch block
	      try{
	    	  customizetab.click();
	         }
	      catch(StaleElementReferenceException e){
	    	  customizetab=driver.findElement(By.xpath("//td[@class=' oRight']//div[3]//tbody//tr/td[2]/input[@value='Customize My Tabs']" ));
	    	  customizetab.click();
	         //obtain value entered
	         //String s= l.getAttribute("value");
	         //System.out.println("Value entered is: " +s);
	      }
	     
	   
	   }
		 
	
	public static void explicitwait(int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
