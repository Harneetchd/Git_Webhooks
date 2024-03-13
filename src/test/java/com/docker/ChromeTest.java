package com.docker;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest {
	
	@Test
	public  void test1() throws MalformedURLException {
		//WebDriverManager.chromedriver().setup();
		
		//WebDriver driver;
      
       //ChromeOptions options= new ChromeOptions();
      
      // driver.set(new RemoteWebDriver(new URL(url),options));
		
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		
		URL url = new URL("http://192.168.0.244:4444");
		//http://localhost:4444/wd/hub
		//192.168.0.243
		RemoteWebDriver remotedriver = new RemoteWebDriver(url,dc);
		
		remotedriver.get("https://www.salesforce.com/");
		String title = remotedriver.getTitle();
		System.out.println("Chrome Title:"+title);
		remotedriver.quit();
		//System.out.println("Chrome Title:");
		//assertEquals(true,true);
	}

}
