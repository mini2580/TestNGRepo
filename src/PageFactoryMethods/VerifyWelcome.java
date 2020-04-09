package PageFactoryMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;


public class VerifyWelcome {
	
	
	WebDriver driver = null;
	ExtentTest test;
	
	public VerifyWelcome(WebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
	}
	
    public void clickLogin_SignUpButton(){
    	WebElement login_SignUp = driver.findElement(By.xpath("//button[@id = 'comp-iiqg1vggactionTitle']"));
    	login_SignUp.click();
    	test.log(LogStatus.INFO, "Clicking Login/SignUp button ...");
    }
    
    public void click_LoginLink(){
    	WebElement loginLink = driver.findElement(By.xpath("//a[@id = 'signUpDialogswitchDialogLink']"));
    	loginLink.click();
    	test.log(LogStatus.INFO, "Clicking Login Link...");
    }
    
    public void get_Email(){
    	WebElement email = driver.findElement(By.xpath("//input[@id = 'memberLoginDialogemailInputinput']"));
    	email.sendKeys("test@email.com");
    	test.log(LogStatus.INFO, "Entered Email...");
    }
    
    public void get_Password(){
    	WebElement pswd = driver.findElement(By.xpath("//input[@id = 'memberLoginDialogpasswordInputinput']"));
    	pswd.sendKeys("abcabc");
    	test.log(LogStatus.INFO, "Entered Password...");
    }
    
    public void click_LoginButton(){
    	WebElement loginBtn = driver.findElement(By.xpath("//button[@id = 'memberLoginDialogokButton']"));
    	loginBtn.click();
    	test.log(LogStatus.INFO, "Clicked Login button...");
    }
    
    public String get_WelcomeText(){
    	
    	WebElement welcomeText = driver.findElement(By.xpath("//div[text() =  'Hello test']"));
    	String actual = welcomeText.getText();
    	return actual;
    }
}
