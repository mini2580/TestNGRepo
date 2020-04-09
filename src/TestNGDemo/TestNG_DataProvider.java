package TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNG_DataProvider {
  
	
	WebDriver driver;
	String baseUrl; 
    @DataProvider(name = "input")
	public Object[][] get_userName_password()
	{
		return new Object[][]{
			{"test1@gmail.com", "pass1234"},
			{"test2@gmail.com", "pass3456"},
			{"test3@gmail.com", "pass6789"}
		};
	}
	
  @BeforeMethod
  	public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://letskodeit.teachable.com/";
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
  @Test(dataProvider = "input")
  public void testLogin(String usrname , String pswd) throws InterruptedException {
	  driver.get(baseUrl);
	  WebElement login = driver.findElement(By.xpath("//a[@href = '/sign_in']"));
	  login.click();
	  Thread.sleep(2000);
	  WebElement userName = driver.findElement(By.id("user_email"));
	  userName.sendKeys(usrname);
	  Thread.sleep(2000);
	  WebElement password = driver.findElement(By.id("user_password"));
	  password.sendKeys(pswd);
	  Thread.sleep(2000);
	  WebElement login_button  = driver.findElement(By.name("commit"));
	  login_button.click();
	  
  }
  
  @AfterMethod
  public void afterMethod() throws InterruptedException { 
	  Thread.sleep(2000);
	  driver.quit();
  }

}
