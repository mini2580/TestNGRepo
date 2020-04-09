package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.*;

public class ScreenShot {
	
	public static String getScreenShot(WebDriver driver, String fileName) throws IOException{
		fileName = fileName + ".png";
		String directory = "C:\\Users\\Mini\\Documents\\Testing\\ExtentReporting\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName)); 
		String destination = directory + fileName;
		return destination;
	}

}
