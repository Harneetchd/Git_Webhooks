package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorSelenium 
{
	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		login();
		//calculator();
	}
	public static void login()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("email_field"));
		explicitwait(15,username);
		username.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.cssSelector("#password_field"));// just to show cssSelector;
																					// preference is always by id.
		password.sendKeys("admin123");

		WebElement logintoaccount = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		logintoaccount.click();
		
	}
	public static void calculator()
	{
		WebElement calculator=driver.findElement(By.xpath("//a[text()='Calculator']"));
		explicitwait(10,calculator);
		calculator.click();
		
		
		WebElement num1=driver.findElement(By.xpath("//input[@value='2']"));
		explicitwait(99999999,num1);
		num1.click();
		
		
		WebElement addnum=driver.findElement(By.xpath("//input[@value='+']"));
		explicitwait(99999999,addnum);
		addnum.click();
		
		WebElement num2=driver.findElement(By.xpath("//input[@value='3']"));
		explicitwait(99999999,num2);
		num2.click();
		
		WebElement equalsto=driver.findElement(By.xpath("//input[@value='=']"));
		explicitwait(99999999,equalsto);
		equalsto.click();
		
		
		  WebElement display=driver.findElement(By.id("display"));
		  //explicitwait(10,display); 
		  String expectedvalue = "6";
		  String screen=display.getAttribute("value");
		  Assert.assertEquals(screen, expectedvalue);
		  System.out.println(screen);
		 
		
	}
	public static void explicitwait(int time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
