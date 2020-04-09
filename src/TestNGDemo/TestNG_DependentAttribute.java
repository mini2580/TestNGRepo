package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactoryMethods.TestMethods;

public class TestNG_DependentAttribute {
	// This class shows how we can execute the test cases based on the dependency of another test case 
	//Attribute used is dependesOnMethod
	// How it works -- if the dependent test case fails , it will not execute the further test cases 
	//i.e. they will be in skipped state in console report
	// But if you want your test cases to execute in any case even the dependent test case is failed 
	// you have to use the attribute alwaysRun= TRUE
	
	//Also shows the working of attributes "enabled" and "timeout", 
	//enabled attribute is "true" by default
	
	
	 @Test(dependsOnMethods = {"testString"}, alwaysRun = true)
	  public void testSum() {
		  TestMethods tm = new TestMethods();
		  int aResult = tm.testsum(2, 2);
		  int eResult = 4;
		  System.out.println("Running test method 1");
		  Assert.assertEquals(aResult, eResult);
		  
	  }
	  @Test()
	  public void testString() {
		  TestMethods tm = new TestMethods();
		  String aResult =  tm.testString("Hello", "TestNG");
		  String EResult = "Hello FestNG";
		  System.out.println("Running test method 2");
		  Assert.assertEquals(aResult, EResult);
		
	  }
	  @Test(dependsOnMethods = {"testSum"}, alwaysRun = true)
	  public void testBoolean() {
		  TestMethods tm = new TestMethods();
		  Boolean aResult = tm.testboolean();
		  Boolean eResult = true;
		  System.out.println("Running test method 3");
		  Assert.assertEquals(aResult, eResult);
	  }
		  // This test method will not be executed as enabled is false , if I don't give 
	  // enabled attribute also or enable if true , it is one and the same thing
	 @Test(enabled = false)
	 public void testlogin(){
	 System.out.println("TestLogin -- > I am not dependent on any method ");

	 }
	 
	 
	 // This test method will printout the statement but will fail as taking more than timeout value
	 // and next statement will not get printed
	 @Test(timeOut = 100)
	 public void testRegister() throws InterruptedException{
	 System.out.println("TestRegister -- > I am not dependent on any method ");
	 Thread.sleep(300);
	 System.out.println("Thread Sleep over");
 }
}
