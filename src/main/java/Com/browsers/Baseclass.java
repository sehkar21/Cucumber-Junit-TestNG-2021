package Com.browsers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import Com.Utils.Readpropertyfile;
import Com.constants.Constants;
import Com.reports.LogStatus;



public class Baseclass {

	public  WebDriver driver=null;
	public DesiredCapabilities capability;
	

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>(); // webdriver for multiple threads

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Baseclass() throws MalformedURLException 
	{
		if(Readpropertyfile.get("RunMode").equalsIgnoreCase("local")) {
			startBrowserForLocal();
		}
		else if(Readpropertyfile.get("RunMode").equalsIgnoreCase("Remote"))
		{
			startBrowserForRemote();
		}
		else {
			try {
				throw new Exception("Please set up the run mode properly in TestRunDetails.properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Readpropertyfile.get("WaitTime")), TimeUnit.SECONDS);
		driver.get(Readpropertyfile.get("url"));
		driver.manage().deleteAllCookies();
	}
	
	public WebDriver startBrowserForLocal() {
		String browser=Readpropertyfile.get("Browser");
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				//WebDriverManager.chromedriver().setup();  //WebDriverManager some time wont work because of proxy issues
				System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) 
			{
				//WebDriverManager.firefoxdriver().setup(); //WebDriverManager some time wont work because of proxy issues
				System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVERPATH);
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
				driver= new FirefoxDriver();
			}
		}
		catch (Exception e) {
			LogStatus.fail(e);
		}
		return getDriver();
	}
	
	private void startBrowserForRemote() throws MalformedURLException {
		String browser=Readpropertyfile.get("Browser");
		switch(browser){

		case "chrome":
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			driver=new RemoteWebDriver(new URL(Readpropertyfile.get("RemoteURL")),capability);
			break;
		case "firefox":
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			driver=new RemoteWebDriver(new URL(Readpropertyfile.get("RemoteURL")),capability);
			break;
		default:
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			driver=new RemoteWebDriver(new URL(Readpropertyfile.get("RemoteURL")),capability);
			break;
		}
	}
	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	

	
}
