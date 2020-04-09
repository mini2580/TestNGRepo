package Listeners;


import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener implements IInvokedMethodListener, ITestListener, ISuiteListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// IInvokedMethodListener interface implements this method
		//This method will be run before each method in the test class, 
		//whether it is a before class method or test method
	 System.out.println("Before Invocation:\n" + 
			 			"Running the method :" +
			 	         method.getTestMethod().getMethodName() + 
			 	         " of class" + 
			 	         testResult.getTestClass().getName());
	 
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// IInvokedMethodListener interface implements this method
		//This method will be run after each method in the test class, 
		//whether it is a before class method or test method
		
		System.out.println("After Invocation:\n" +
						   "Running the method :" +
						   method.getTestMethod().getMethodName() +
						   " of class" + 
						   testResult.getTestClass().getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// ITestListener implements this method
		//This will run only for test method
		
		System.out.println("The name of onTestStart method: " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// ITestListener implements this method
		//This will run only for test method 
		
		System.out.println(" onTestSuccess: The status is " + result.getStatus());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// ITestListener implements this method
		//This will run only for test method 
				
		System.out.println(" onTestFailure: The status is " + result.getStatus());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// ITestListener implements this method
		//This will run only for test method 
		
		System.out.println("onTestSkipped: The status is " + result.getStatus());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// ITestListener implements this method
		//This will run only for test method 
		
		System.out.println("NOT DOING MUCH HERE");
		
	}

	@Override
	public void onStart(ITestContext context) {
		// ITestListener implements this method
		//This will RUN ONLY  ONCE BEFORE THE TEST TAG OF XML FILE 
		System.out.println("onStart: " + context.getName() + "\n");
		ITestNGMethod methods[] = context.getAllTestMethods();
		
		System.out.println("All the test methods in this test class are:\n");
		for (ITestNGMethod method : methods){
			System.out.println(method);
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// ITestListener implements this method
		//This will RUN ONLY  ONCE AFTER THE TEST TAG OF XML FILE 
		
		System.out.println("onFinish " + context.getFailedTests());
		
	}

	@Override
	public void onStart(ISuite suite) {
		// ISuiteListener implements this method
		//Runs only once at the start of the suite
		System.out.println("OnStartSuite: " + suite.getName() + "\n");
//		List <IInvokedMethod> methodList = suite.getAllInvokedMethods();
//		System.out.println("The list of Invoked method is as follows:\n");
//		for(IInvokedMethod list: methodList )
//		{
//			System.out.println(list.getName());
//		}
				
	}

	@Override
	public void onFinish(ISuite suite) {
		// ISuiteListener implements this method
		//Runs only once at the end of the suite
		System.out.println("onFinishSuite: The suite state is : " + suite.getSuiteState());
		
	}

}
