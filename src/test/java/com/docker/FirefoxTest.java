package com.docker;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxTest {

	@Test
	public  void test2() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setPlatform(Platform.MAC);
		dc.setBrowserName("firefox");
		//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		//dc.setCapability(CapabilityType.BROWSER_VERSION, null);
		
		URL url = new URL("http://192.168.0.244:4444");
	    //"http://192.168.0.243:4444/wd/hub"
		RemoteWebDriver driver = new RemoteWebDriver(url,dc);
		
		driver.get("https://www.salesforce.com/");
		String title = driver.getTitle();
		System.out.println("Firefox Title:"+title);
		driver.quit();
	}

}
