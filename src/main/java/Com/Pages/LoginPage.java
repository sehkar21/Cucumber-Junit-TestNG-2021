package Com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
		WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@id='loginBtn']")
	@CacheLookup
	WebElement loginbtn;
	
	
	public WebElement setusername() {
		return username;
	}
	
	
	public WebElement setpassword() {
		return password;
	}
	
	
	public WebElement loginbutton() {
		return loginbtn;
	}
	
	
	
	
	
}
