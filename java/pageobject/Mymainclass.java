package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mymainclass {
    
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{

		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.tracko.co.in/");

	}
	
	@Test(priority=1)
	public void signUp()
	{
		SignUp sign = new SignUp(driver);
		sign.signUpFunction();
	}
	
	@Test(priority=2)
	public void login()
 	{

        Login login = new Login(driver);
        login.loginFunction();

	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
}

