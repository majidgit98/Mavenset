package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	
	WebDriver driver;
	

	

	@FindBy (id ="login-password")
	WebElement webLoginPassword;
	
	@FindBy (id="login-mobile")
	WebElement webOfloginmobile;

	@FindBy (id ="sub_btn")
	WebElement webSubButton;
	
	
	public LoginClass(WebDriver driver) 
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);;
	}

	public void loginFunction(String x,String y)
	{
		
		webOfloginmobile.sendKeys(x);
		
		webLoginPassword.sendKeys(y);		
		
		webSubButton.click();
		
	}

}
