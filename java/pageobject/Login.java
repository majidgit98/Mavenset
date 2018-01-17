package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login	 {

	 WebDriver driver;
//	
//	 By locatorOfMobile = By.id("login-mobile");
//	 By locatorOfPassWord = By.xpath("//input[@class='form-control login-password']");
//	 By locatorOfLog = By.cssSelector("button[id='sub_btn']");
//	
	 @FindBy(id ="login-mobile")
	 WebElement webloginMobile; 
	 
	 @FindBy(id ="login-mobile")
	 WebElement webloginPassWord; 
	 
	 @FindBy(id ="login-mobile")
	 WebElement webloginLogbtn; 
	 
	 String MobileNumber = "9579111188" ;
	 String PassWordText = "123wqsaqw";
	 
	public Login(WebDriver driver2) {

		driver =driver2;
	
	}


	public void loginFunction()
	{
		
//		WebElement Mobile = driver.findElement(locatorOfMobile);
//		Mobile.sendKeys(MobileNumber);


		webloginMobile.sendKeys(MobileNumber);
		
		
//		WebElement PassWord = driver.findElement(locatorOfPassWord);
//		PassWord.sendKeys(PassWordText);

		webloginPassWord.sendKeys(PassWordText);
		
//		WebElement Log = driver.findElement(locatorOfLog);
//		Log.click();
		
		webloginLogbtn.click();
		
	}
	
	
	
	

	}
	 



