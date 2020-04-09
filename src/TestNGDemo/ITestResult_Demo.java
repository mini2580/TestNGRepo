package TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ITestResult_Demo {
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Demo of iTestResult /n");
  }

  @Test
  public void testFalse() {
	  System.out.println("Running testFalse ");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void testTrue() {
	  System.out.println("Running testTrue");
	  Assert.assertTrue(true);
  }
  
  @AfterMethod
  public void afterMethod(ITestResult testResult) {
	  if (testResult.getStatus() == ITestResult.FAILURE){
	 System.out.println("Failed: " +  testResult.getName());
	  }
	  
	  if (testResult.getStatus() == ITestResult.SUCCESS){
		  System.out.println("Success: " + testResult.getName());
	  }
	  
  }

}
