package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker 
{
	static WebDriver driver;
	public static void main(String[]args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome","/usr/local/bin/chromedriver-mac-arm64/chromedriver");
		driver= new ChromeDriver();
		driver.get("https://phptravels.net/");
		
		clickHotel();
		checkInClick();
		clickDate();
		tearDown();
	}
	
	public static void clickHotel()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Hotels']")).click();
	}
	
	public static void checkInClick() throws InterruptedException
	{
		String mon="May 2024";
		WebElement checkIn= driver.findElement(By.id("checkin"));
		checkIn.click();
		
		
		while(true)
		{
			String montext =driver.findElement(By.xpath("//body/div[10]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
			if(montext.equalsIgnoreCase(mon))
			{
				break;
			}
			else
			{
				WebElement clickNext = driver.findElement(By.xpath("//body/div[10]/div[1]/table[1]/thead[1]/tr[1]/th[3]//*[name()='svg']"));
				Thread.sleep(1000);
				clickNext.click();
				
			}
			
		}	
		
	}
	
	public static void clickDate()
	{
		String datenum= "20";
		WebElement date = driver.findElement(By.xpath("//body[@id='fadein']/div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr/td[contains(text(),'"+datenum+"')]"));
		date.click();
	}
	public static void tearDown()
	{
		driver.close();
	}
	
	
}
