package com.training.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderSelenium
{
	static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		//driver.navigate().to(new URL("https://www.google.com"));
		WebElement min_slide=driver.findElement(By.xpath("//span[1]"));
		System.out.println(min_slide.getLocation());
		System.out.println(min_slide.getSize());
	
		
		Actions action= new Actions(driver);
		action.dragAndDropBy(min_slide, 150, 0).click().perform();
		
		
		WebElement max_slide= driver.findElement(By.xpath("//span[2]"));
		action.dragAndDropBy(max_slide, -150, 0).click().perform();
		
		//driver.close();
	}
}
