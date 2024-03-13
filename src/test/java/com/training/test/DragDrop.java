package com.training.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop 
{

	static WebDriver driver;

	public static void main(String[] args)
	{
		login();
	    draganddrop();
	    //driver.quit();
	}

	public static void login() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
	}
	
	public static void draganddrop()
	{
		//you can switch to iframe through ID,Name OR Index=(num-1)because it starts from 0
		//driver.switchTo().frame(3);
		
		
		WebElement dragFrom= driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement dragTo = driver.findElement(By.id("trash"));
		//driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.MILLISECONDS);
		
		Actions action= new Actions(driver);
		action.dragAndDrop(dragFrom, dragTo).perform();
				
	}

}
