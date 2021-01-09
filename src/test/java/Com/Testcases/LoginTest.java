package Com.Testcases;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.Pages.LoginPage;
import Com.Utils.Readpropertyfile;
import Com.browsers.Baseclass;



                                                                                                                    


public class LoginTest  extends Baseclass {
			

	public LoginTest() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}



	public WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException, MalformedURLException {
		Baseclass bs =new  Baseclass();
		driver = bs.startBrowserForLocal();
		
	}
	
	
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		
		Thread.sleep(5000);
		LoginPage	login = new LoginPage(driver);
		Readpropertyfile	config= new Readpropertyfile();
		login.setusername().sendKeys(config.Appusername());
		login.setpassword().sendKeys(config.AppPassword());
		login.loginbutton().click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}	
	
	

	@Test(priority=2)
	public void confirmTitle() throws InterruptedException {
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		// SoftAssert soft = new SoftAssert();
		Assert.assertEquals(title,"Reports dashboard1");
		/*
		 * try { Assert.assertEquals(title,"Reports dashboard1"); } catch(AssertionError
		 * e) { e.printStackTrace(); }
		 */
		Thread.sleep(6000);
		
	}
	
}
