package com.training.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSafariLaunch 
{
	public static void main(String[] args) 
	{
         WebDriverManager.safaridriver().setup();
         
         WebDriver driver= new SafariDriver();
         driver.get("https://www.safari.com");
         
         
         
	}
}
