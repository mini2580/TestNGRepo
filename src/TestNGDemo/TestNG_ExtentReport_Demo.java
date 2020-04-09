package TestNGDemo;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactoryMethods.VerifyWelcome;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestNG_ExtentReport_Demo {
	//In this class we have utilized  the page object model to demo the extent reporting
	// we can also utilise the Extent Reporting to report for more than one class 
	
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
	  test = report.startTest("Verify Welcome Message from class 1");
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
	  
	  String ExpectedText= "Hello test";
	  String actualText = vw.get_WelcomeText();
	  Assert.assertEquals(actualText, ExpectedText, "The Welcome text does not match or null");
	  test.log(LogStatus.PASS, "Welcome Text is Verified");	  	  
  }
  
  @Test
  public void verifyWelcome2() {
	  test.log(LogStatus.INFO, " VerifyWelcome2 test started....");
	  test.log(LogStatus.INFO, " VerifyWelcome2 test Continuing....");
	  test.log(LogStatus.INFO, " VerifyWelcome2 test End....");
	  test.log(LogStatus.PASS, "VerifyWelcome2 is Passed");
	  
  }
  
  @Test
  public void verifyWelcome3() {
	  test.log(LogStatus.INFO, " VerifyWelcome3 test started....");
	  test.log(LogStatus.INFO, " VerifyWelcome3 test Continuing....");
	  test.log(LogStatus.INFO, " VerifyWelcome3 test End....");
	  test.log(LogStatus.PASS, "VerifyWelcome3 is Passed");
	  
  }
  
  
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }

}
