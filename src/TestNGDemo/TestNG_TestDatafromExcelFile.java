package TestNGDemo;

import org.testng.annotations.Test;

import Utilities.Constants;
import Utilities.Excel_Utility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNG_TestDatafromExcelFile {
	
	//This program demonstrates how we can read test data from an excel file with the help of 
	//DataProvider - which leads us to create the data-driven test frameworks
	// To do so , we need a utility , which can setup the excel file and read the excel file
	// to retrieve the test data
  
	WebDriver driver;
	 
	
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
	  driver = new ChromeDriver();
	
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(Constants.baseUrl);
	  WebElement learnNow = driver.findElement(By.xpath("//span [text() = 'Learn Now']"));
	  learnNow.click();
	  //Getting the excel file location to read the data
	//  Excel_Utility.setUpExcelFile(Constants.excel_File_Path + Constants.excel_File_Name, "LoginData");
	  
  }
  
  @DataProvider(name = "loginTestdata")
  public Object[][] dataProvider(){
	  Object[][] testData = ExcelReader.readDataExcel("Invalid_Login");
	  return testData;
  }
  
  @Test(dataProvider = "loginTestdata")
  public void testInvalidLogin(String usrName, String pswd) {
	  
	  
	  WebElement login = driver.findElement(By.xpath("//a [@href = '/sign_in']"));
	  login.click();
	  
	  WebElement userName = driver.findElement(By.xpath("//input[@id = 'user_email']"));
	  userName.sendKeys(usrName);
	  
	  WebElement password = driver.findElement(By.xpath("//input[@id = 'user_password']"));
	  password.sendKeys(pswd);
	  
	  WebElement login_Commit = driver.findElement(By.name("commit"));
	  login_Commit.click();
	  
	  WebElement msg = driver.findElement(By.xpath("//div[@class = 'alert alert-danger']"));
	   String invalid_Msg = msg.getText();
	   boolean result = invalid_Msg != null;
	   Assert.assertTrue(result);
	    
  }

  @AfterClass
  public void afterClass() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }
  
}
