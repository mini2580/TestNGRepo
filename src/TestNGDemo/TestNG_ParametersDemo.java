package TestNGDemo;

import org.testng.annotations.Test;

import PageFactoryMethods.TestMethods;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNG_ParametersDemo {
 // Remember these parameters from xml file need to be passed to the method to be used by method 
  @BeforeClass
  @Parameters({"browser", "platform"})
  public void beforeClass(String browser, String platform) {
	  System.out.println("Getting browser as : " + browser);
	  System.out.println("Getting platform as : " + platform);
  }

  @Test()
  public void testSum() {
	  TestMethods tm = new TestMethods();
	  int aResult = tm.testsum(2, 2);
	  int eResult = 4;
	  System.out.println("Running testSum");
	  Assert.assertEquals(aResult, eResult);
	  
  }
  @Test()
  public void testString() {
	  TestMethods tm = new TestMethods();
	  String aResult =  tm.testString("Hello", "TestNG");
	  String EResult = "Hello TestNG";
	  System.out.println("Running testString");
	  Assert.assertEquals(aResult, EResult);
	
  }
  @Test()
  public void testBoolean() {
	  TestMethods tm = new TestMethods();
	  Boolean aResult = tm.testboolean();
	  Boolean eResult = true;
	  System.out.println("Running testBoolean");
	  Assert.assertEquals(aResult, eResult);
  }
  
  @AfterClass
  @Parameters({"status"})
  public void afterClass(String status) {
	  System.out.println("The status of webpage is :" + status);
  }

}
