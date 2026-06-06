package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clientcreationpage {

	WebDriver dri;
	WebDriverWait wait;
	
	public clientcreationpage(WebDriver localdriver) {
		
	this.dri=localdriver;
	PageFactory.initElements(dri, this);
	WebDriverWait wait= new WebDriverWait(dri, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//div[@headerindex='2h']")
	@CacheLookup
	public WebElement commontask;
	
	@FindBy(xpath="//div[@id='hidedivRates']//ul//li//a[contains(text(),'Client Master')]")
	@CacheLookup
	public WebElement cltmastr;
	
	@FindBy(id="ddlClientType")
	@CacheLookup
	public WebElement clienttype;
	
	@FindBy(id="txtClientName")
	@CacheLookup
	public WebElement cltname;
	
	@FindBy(id="txtClientCode")
	@CacheLookup
	public WebElement cde;
	
	@FindBy(id="drpBusinessType")
	@CacheLookup
	public WebElement bustype;
			
	@FindBy(id="Chkiscash")
	@CacheLookup
	public WebElement cashchk;
	
	
	@FindBy(id="lblNotification")
	@CacheLookup
	public WebElement  notifytab;
	
	@FindBy(id="chkNotification_0")
	@CacheLookup
	public WebElement  bsms;
	
	@FindBy(id="chkNotification_1")
	@CacheLookup
	public WebElement bemail ;
	
	@FindBy(id="chkNotification_2")
	@CacheLookup
	public WebElement  resms;
	
	@FindBy(id="chkNotification_3")
	@CacheLookup
	public WebElement  remail;
	
	
	@FindBy(id="lblShippingInformation")
	@CacheLookup
	public WebElement  ship;
	
	@FindBy(id="drpaddresstype")
	@CacheLookup
	public WebElement addrestype;
	
	@FindBy(id="txtaddres1")
	@CacheLookup
	public WebElement adddetails;
	
	@FindBy(id="txtmobileno")
	@CacheLookup
	public WebElement addmble;
	
	@FindBy(xpath="//input[@onclick='chectisprimary();']")
	@CacheLookup
	public WebElement prim;
	
	@FindBy(id="btnAdd")
	@CacheLookup
	public WebElement add1;
	
	@FindBy(id="lblContactInformtion")
	@CacheLookup
	public WebElement  contact;
	
	@FindBy(id="drplstPerson")
	@CacheLookup
	public WebElement cnttype;
	
	@FindBy(id="txtCntClient")
	@CacheLookup
	public WebElement cntname;
	
	@FindBy(id="txtPrsnMobile")
	@CacheLookup
	public WebElement cntmbl;
	
	@FindBy(id="chkPrsnPrimary")
	@CacheLookup
	public WebElement prim2;
	
	@FindBy(id="btnPrsnAdd")
	@CacheLookup
	public WebElement add2;
	
	@FindBy(id="ddlReason")
	@CacheLookup
	public WebElement rsn;
	
	@FindBy(id="btnFinish")
	@CacheLookup
	public WebElement save;
	
	@FindBy(id="okbtnid")
	@CacheLookup
	public WebElement ok;
	
	@FindBy(id="Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement header2;
	
	@FindBy(id="ddlRole")
	@CacheLookup
	public WebElement roleselectclick2;
		
	@FindBy(id="Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement okbtn2;
	
	public void cd(String cl, String Name, String code) throws Exception {
		commontask.click();
		cltmastr.click();
		Select s1 = new Select(clienttype);
		clienttype.click();
		s1.selectByVisibleText(cl);
		cltname.sendKeys(Name);
		cde.sendKeys(code);
	}
	public void bt(String bu) {
		Select s2 = new Select(bustype);
//		bustyp.click();
		s2.selectByVisibleText(bu);
	}
//	public void cc() {
//		cashchk.click();
//	}
	
	public void noty(String bt,String adt,String mbln) throws InterruptedException {
		notifytab.click();
		bsms.click();
		bemail.click();
		resms.click();
		remail.click();
		ship.click();
		Select s3= new Select(addrestype);
		s3.selectByValue(bt);
		adddetails.sendKeys(adt);
		addmble.sendKeys(mbln);
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)dri;
		js.executeScript("window.scrollBy(0,2000)");
		prim.click();
		Thread.sleep(2000);
		add1.click();
		Thread.sleep(2000);
		contact.click();
	}
	
	public void cntct(String cnt,String adt,String mbln) {
		Select s4=new Select(cnttype);
		s4.selectByVisibleText(cnt);
		cntname.sendKeys(adt);
		cntmbl.sendKeys(mbln);
		prim2.click();
		add2.click();
	}
	
	public void update(String rsnupd) {
		Select s4=new Select(rsn);
		s4.selectByVisibleText(rsnupd);
		save.click();
		ok.click();
	}
	
	public void rolechge() {
		header2.click();
		roleselectclick2.click();
	}
	public void selection(String role1) throws InterruptedException {
	     Select s=new Select(roleselectclick2);
	     s.selectByVisibleText("Lab Reception");
	     WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOf(roleselectclick2));
	     Thread.sleep(3000);
	     okbtn2.click();
}
}

