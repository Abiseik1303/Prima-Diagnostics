package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.baseclass;
import com.helperclass.billgenerate;

public class Billpage extends baseclass {

	WebDriver dri;
	WebDriverWait wait;
	billgenerate bg = new billgenerate();
	String v1;
	

	public Billpage(WebDriver localdriver) {
		this.dri = localdriver;
	
		PageFactory.initElements(dri, this);
	}

	@FindBy(xpath = "//div[@headerindex='0h']")
	@CacheLookup
	public WebElement menu;

	@FindBy(xpath = "//div[@id='hideOPdiv']//ul//li//a[contains(text(),'Lab Quick Billing')]")
	@CacheLookup
	public WebElement labquick1;

	@FindBy(id = "ddSalutation")
	@CacheLookup
	public WebElement sal1;

	@FindBy(id = "txtName")
	@CacheLookup
	public WebElement name;

	@FindBy(id = "txtDOBNos")
	@CacheLookup
	public WebElement age;

	@FindBy(id = "txtMobileNumber")
	@CacheLookup
	public WebElement mble;
	
	@FindBy(id="ChkTRFImage")
	@CacheLookup
	public WebElement trfclick;
	
	@FindBy(id="FileUpload1")
	@CacheLookup
	public WebElement choose;

	@FindBy(id = "billPart_txtTestName")
	@CacheLookup
	public WebElement Test;

	@FindBy(id = "billPart_btnAdd")
	@CacheLookup
	public WebElement add;

	@FindBy(id = "btnGenerate")
	@CacheLookup
	public WebElement generatebill;

	@FindBy(id = "advBillPrint_lblVisitNumber")
	@CacheLookup
	public WebElement visitnumber;
	
	@FindBy(id = "Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement header1;

	@FindBy(id = "ddlRole")
	@CacheLookup
	public WebElement roleselectclick;

	@FindBy(id = "Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement okbtn;
	
	@FindBy(id = "txtClient")
	@CacheLookup
	public WebElement clnname;
	
	 @FindBy(xpath = "//input[@name='BtnClosePkgItemDetail']")
	 @CacheLookup
	 public WebElement Barcodeclose;
	 
	 @FindBy(xpath = "//input[@name='btnDisableIframSRC']")
	 @CacheLookup
	 public WebElement Backbutton;
	
	public void labquick() {
		menu.click();
		labquick1.click();
	}

	public void salution(String salu) {
		sal1.click();
		Select select = new Select(sal1);
		select.selectByVisibleText(salu);
	}

	public void Patientname(String Name, String age1, String mn) throws InterruptedException, AWTException {
		name.sendKeys(Name);
		age.sendKeys(age1);
		mble.sendKeys(mn);
	//	trfclick.click();
	
	}

	public void addtest(String testname) throws InterruptedException {
		Test.sendKeys(testname);
		Thread.sleep(1000);
		Test.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		Test.sendKeys(Keys.ENTER);
		add.click();
	}

	public void generatebill() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(generatebill));
		generatebill.click();
		Thread.sleep(3000);
		Backbutton.click();
	}

	public void switchToNewWindow() throws Exception {

		Set<String> windowhandles = dri.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		String parent = it.next();
		String child = it.next();

		dri.switchTo().window(child);
		Thread.sleep(1000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visitnumber));
		v1 = visitnumber.getText();
		System.out.println("Visitnumberis =" +v1);
		dri.switchTo().window(child).close();
		dri.switchTo().window(parent);
	}
	public String visitnum() {
		return v1;
	}

	public void clt(String ccde) throws InterruptedException, AWTException {
		clnname.sendKeys(ccde);	
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void CloseBarcode() {
		Barcodeclose.click();
	}
}
