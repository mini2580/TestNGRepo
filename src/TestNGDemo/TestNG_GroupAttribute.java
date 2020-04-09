package TestNGDemo;

import org.testng.annotations.Test;

public class TestNG_GroupAttribute {
  @Test(groups ={"homepage_functionality"} )
  public void testTitle() {
	  System.out.println("Checking for the title of webpage ");
  }
  
  @Test(groups ={"homepage_functionality"} )
  public void testlogo() {
	  System.out.println("Checking for the logo of webpage ");
  }
  
  @Test(groups ={"homepage_functionality"} )
  public void testheader() {
	  System.out.println("Checking for the header of webpage ");
  }
  
  @Test(groups ={"login_functionality"} )
  public void testUserName() {
	  System.out.println("Checking for the UserName of webpage ");
 }
  
  @Test(groups ={"login_functionality"} )
  public void testPassword() {
	  System.out.println("Checking for the password of webpage ");
  }
  
  @Test(groups ={"login_functionality"} )
  public void testForgotPassword() {
	  System.out.println("Checking for the ForgotPassword of webpage ");
  }
  
  
}

