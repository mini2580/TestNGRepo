package TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TestNG_ReporterLog_Demo {
  
	// TestNG provides its own way to make reports using Reporter , it also gives 
	//the ability to log the messages on console
	// it provides the reports in HTML format in test-output folder , there will be 
	//two reports emailable-report.html and index.html
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Running before test Method");
  }

  @Test
  public void testMethod1() {
	  Reporter.log("Testing the testMethod1", true);
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Running after test method");
  }

}
