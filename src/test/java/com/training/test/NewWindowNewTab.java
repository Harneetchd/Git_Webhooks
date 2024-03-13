package com.training.test;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowNewTab 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		login();
		Thread.sleep(5000);// as there is a delay; preferred method is Explicit Wait
		//switchToAccounts();
		//clickwindow();
		//clicknewtab();
		clicknewwindow();
		//driver.close();
	}
	
	public static void login() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		// maximize the screen
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.cssSelector("#password_field"));// just to show cssSelector;
																					// preference is always by id.
		password.sendKeys("admin123");

		WebElement logintoaccount = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		logintoaccount.click();
	}
	
	public static void switchToAccounts()
	{
		WebElement switchtotab = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		//Mouse Hover on Element : Import Actions class
		Actions action = new Actions(driver);//  creating a class: passing driver as constructor
		action.moveToElement(switchtotab).build().perform();//once u have action; it will help u to move to certain element
		
	}
	public static void clickwindow()
	{
		WebElement window=driver.findElement(By.xpath("//a[text()='Windows']"));
		window.click();
	}
	public static void clicknewtab()
	{
		
		  List<WebElement> newtab = driver.findElements(By.xpath("//a[@href='https://www.google.com/']/button"));
		  for(WebElement element: newtab )
		  { 
				if (element.getText().equalsIgnoreCase("Click To Open New Tab"))
				{
					element.click();
				}
		  }
		 
		String parenttitle = driver.getTitle();// get parent title : returns string
		System.out.println(parenttitle);
		
		String parentwindow= driver.getWindowHandle();//get parent window handle : returns string
		System.out.println("Parent Window: "+parentwindow);
		
		for(String handle : driver.getWindowHandles())// get handle from get window handleS
		{
			driver.switchTo().window(handle);
		}
		String title=driver.getTitle();// we will get child title
		System.out.println(title);
		
	}
	public static void clicknewwindow()
	{
		List<WebElement> newtab = driver.findElements(By.xpath("//a[@href='https://www.google.com/']/button"));
		  for(WebElement element: newtab )
		  { 
				if (element.getText().equalsIgnoreCase("Click To Open New Window"))
				{
					element.click();
				}
		  }
		  String parenttitle = driver.getTitle();// get parent title : returns string
			System.out.println(parenttitle);
			
			String parentwindow= driver.getWindowHandle();//get parent window handle : returns string
			System.out.println("Parent Window: "+parentwindow);
			
			for(String handle : driver.getWindowHandles())// get handle from get window handleS
			{
				driver.switchTo().window(handle);
			}
			String title=driver.getTitle();// we will get child title
			System.out.println(title);
			System.out.println(driver.getWindowHandle());
			
	}
	
	

}
