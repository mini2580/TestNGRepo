package TestNGDemo;

import org.testng.annotations.Test;
import PageFactoryMethods.TestMethods;

public class NewTest {
  @Test
  public void testMethod1() {
	  TestMethods tm = new TestMethods();
	  int sum = tm.testsum(2, 2);
	  System.out.println("Running test method 1");
	  System.out.println(sum);
	  
  }
  @Test
  public void testMethod2() {
	  
	  System.out.println("Running test method 2");
	
  }
  @Test
  public void testMethod3() {
	  
	  System.out.println("Running test method 3");
	
  }
  
}
