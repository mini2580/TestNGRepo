package TestNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactoryMethods.TestMethods;

public class DemoAssert {
	@Test
	  public void testMethod1() {
		  TestMethods tm = new TestMethods();
		  int aResult = tm.testsum(2, 2);
		  int eResult = 4;
		  System.out.println("Running test method 1");
		  Assert.assertEquals(aResult, eResult);
		  
	  }
	  @Test
	  public void testMethod2() {
		  TestMethods tm = new TestMethods();
		  String aResult =  tm.testString("Hello", "TestNG");
		  String EResult = "Hello TestNG";
		  System.out.println("Running test method 2");
		  Assert.assertEquals(aResult, EResult);
		
	  }
	  @Test
	  public void testMethod3() {
		  TestMethods tm = new TestMethods();
		  Boolean aResult = tm.testboolean();
		  Boolean eResult = false;
		  System.out.println("Running test method 3");
		  Assert.assertEquals(aResult, eResult);
		  
		  
		
	  }
}
