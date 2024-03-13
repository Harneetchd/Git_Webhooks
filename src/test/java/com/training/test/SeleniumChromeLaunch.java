package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumChromeLaunch 
{
   public static void main(String[] args) 
   {
	   WebDriverManager.chromedriver().setup();//IMPORTANT... Launches the web browser
	   
	   WebDriver driver= new ChromeDriver();//creates an instance,object of chrome driver:either from Webdriver(preferred) or RemoteWebDRiver
	   
	   driver.get("https://www.google.com/");//enter the URL
	   
	  WebElement srchtext = driver.findElement(By.name("q"));//Find element in Input either by id,name or xpath
	  srchtext.sendKeys("What Is your Selenium?");// entering info by passing .send keys
	   
	  WebElement clickbutton = driver.findElement(By.name("btnK"));
	  clickbutton.click();// clicking the button by .click; 
	   
	  
	   
	   
	   
	   
	   
	   
	 
}
}
