package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cncl {
	
	
	static WebDriver dri;
	WebDriverWait wait;
	
	public cncl(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(id="Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement hd1;
	
	@FindBy(id="ddlRole")
	@CacheLookup
	public WebElement roleselectclick;
	
	@FindBy(id="Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement okbtn;
	
	@FindBy(xpath = "(//div[@class='dropmenutxt'])[1]")
	@CacheLookup
	public WebElement b1;
	
	@FindBy(xpath="//a[contains(text(),'BillSearch')]")
	@CacheLookup
	public WebElement b2;
	
	@FindBy(id="uctrlBillSearch_txtPatientName")
	@CacheLookup
	public WebElement nam;
	
	@FindBy(id="uctrlBillSearch_btnSearch")
	@CacheLookup
	public WebElement  src;
	
	@FindBy(id="uctrlBillSearch_grdResult_ctl02_rdSel")
	@CacheLookup
	public WebElement  rdo;
	
	@FindBy(id="bGo")
	@CacheLookup
	public WebElement  go;
	
	@FindBy(id="grdRefund_ctl02_chkRefund")
	@CacheLookup
	public WebElement chk;
	
	@FindBy(id="btnRefund")
	@CacheLookup
	public WebElement sbt;
	
	@FindBy(id="okbtnid")
	@CacheLookup
	public WebElement ok;
	
	@FindBy(id="btnCancel")
	@CacheLookup
	public WebElement cls;
	
	@FindBy(xpath="//select[@name='dList']")
	@CacheLookup
	public WebElement Dropdown;
	
	@FindBy(xpath="//option[contains(text(),'Refund to Patient')]")
	@CacheLookup
	public WebElement Refund;
	
	@FindBy(xpath="//input[@name='grdRefund$ctl02$TxtRfdAmt']")
	@CacheLookup
	public WebElement RefundAmount;
	
	@FindBy(xpath="//table[@id='grdRefund']//tr[2]//td[3]")
	@CacheLookup
	public WebElement BillAmount;
	
	
	
	
	
	public void cl(String Name) throws InterruptedException {
		hd1.click();
		roleselectclick.click();
		Select s=new Select(roleselectclick);
		s.selectByVisibleText("Administrator");
		Thread.sleep(3000);
	    okbtn.click();
	   // Thread.sleep(1000);
	    b1.click();
	    b2.click();
	    Thread.sleep(3000);
	    nam.sendKeys(Name);
	    src.click();
	    Thread.sleep(3000);
	    rdo.click();
	    go.click();
	    Thread.sleep(3000);
	    chk.click();
	    sbt.click();
	    Alert alert = dri.switchTo().alert();
    	alert.accept();
    	Thread.sleep(3000);
    	ok.click();
    	Alert alert1 = dri.switchTo().alert();
    	alert1.accept();
    	cls.click();
	}
	public void switchToNewWindow() throws InterruptedException, AWTException {

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
		Thread.sleep(5000);
		dri.switchTo().window(child).close();
		dri.switchTo().window(parent);
		
	}
	
	public void Refund(String Name) throws InterruptedException {
		hd1.click();
		roleselectclick.click();
		Select s=new Select(roleselectclick);
		s.selectByVisibleText("Administrator");
		Thread.sleep(3000);
	    okbtn.click();
	   // Thread.sleep(1000);
	    b1.click();
	    b2.click();
	    Thread.sleep(3000);
	    nam.sendKeys(Name);
	    src.click();
	    Thread.sleep(3000);
	    rdo.click();
	    Thread.sleep(1000);
	    Refund.click();
	    go.click();
	    Thread.sleep(3000);
	    chk.click();
	    RefundAmount.sendKeys("10");
	    Thread.sleep(1000);
	    
	    sbt.click();
	}
	
	public static double HalfAmount() {
		String Amount = dri.findElement(By.xpath("//table[@id='grdRefund']//tr[2]//td[3]")).getText();
	    System.out.println(Amount);
	    String Amt = Amount;
		double number = Double.parseDouble(Amt);
		double num = (number) * 0.5;
		System.out.println(num);
		return num;
		
	}
}
