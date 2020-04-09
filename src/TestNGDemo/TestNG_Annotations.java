package TestNGDemo;

import org.testng.annotations.Test;

import BasePackage.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Annotations extends BaseClass{

	// In This demo file we will see how we can use the different anotations of
	// BeforeMethod and AfterMethod
	// BeforeClass and AfterClass
	// Remember there are other annotations like beforesuite and aftersuite ,
	// beforetest and aftertest
	// BUTTTT you can not use those annotations unless you define a testsuite
	// using an xml file
	// Also you can not define them in normal test class , it will be a base
	// class having all the
	// common things to be done for test class and test class will then inherit
	// base class

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestNG_Annotations ->  Before class-> will run only once\n");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TestNG_Annotations ->  Before Method-> will run before Each Method\n");
	}

	@Test
	public void testMethod1() {
		System.out.println("I am the testmethod , checking for the TITLE of Website\n");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("TestNG_Annotations ->  After Method-> will run After Each Method\n");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestNG_Annotations ->  After class-> will run only once\n");
	}

}
