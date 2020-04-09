package BasePackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BaseClass -> Before suite ");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BaseClass -> Before Test ");
	}

	@BeforeClass
	public void baseBeforeClass() {
		System.out.println(" BaseClass -> Before class ");
	}

	@AfterClass
	public void baseAfterClass() {
		System.out.println(" BaseClass -> after class ");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseClass -> After Test ");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseClass -> After suite");
	}

}
