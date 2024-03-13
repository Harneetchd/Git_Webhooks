package com.training.test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumMaven 
{
	public static void main(String[] args) 
	{
		ArrayList list = new ArrayList();
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup(); //main code(ALWAYS TO REMEMBER)
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		
		
	}
}
