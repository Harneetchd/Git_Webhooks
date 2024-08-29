package com.training.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DateTimePicker 
{
	static WebDriver driver;
	
	public static void main(String[] args)
	{
		launchUrl();
		dateTime();
		//tearDown();
	}
	
	public static void launchUrl()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/");
	}
	
	public static void dateTime()
	{
		WebElement date = driver.findElement(By.xpath("//form/input[1]"));
		date.sendKeys("10101998");
		
		date.sendKeys(Keys.TAB);
		
		date.sendKeys("1221");
		date.sendKeys(Keys.ARROW_DOWN);
		
	    driver.findElement(By.xpath("//form/input[2]")).click();
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	    
	    String expDateTitle ="Your Birth Date is 1998-10-10 Your Birth Time is 12:12";
	    		           
	 
	    //Your Birth Date is 1998-10-10
	    //Your Birth Time is 12:12
	    
	    WebElement actDate = driver.findElement(By.xpath("//div[contains(text(),'Date')]"));
	    String actDateTitle = actDate.getText();
		
	    Assert.assertEquals(actDateTitle, expDateTitle,"Titles dont match");
	}
	
	public static void explicitWait(int time, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void tearDown()
	{
		driver.quit();
	}
	
}
