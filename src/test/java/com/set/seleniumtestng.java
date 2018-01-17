package com.set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class seleniumtestng {
	WebDriver driver;
	
	 @BeforeTest
	  public void beforeTest() 
	 {
		 System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://en-gb.facebook.com/login/");
		 
	  }


  @Test
  public void f()
  {
  }
 
  @AfterTest
  public void afterTest() 
  {
  }

}
