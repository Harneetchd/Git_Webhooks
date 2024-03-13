package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSuccessfully {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		
		//maximize the screen
		driver.manage().window().maximize();
		//CHeck title of Screen; returns string
		String title = driver.getTitle();
		String expectedvalue ="Selenium";// pass the value for if else
		System.out.println(title);
		if(expectedvalue.equals(title))
		{
			System.out.println("Browser Launched Successfully!");
		}else
		{
			System.out.println("Test Case Failed!");
		}
		
		
		  Thread.sleep(5000);
		  
		  WebElement username = driver.findElement(By.id("email_field"));
		  username.sendKeys("admin123@gmail.com");  
		 
		  WebElement password = driver.findElement(By.cssSelector("#password_field"));// just to show cssSelector; preference is always by id.
		  password.sendKeys("admin123"); 
		 
		  WebElement logintoaccount = driver.findElement(By.xpath("//button[text()='Login to Account']"));
		  logintoaccount.click();
		 
	}

}
