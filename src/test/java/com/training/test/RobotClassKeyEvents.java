package com.training.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClassKeyEvents
{
	static WebDriver driver;
	
	public static void main(String[] args) throws AWTException 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		//driver.manage().window().maximize();
		
		Robot robot= new Robot();
		robot.mouseMove(500,250);// to move mouse x axis-500 ;y axis =150up and down
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);// to click the mouse
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);//to release the mouse
		
		//For Keyboards:
		robot.keyPress(KeyEvent.VK_CONVERT);//ctrl + roll wheel to zoom in and out
		robot.mouseWheel(50);// 50 megapixels to zoom out
		
		
	}
	public static void explicitwait(int time, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
