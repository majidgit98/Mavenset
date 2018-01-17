package page.object.model;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyMainClass 
{
	WebDriver driver;
	ExtentTest test;
	ExtentReports extent;
	String phoneNumber="1010109935";
	String passwordtext="test@123";
	String emailText="saurab16458@gmail.com";
	
	

	@BeforeTest
	public void setup()
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Resource/Tracko.html");
		htmlReporter.setAppendExisting(true);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Saurab Tracko - ExtentReports");
		htmlReporter.config().setTheme(Theme.DARK);
		
		// initialize ExtentReports and attach the HtmlReporter
		extent= new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);

		test= extent.createTest("Tracko regression");
		test.assignCategory("Regression");	
		test.assignAuthor("Saurab Dey");
		
		test.info("Starting with Automation");


		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();

		//test.pass("Our browser got initiated");
		
		test.log(Status.PASS, "Our browser got initiated");

		driver.get("https://dev.tracko.co.in/");
		
		//---Screenshot
		CommonMethod ref= new CommonMethod(driver);
		
		try {
			test.info("I am in Setup Method").addScreenCaptureFromPath(ref.screenshot("screenshot2.png"));
		} catch (IOException e) {
			test.fail("Cannot take the screenshot");
		}

		test.pass("My URL launched succssfully");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void signUp() throws IOException
	{
		try {
			test.pass("Starting with SignUp Process");
			
			SignUpClass sign= new SignUpClass(driver,test);
			sign.signupFunction(emailText,phoneNumber,passwordtext);
			test.pass("SuccessFully executed SignUp Process");
		} catch (Exception e) {
			
			CommonMethod ref= new CommonMethod(driver);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ref.screenshot("screenshot1.png")).build();
			test.fail("Something went wrong in SignUp Process", mediaModel);
			
		}

	}

	@Test(priority=2)
	public void login() throws IOException
	{
		try{
			test.pass("Starting with Login Process");
			LoginClass login= new LoginClass(driver);
			login.loginFunction(phoneNumber,passwordtext);
			test.pass("SuccessFully executed Login Process");

		}
		catch (Exception e) {
			CommonMethod ref= new CommonMethod(driver);
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(ref.screenshot("screenshot3.png")).build();
			test.fail("Something went wrong in Login Process", mediaModel);
			
		}
	}
	@Test(priority=3)
	public void product()
	{

	}
	@AfterTest
	public void teardown()
	{
		test.info("End of execution");
		driver.quit();
		extent.flush();
	}

}
