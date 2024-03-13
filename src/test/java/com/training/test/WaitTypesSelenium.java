package com.training.test;
/*
 * Three types of wait: Implicit(at driver level), Explicit(Element level), Fluent(Element Level, with polling)
 * Please comment out METHOD 2 while performing METHOD 1
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitTypesSelenium 
{

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");

		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// IMPLICIT WAIT SYNTAX: METHOD 1
		
		WebElement username = driver.findElement(By.id("email_field"));
		waitforvisibility(10,username);
		//WebDriverWait waito = new WebDriverWait(driver,10); // METHOD 2 EXPLICIT WAIT: For specific elements
	    //waito.until(ExpectedConditions.visibilityOf(username));//METHOD 2 or you make a separate Method as below as its a repeated code
		username.sendKeys("admin123@gmail.com");
	

		WebElement password = driver.findElement(By.cssSelector("#password_field"));// just to show cssSelector;
																					// preference is always by id.
		password.sendKeys("admin123");

		WebElement logintoaccount = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		logintoaccount.click();

		WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
		//fluentwait(home);// METHOD 3 :FLUENT WAY
		waitforvisibility(10,home);// METHOD 2
		// EXPLICIT WAIT: METHOD 2 or you make a separate Method as below as its a repeated code
		//WebDriverWait wait = new WebDriverWait(driver,10);//pass the parameters driver and time 
		//wait.until(ExpectedConditions.visibilityOf(home));//METHOD 2
		home.click();
		
	}
	public static void waitforvisibility(int time,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,time);//pass the parameters driver and time 
		wait.until(ExpectedConditions.visibilityOf(element));//METHOD 2
	}
	public static void fluentwait(WebElement element) 
	{
		FluentWait<WebDriver> flwait= new FluentWait<WebDriver>(driver);//METHOD 3 FLUENT WAIT
		flwait.withTimeout(10, TimeUnit.SECONDS);
		flwait.pollingEvery(200, TimeUnit.MILLISECONDS);
		flwait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
