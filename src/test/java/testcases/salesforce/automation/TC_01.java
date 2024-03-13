package testcases.salesforce.automation;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01
{
	static WebDriver driver;
  public static void main(String[] args)
    {
	    launchBrowser() ;
		enterIntoUsernameError();
		driver.close();
	}

 public static void launchBrowser() 
 {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://login.salesforce.com");
	 
	String actualvalue=driver.getTitle();
	String expectedvalue= "Login | Salesforce";
	Assert.assertEquals(actualvalue, expectedvalue);
	if(actualvalue.equals(expectedvalue))
	
		System.out.println("Test:Salesforce login Page Success");
	else
		System.out.println("Test:Salesforce login Page Fail");

 }
 
 public static void enterIntoUsernameError()
 {
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("harneetkaur@capitalforce.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.clear();

		WebElement loginclick = driver.findElement(By.id("Login"));
		loginclick.click();

		WebElement errormessage = driver.findElement(By.id("error"));
		System.out.println("Login Error Message: "+errormessage.getText());
 }

}
