package TestNGDemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG_Login {
	WebDriver driver;
	String baseUrl; 
  
  @BeforeMethod
  @Parameters({"browser"})
  public void beforeMethod(String browser) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
	  System.out.println("I am running on" + browser);
	  driver = new ChromeDriver();
	  baseUrl = "https://letskodeit.teachable.com/";
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
  @Test
  public void testLogin() throws InterruptedException {
	  driver.get(baseUrl);
	  WebElement login = driver.findElement(By.xpath("//a[@href = '/sign_in']"));
	  login.click();
	  Thread.sleep(2000);
	  WebElement userName = driver.findElement(By.id("user_email"));
	  userName.sendKeys("test@gmail.com");
	  Thread.sleep(2000);
	  WebElement password = driver.findElement(By.id("user_password"));
	  password.sendKeys("password");
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
