package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactoryMethods.TestMethods;

// This is a demo of how 'priority' attribute can be used to give a desired order in 
//which we want our test cases to run

public class TestNG_Priority {
  
	  @Test(priority = 2)
	  public void testSum() {
		  TestMethods tm = new TestMethods();
		  int aResult = tm.testsum(2, 2);
		  int eResult = 4;
		  System.out.println("Running test method 1");
		  Assert.assertEquals(aResult, eResult);
		  
	  }
	  @Test(priority = 0)
	  public void testString() {
		  TestMethods tm = new TestMethods();
		  String aResult =  tm.testString("Hello", "TestNG");
		  String EResult = "Hello TestNG";
		  System.out.println("Running test method 2");
		  Assert.assertEquals(aResult, EResult);
		
	  }
	  @Test(priority = 1)
	  public void testBoolean() {
		  TestMethods tm = new TestMethods();
		  Boolean aResult = tm.testboolean();
		  Boolean eResult = false;
		  System.out.println("Running test method 3");
		  Assert.assertEquals(aResult, eResult);
  }
}
