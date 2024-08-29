package com.training.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropSelenium 
{
	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		login();
		draganddrop();
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
		//please check for any iframe if images arent working and use switchto().frame
		WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(iframe);
		
		
		WebElement dragfrom = driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		// img[@alt='On top of Kozi kopka']=dragfrom
		WebElement dragto = driver.findElement(By.id("trash"));
		// id: trash = dragto
		

		Actions action = new Actions(driver);// actions class is imported to perform drag and drop built in method
		action.dragAndDrop(dragfrom, dragto).build().perform();
	}
	public static void explicitwait(int time,WebElement element)
	{
		//incase you need to add interval time 
		WebDriverWait explicitwait= new WebDriverWait(driver,Duration.ofMillis(time));
		explicitwait.until(ExpectedConditions.visibilityOf(element));
	}
}
