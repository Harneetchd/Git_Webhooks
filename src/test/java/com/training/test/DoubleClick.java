package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick 
{
	static WebDriver driver;
   public static void main(String[] args) 
	{
	   login();
	   movetointeractions();
	   //doubleclick();
	   tooltip();
	    
	}
   public static void login()
   {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.get("https://selenium-prd.firebaseapp.com/");
		// maximize the screen
	   driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("email_field"));
		explicitwait(10,username);
		username.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password_field"));// just to show cssSelector;
																					// preference is always by id.
		password.sendKeys("admin123");

		WebElement logintoaccount = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		logintoaccount.click();
   }

   public static void explicitwait(int time,WebElement element)
   {
	   WebDriverWait wait= new WebDriverWait(driver,time);
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   public static void movetointeractions()
   {
	   WebElement interactions = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
	   explicitwait(10,interactions);
	   interactions.click();
   }
   public static void doubleclick()
   {
	   WebElement dblclick=driver.findElement(By.xpath("//a[text()='Double Click']"));
	   // another x.path  "//a[@href='./double-click.html']"
	   dblclick.click();
	   
	 //create an actions class as there is no option for double click
	   WebElement buttondoubleclick=driver.findElement(By.xpath("//button[text()='Double Click']"));
	   explicitwait(10,buttondoubleclick);
	   Actions action = new Actions(driver);
	   action.doubleClick(buttondoubleclick).build().perform();
	  
   }
   public static void tooltip() 
   {
	  WebElement tooltipclick=driver.findElement(By.xpath("//a[text()='Tool Tip']"));
	  tooltipclick.click();
	  
	  WebElement righthover=driver.findElement(By.xpath("//div[contains(text(),'Right')]"));
	  Actions action = new Actions(driver);
	  action.moveToElement(righthover).build().perform();
	  
	  WebElement righttext=driver.findElement(By.xpath("//span[@class='tooltiptextr']"));
	  String strrighttext=righttext.getText();// as we are reading the text, while hovering on right hover : we are using get.text:it returns string
   }
}
