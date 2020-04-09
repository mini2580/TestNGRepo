package TestNGDemo;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance(){
		ExtentReports extent ;
		String path = "C:\\Users\\Mini\\Documents\\Testing\\ExtentReporting\\report-demo.html";
		extent = new ExtentReports(path,false);
		extent.addSystemInfo("Selenium version", "2.25");
		return extent;
				
	}

}
