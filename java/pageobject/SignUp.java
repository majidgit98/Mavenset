 package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp{


    WebDriver driver;
    
    
    By locatorOfSignUpFree =By.xpath("//a[@class='btn btn-cta btn-cta-secondary'][@href='trackoweb/signup.html']");
    By locatorOfName = By.id("name");
    By locatorOfId = By.id("email");
    By locatOfMobileNo = By.xpath("//input[@placeholder='Mobile']");
	By locatorOfSignup = By.id("sub_btn_signup");
    By locatorOfOtp = By.xpath("//input[@placeholder='Otp code']");
    By locatorOfVerifyMobilebutton = By.id("sub_btn_verify");
    By locatorOfOk = By.xpath("//*[@class='confirm']");
    By locatorOfPassWord = By.cssSelector("#password");
    By locatorOfRePassword = By.cssSelector("input[name='repassword']");
    By locatorOfProceedToLogin = By.id("sub_btn_setpass");
		
    String emailId = "ari@gmail.com" ;    		
    String MobileNumber = "9579111188" ;
	String PassWordText = "123wqsaqw";
	
    
    
public SignUp(WebDriver driver) {
		
	this.driver =driver ;
	
	
	}

public void signUpFunction()
{

	CommenMethod c_method= new CommenMethod();
	
	WebElement SignUpFree = driver.findElement(locatorOfSignUpFree);
	SignUpFree.click();

	c_method.waitMethod(2000);

	WebElement Name = driver.findElement(locatorOfName);
	Name.sendKeys("haris");


	WebElement Id = driver.findElement(locatorOfId);
	Id.sendKeys(emailId);

	WebElement MobileNo = driver.findElement(locatOfMobileNo);
	MobileNo.sendKeys(MobileNumber);

	c_method.waitMethod(5000);
	
	WebElement Signup = driver.findElement(locatorOfSignup);
	Signup.click();

	c_method.waitMethod(5000);

	WebElement Otp = driver.findElement(locatorOfOtp);
	Otp.sendKeys("123456");

	WebElement VerifyMobilebutton = driver.findElement(locatorOfVerifyMobilebutton);
	VerifyMobilebutton.click();
	
	c_method.waitMethod(5000);

	WebElement Ok =driver.findElement(locatorOfOk);
	Ok.click();

	WebElement PassWord = driver.findElement(locatorOfPassWord);
	PassWord.sendKeys(PassWordText);

	WebElement RePassword =driver.findElement(locatorOfRePassword);
	RePassword.sendKeys(PassWordText);

	WebElement ProceedToLogin =driver.findElement(locatorOfProceedToLogin);
	ProceedToLogin.click();
	
	c_method.waitMethod(5000);

		
	}
	
	
}

