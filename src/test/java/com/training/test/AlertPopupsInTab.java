package com.training.test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//formating: command+shift+f
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopupsInTab 
{
	static WebDriver driver; // made the variable driver available throughout
	
	public static void main(String[] args) throws InterruptedException, IOException {
		login();
		//Thread.sleep(5000);// as there is a delay; preferred method is Explicit Wait
		//switchToAccounts();
		//alert();
		//windowAlert();
		//promptAlert();
	}
	
	public static void login() throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		// maximize the screen
		driver.manage().window().maximize();
		//to get current url
		System.out.println(driver.getCurrentUrl());
		//to get title
		System.out.println(driver.getTitle());
		//to get pagesource
		//System.out.println(driver.getPageSource());
		Thread.sleep(5000);
		WebElement wetitle=driver.findElement(By.xpath(" //div[@id='login_div']//h3 "));
		//to highlight through javascriptexecutor; & taking Screenshot
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", wetitle);
			
		TakesScreenshot shot= ((TakesScreenshot)driver);
		File src = shot.getScreenshotAs(OutputType.FILE);
		
		String filepath= "/Users/harneetkaur/eclipse-workspace/maventraining/screenshots//javascript.jpeg";
		File dest= new File(filepath);
		FileUtils.copyFile(src, dest);
		
		
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
       // System.out.println(driver.findElement(By.tagName("a")));
		
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
	
	public static void alert()
	{
		WebElement alert = driver.findElement(By.xpath("//a[text()='Alert']"));
		alert.click();
	
	}
	
	public static void windowAlert() throws InterruptedException
	{
		WebElement windowalert=driver.findElement(By.xpath("//button[text()='Window Alert']"));
		windowalert.click();
		Thread.sleep(5000);
		//String alerttext=driver.switchTo().alert().getText();//these 2 lines would be executed before accept otherwise it will throw NO ALERT PRESENT EXCEPTION
		//System.out.println(alerttext);//these 2 lines would be executed before accept otherwise it will throw NO ALERT PRESENT EXCEPTION
		
		driver.switchTo().alert().accept(); // for PopUps & Alerts this is the syntax when you do ok or accept 
		//driver.switchTo().alert().dismiss(); // incase you want to cancel or decline the pop up
		
		
	}
	public static void promptAlert() throws InterruptedException
	{
		WebElement promptalert=driver.findElement(By.xpath("//button[text()='Promt Alert']"));
		promptalert.click();
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("Harry");// if you have to write any text inside the pop up
	    driver.switchTo().alert().accept();// to click on ok or accept the input
	    
	   
		//driver.switchTo().alert().dismiss(); // if the user decides to decline or cancel 
		//WebElement cancelmessage = driver.findElement(By.id("Selenium"));// if the user decides to decline and then wants to get text 
		//String msg = cancelmessage.getText();
		//System.out.println(msg);
	}
}

