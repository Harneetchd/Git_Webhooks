package com.docker;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class MicrosoftEdgeTest {

	@Test
	public  void test3() throws MalformedURLException {
		
		WebDriverManager.edgedriver().setup();
		//System.out.println("MicrosoftEdge Title:");
		DesiredCapabilities dc = new DesiredCapabilities();
//		if (dc != null)
//		{
			dc.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
			URL url = new URL("http://localhost:4445/wd/hub");
			
			RemoteWebDriver driver = new RemoteWebDriver(url,dc);
			
			driver.get("https://www.salesforce.com/");
			String title = driver.getTitle();
			System.out.println("MicrosoftEdge Title:"+title);
			driver.close();
//        } 
//		else
//			
//        	System.out.println("DesiredCapabilities object is null");
//		
		
		
		
		
		
		
 
		
	}

	

}
