package com.training.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class withoutWebDriverManagerLaunch 
{
	public static void main(String[] args)
	{
		

		System.setProperty("webdriver.chrome.driver","/Users/harneetkaur/Downloads/chromedriver_mac_arm64 (1)-1/chromedriver");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.google.com/");
	}
}
