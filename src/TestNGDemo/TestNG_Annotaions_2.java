package TestNGDemo;

import org.testng.annotations.Test;

import BasePackage.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Annotaions_2 extends BaseClass {
	//The purpose of making this class is to show that we want to club the test classes into a 
	//test suite using an xml file 
	// so we are going to create an xml file having the suite name , then test name , then the class name 
	//lets create an xml file in TestNG-Tutorial folder 
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("TestNG_Annotations_2 ->  Before class-> will run only once\n");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TestNG_Annotations_2 ->  Before Method-> will run before Each Method\n");
	}

	@Test
	public void testMethod1() {
		System.out.println("I am the testmethod , checking for the REGISTRATION of Website\n");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("TestNG_Annotations_2 ->  After Method-> will run After Each Method\n");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestNG_Annotations_2 ->  After class-> will run only once\n");
	}


}
