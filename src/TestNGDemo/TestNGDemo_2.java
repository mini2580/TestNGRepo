package TestNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class TestNGDemo_2 extends BaseClass{
	@BeforeClass
	public void beforeClass() {
		System.out.println("TestNGDemo_2 ->  Before class-> will run only once\n");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TestNGDemo_2 ->  Before Method-> will run before Each Method\n");
	}

	@Test
	public void testMethod1() {
		System.out.println(" TestNGDemo_2 - >I am the testmethod , checking for the TITLE of Website\n");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("TestNGDemo_2 ->  After Method-> will run After Each Method\n");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestNGDemo_2 ->  After class-> will run only once\n");
	}
}
