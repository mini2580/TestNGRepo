package TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Listeners_Demo {

	@BeforeMethod
	public void setUpBeforeMethod() {
		System.out.println("Demo of Listner Interfaces");
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
	public void cleanUpAfterMethod() {
		System.out.println("End of Demo of Listner Interfaces");
	}

}
