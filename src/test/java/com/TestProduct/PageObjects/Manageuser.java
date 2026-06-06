package com.TestProduct.PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.ScreenshotUtils;


public class Manageuser extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;

	public Manageuser(WebDriver Idriver) {
		this.driver = Idriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Masters')]")
	@CacheLookup
	public WebElement Masters;

	@FindBy(xpath = "//li[contains(text(),'Manage User')]")
	@CacheLookup
	public WebElement ManageUser;

	@FindBy(xpath = "//span[contains(text(),'Create \\ Edit User')]")
	@CacheLookup
	public WebElement HideIcon;

	@FindBy(xpath = "//select[@name='ddSalutation']")
	@CacheLookup
	public WebElement Salutation;

	@FindBy(xpath = "//option[contains(text(),'Master.')]")
	@CacheLookup
	public WebElement SelectSalutation;
	
	@FindBy(xpath ="//input[@name='txtEmployeeID']")
	@CacheLookup
	public WebElement EmpID;

	@FindBy(xpath = "//input[@name='txtName']")
	@CacheLookup
	public WebElement Username;

	@FindBy(xpath = "//input[@name='txtEmail']")
	@CacheLookup
	public WebElement email;

	@FindBy(xpath = "//input[@name='ImgBntCalc']")
	@CacheLookup
	public WebElement Calenderimage;

	@FindBy(xpath = "//div[@id='CalendarExtender1_today']")
	@CacheLookup
	public WebElement Selectcalender;

	@FindBy(xpath = "//textarea[@name='ucPAdd$txtAddress2']")
	@CacheLookup
	public WebElement Address1;

	@FindBy(xpath = "//input[@name='ucPAdd$txtCity']")
	@CacheLookup
	public WebElement City;

	@FindBy(xpath = "//input[@name='ucPAdd$txtMobile']")
	@CacheLookup
	public WebElement MobileNumber;

	@FindBy(xpath = "//label[contains(text(),'Administrator')]")
	@CacheLookup
	public WebElement SelectAdmin;

	@FindBy(xpath = "//input[@value='Save']")
	@CacheLookup
	public WebElement Save;

	@FindBy(xpath = "//input[@value='online']")
	@CacheLookup
	public WebElement radio;

	@FindBy(xpath = "//input[@name='txtName1']")
	@CacheLookup
	public WebElement clientname;

	@FindBy(xpath = "//input[@value='Search']")
	@CacheLookup
	public WebElement search;

	@FindBy(xpath = "//a[contains(text(),'Reset Password')]")
	@CacheLookup
	public WebElement resetbutton;

	@FindBy(name = "txtUserName")
	@CacheLookup
	public WebElement logUsername;

	@FindBy(name = "txtPassword")
	@CacheLookup
	public WebElement logPassword;

	@FindBy(xpath = "//input[@value='Login']")
	@CacheLookup
	public WebElement loginbutton;

	@FindBy(xpath = "//a[@id='Attuneheader_lnkLogOut']")
	@CacheLookup
	public WebElement LogOut;

	@FindBy(xpath = "//input[@name='txtOldpassword']")
	@CacheLookup
	public WebElement OldPassword;

	@FindBy(xpath = "//input[@name='txtNewpassword']")
	@CacheLookup
	public WebElement Newpassword;

	@FindBy(xpath = "//input[@name='txtConfirmpassword']")
	@CacheLookup
	public WebElement ConformPassword;

	@FindBy(xpath = "//input[@value='Update']")
	@CacheLookup
	public WebElement update;

	@FindBy(xpath = "//input[@value='Ok']")
	@CacheLookup
	public WebElement Ok;
	
	@FindBy(xpath = "//span[@id='Attuneheader_UserHeader1_lblRolename']")
	@CacheLookup
	public WebElement Role;
	

	public void newuser(String a, String b, String c, String d, String e, String f) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Masters)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ManageUser)).click();
		
		scrollAndClick(SelectAdmin);
		
		wait.until(ExpectedConditions.elementToBeClickable(Salutation)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SelectSalutation)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Username)).sendKeys(b);
		wait.until(ExpectedConditions.elementToBeClickable(EmpID)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(c);
		
		scrollAndSendKeys(Address1, d);
		
		wait.until(ExpectedConditions.elementToBeClickable(City)).sendKeys(e);
		wait.until(ExpectedConditions.elementToBeClickable(MobileNumber)).sendKeys(f);
		
		scrollAndClick(Save);
		screenshot.capturePageLoad(driver);

	}

	public void existinguser(String a) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(clientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
	}

	public void passwordcapture() {

	}

	public void logout() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(Role)).click();
		
//Sleep		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(LogOut)).click();
		driver.switchTo().alert().accept();
	}

	public void newuserlogin(String a, String b) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(logUsername)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(logPassword)).sendKeys(b);
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
		screenshot.capturePageLoad(driver);
	}

	public void passwordReset(String a, String b, String c) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(OldPassword)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Newpassword)).sendKeys(b);
		wait.until(ExpectedConditions.elementToBeClickable(ConformPassword)).sendKeys(c);
		wait.until(ExpectedConditions.elementToBeClickable(update)).click();
		screenshot.capturePageLoad(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Ok)).click();
	}

}
