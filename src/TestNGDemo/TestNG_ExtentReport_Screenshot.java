package TestNGDemo;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactoryMethods.VerifyWelcome;
import Utilities.ScreenShot;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNG_ExtentReport_Screenshot {
	//Extent Report also provides a feature to attach a screenshot with the report
	//In this program we will see , how we can do this 
	
  WebDriver driver;
  String baseUrl;
  ExtentReports report;
  ExtentTest test;
  VerifyWelcome vw;
  	
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "http://www.letskodeit.com/";
	  report = ExtentFactory.getInstance();
	  test = report.startTest("Verify Welcome Message from class ExtentReportScreenShot");
	  vw = new VerifyWelcome(driver, test);
	  driver.manage().window().maximize();
	  test.log(LogStatus.INFO, "Browser Maximized....");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Implicit wait Imposed...");
	  
  }

  @Test
  public void verifyWelcome() throws InterruptedException {
	  driver.get(baseUrl);
	  test.log(LogStatus.INFO, "Browser opening...");
	  vw.clickLogin_SignUpButton();
	  Thread.sleep(2000);
	  vw.click_LoginLink();
//	  Thread.sleep(2000);
	  vw.get_Email();
//	  Thread.sleep(2000);
	  vw.get_Password();
	  Thread.sleep(2000);
	  vw.click_LoginButton();
	  Thread.sleep(2000);
	  
	  String ExpectedText= " test";
	  String actualText = vw.get_WelcomeText();
	  Assert.assertEquals(actualText, ExpectedText, "The Welcome text does not match or null");
	  test.log(LogStatus.PASS, "Welcome Text is Verified");	  	  
  }
  
  
  
  @AfterMethod
  public void afterMethod(ITestResult testResult) throws InterruptedException, IOException {
	  if (testResult.getStatus() == ITestResult.FAILURE){
		  String path = ScreenShot.getScreenShot(driver, testResult.getName());
		  String imagepath = test.addScreenCapture(path);
		  test.log(LogStatus.FAIL, "Failed: Not able to verify the welcome Message", imagepath);
	  }
	  Thread.sleep(2000);
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }

}
