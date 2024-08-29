package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptSendkeys 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		launch();
		//sendKeys();
		javaScript();
		//tearDown();
	}
	public static void launch()
	{
		System.setProperty("webdriver.chrome.driver","/Users/harneetkaur/eclipse-workspace/TestNGFramework/mydriver/chromedriver");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	public static void sendKeys()
	{
		WebElement ele = driver.findElement(By.id("APjFqb"));
		ele.sendKeys("Selenium");
	}
	
	public static void javaScript()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('APjFqb').value='Selenium';");
		
		//js.executeScript("document.getElementById('gbqfbb').click();");
		
		//Or with Xpath you pass element with args[0].click()
		WebElement searchElement = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]"));
		js.executeScript("arguments[0].click()", searchElement);
	}
	
	public static void tearDown()
	{
		driver.close();
	}
}
