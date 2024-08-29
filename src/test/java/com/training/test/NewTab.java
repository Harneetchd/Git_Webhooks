package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		//in selenium 4: if new tab :driver.switchTo().newWindow(Windowtype.TAB)
		//in selenium 4: if new window :driver.switchTo().newWindow(Windowtype.WIndow)
		String str = Keys.chord(Keys.CONTROL,Keys.ENTER);
		WebElement tabDeal=driver.findElement(By.xpath("//div[@id='main_navbar']//ul[1]//li//a//span[text()='Downloads']"));
		
		tabDeal.sendKeys(str);
		
	    
		
	}
}
