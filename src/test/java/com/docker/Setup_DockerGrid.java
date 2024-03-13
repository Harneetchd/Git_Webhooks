package com.docker;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Setup_DockerGrid {

	@BeforeMethod
	void startDockerGrid() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("cmd /c start start_dockerGrid.bat"
				);
		Thread.sleep(15000);
	}
	
	@AfterMethod
	void stopDockerGrid() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("cmd /c start stop_dockerGrid.bat"
		);
		Thread.sleep(15000);
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); //closes command prompt
		
	}

}
