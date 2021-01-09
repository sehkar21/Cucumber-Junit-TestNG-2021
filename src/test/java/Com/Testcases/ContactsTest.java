package Com.Testcases;



import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import Com.Pages.ContactsPage;









public class ContactsTest extends LoginTest{
	
	

	public ContactsTest() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=3,enabled=true)
	public void createcontact() throws InterruptedException  {
		
		
		ContactsPage contacts = new ContactsPage(driver);
	
		contacts.ClickcontactLink().click();
		contacts.ClickcontactBtn().click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		contacts.Createcontact().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String email=randomestring()+"@gmail.com";
		contacts.contactEmail().sendKeys(email);
		
		String firstname = randomestring();
		contacts.contactFname().sendKeys(firstname);
		String lastname = randomestring();
		contacts.contactLname().sendKeys(lastname);
		
		contacts.contactJobtitle().sendKeys("Manager");
		
		String number = randomeNum();
		contacts.contactPhonenumber().sendKeys(number);
		
		
		contacts.contactLeadstatusbtn().click();
		contacts.contactLeadstatusbtn().click();
		
		contacts.createcontactbtn().click();
		
		
	}
	

	@Test(priority =6)
	public void Homepagetitle() {
		Assert.assertTrue(false);
	}

	@Test(priority=4,dependsOnMethods = {"createcontact"}, enabled =true)
	public void Webtable() throws InterruptedException {
		
		Thread.sleep(5000);
		ContactsPage contacts = new ContactsPage(driver);
		contacts.ClickcontactLink().click();
		contacts.ClickcontactBtn().click();

		Thread.sleep(7000);
		
		List<WebElement> trow = contacts.TableRow();
		for(int i=0;i<trow.size();i++) {
	
			
			List<WebElement> tdata = contacts.TableData();
			for(int j=0;j<tdata.size();j++) {
				WebElement w1 =tdata.get(j);
				 System.out.println(w1.getText());
			}
			
			
				}
	
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
//	@DataProvider(name="LoginData")
//	String[][] getData() throws IOException
//	{
//		
//		String path = "S:\\New folder\\projectworkplace\\TestNG-Hubspot\\src\\main\\java\\com\\qa\\Testdata\\testngdatadrivenmar2020.xlsx";
//		
//		int rowcount = ExcelUtils.getRowCount(path, "Login");
//		int colcount = ExcelUtils.getCellCount(path, "Login",1);
//		String LoginData[][]=new String[rowcount][colcount];
//		
//		for(int i=1;i<=rowcount;i++) {
//			for(int j=0;j<colcount;j++) {
//				
//				LoginData[i-1][j]= ExcelUtils.getCellData(path, "Login", i,j);
//			}
//		}
//		
//		return LoginData;
//		
//	}
//
//	@Test(priority=5 , dataProvider="LoginData" , enabled=true)
//	public void LoginDataExcel(String email ,String firstname, String lastname, String jobtitle) throws InterruptedException {
//		
//		ContactsPage contacts = new ContactsPage(driver);
//	contacts.ClickcontactLink().click();
//	contacts.ClickcontactBtn().click();
//		Thread.sleep(5000);
//		contacts.Createcontact().click();
//		Thread.sleep(2000);
//		contacts.contactEmail().sendKeys(email);
//		contacts.contactFname().sendKeys(firstname);
//		contacts.contactLname().sendKeys(lastname);
//		contacts.contactJobtitle().sendKeys(jobtitle);
//		
//		contacts.createcontactbtn().click();
//		Thread.sleep(6000);
//		driver.navigate().back();
//		Thread.sleep(3000);
//		driver.navigate().back();
//		Thread.sleep(3000);
//		
//		logger.info("************** Creating the new contacts using Data driven And Data Provider Methods ***************");
//	}
//	
}
