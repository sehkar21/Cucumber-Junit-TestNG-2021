package Com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver ldriver;
	
	public ContactsPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']")
	@CacheLookup
	WebElement contactLink;	
	
	@FindBy(xpath="//li[@class='expandable active']//div[@class='secondary-nav expansion']//ul//li//div[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactbtn;
	
	@FindBy(xpath="//span[contains(text(),'Create contact')]")
	@CacheLookup
	WebElement createcontact;
	
	@FindBy(xpath="//input[@id='UIFormControl-10']")
	@CacheLookup
	WebElement contactEmail;
	
	@FindBy(xpath="//input[@id='UIFormControl-12']")
	@CacheLookup
	WebElement contactFname;
	
	@FindBy(xpath="//input[@id='UIFormControl-16']")
	@CacheLookup
	WebElement contactLname;
	
	@FindBy(xpath="//input[@id='UIFormControl-24']")
	@CacheLookup
	WebElement contactJobtitle;
	
	@FindBy(xpath="//input[@id='UIFormControl-26']")
	@CacheLookup
	WebElement contactPhonenumber;
	
	@FindBy(xpath="//div[@id='uiabstractdropdown-button-34']//span[@class='uiDropdown__buttonCaret private-dropdown__caret private-dropdown__caret--form']")
	@CacheLookup
	WebElement contactLeadstatusbtn;
	
	@FindBy(xpath="//div[@id='react-select-6--option-7']//span[@class='private-typeahead-result private-typeahead-result--selectable']//span//button[@class='private-typeahead-result-label uiTypeaheadResults__item truncate-text private-button--unstyled']")
	@CacheLookup
	WebElement contactleadstatus;
	
	@FindBy(xpath="//button[@class='uiButton private-button private-button--primary private-button--default private-loading-button private-button--primary private-button--non-link']")
	@CacheLookup
	WebElement createcontactbtn;
	

	@FindBy(tagName="tr")
	@CacheLookup
	List<WebElement> TableRow;
	
	@FindBy(tagName="td")
	@CacheLookup
	List<WebElement>TableData;
	
	
	public WebElement ClickcontactLink() {
		return contactLink;
	}
	
	public WebElement ClickcontactBtn() {
		return contactbtn;
	}
	
	public WebElement Createcontact() {
		return createcontact;
	}
	
	public WebElement contactEmail() {
		return contactEmail;
	}
	
	public WebElement contactFname() {
		return contactFname;
	}
	
	public WebElement contactLname() {
		return contactLname;
	}
	
	public WebElement contactJobtitle() {
		return contactJobtitle;
	}
	
	public WebElement contactPhonenumber() {
		return contactPhonenumber;
	}
	
	public WebElement contactLeadstatusbtn() {
		return contactLeadstatusbtn;
	}
	
	public WebElement contactleadstatus() {
		return contactleadstatus;
	}
	
	public WebElement createcontactbtn() {
		return createcontactbtn;
	}
	
	public List<WebElement> TableRow() {
		return TableRow;
	}
	
	public List<WebElement>  TableData() {
		return TableData;
	}
}
