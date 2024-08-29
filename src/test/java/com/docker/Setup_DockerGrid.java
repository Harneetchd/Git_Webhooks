package com.docker;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Setup_DockerGrid {

	@BeforeTest
	void startDockerGrid() throws IOException, InterruptedException {
		
		//String[] startContainerCommand = {"/bin/bash", "-c", "open -a Terminal /Users/harneetkaur/eclipse-workspace/maventraining/start_dockerGrid.bat"};
		String[] startContainerCommand = {"/bin/bash", "-c", "open -a Terminal start_dockerGrid.bat"};
		
		 Runtime.getRuntime().exec(startContainerCommand);
		
		//Runtime.getRuntime().exec("cmd /c start start_dockerGrid.bat");
		Thread.sleep(15000);
	}
	
	@AfterTest
	void stopDockerGrid() throws IOException, InterruptedException {
		
		//String[] stopContainerCommand = {"/bin/bash", "-c", "open -a Terminal /Users/harneetkaur/eclipse-workspace/maventraining/stop_dockerGrid.bat"};
		String[] stopContainerCommand = {"/bin/bash", "-c", "open -a Terminal stop_dockerGrid.bat"};
		
		Runtime.getRuntime().exec(stopContainerCommand);
		
		
		Thread.sleep(5000);
		
		
		 String[] killTerminalcommand = {"/bin/bash", "-c", "killall Terminal"};
		 Runtime.getRuntime().exec(killTerminalcommand);
		 
		 
		//Runtime.getRuntime().exec("cmd /c start stop_dockerGrid.bat");
	    //Runtime.getRuntime().exec("taskkill /f /im cmd.exe"); //closes command prompt
	}

}
