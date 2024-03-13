package com.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumRelativeXpath
{
   public static void main(String[] args) 
	{
       WebDriverManager.chromedriver().setup();
       
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.selenium.dev/");
       
       //finding element with xpath-RelativeXpath. Since its a text so we get.text in the end , 
       //and return type of text would be String.
       String str = driver.findElement(By.xpath("//h4[text()='Selenium IDE']")).getText();//METHOD 1 with Text()
       
       
       String containtext = driver.findElement(By.xpath("//h4[contains(text(),'IDE')]")).getText();//Method 2 With Contains()Text
       
       
       
       
       
       
	}
}
