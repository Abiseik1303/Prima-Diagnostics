package com.TestProduct.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class RemoteClient extends BaseClass{

	
	WebDriver driver;
	HelperClass helper = new HelperClass();
	Readconfig readconfig=new Readconfig();
	
	public RemoteClient(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	WebElement Masters;
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtName1']")
	@CacheLookup
	WebElement Clientname;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='AutoCompleteExLstGrp11_completionListElem']")
	@CacheLookup
	WebElement ClientnameSuggession;
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	WebElement search;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reset Password')]")
	@CacheLookup
	WebElement Resetpassword;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage User')]")
	@CacheLookup
	WebElement ManageUser;
	
	
	
	
}
