package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helperclass.baseclass;

public class pkgg extends baseclass {

	WebDriver dri;
	
	public pkgg(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Masters')]")
	@CacheLookup
	public WebElement masterclick1;

	@FindBy(xpath = "//a[contains(text(),'ManagePackage')]")
	@CacheLookup
	public WebElement masterclick2;
	
	@FindBy(id="txtpackagename")
	@CacheLookup
	public WebElement packname;
	
	@FindBy(id="txtBillingName")
	@CacheLookup
	public WebElement billname;
	
	@FindBy(id="grdInvCodingScheme_ctl02_txtCodingSchemeNameMaster")
	@CacheLookup
	public WebElement packcode;
	
	@FindBy(id="btnsave")
	@CacheLookup
	public WebElement addbtn;
	
	@FindBy(id="okbtnid")
	@CacheLookup
	public WebElement ok;
	
	@FindBy(id="txtsearchpkg")
	@CacheLookup
	public WebElement pksrch1;
	
	@FindBy(id="btnsearch")
	@CacheLookup
	public WebElement pksrch2;
	
	@FindBy(id="grdpackages_ctl02_lnkshow")
	@CacheLookup
	public WebElement shoicon;
	
	@FindBy(xpath="//u[normalize-space()='Add More..']")
	@CacheLookup
	public WebElement addmore;
	
	@FindBy(id="txtBX")
	@CacheLookup
	public WebElement testbox1;
	
	@FindBy(xpath="//option[@value='40216']")
	@CacheLookup
	public WebElement Test1;
	
	@FindBy(xpath="//option[@value='40260']")
	@CacheLookup
	public WebElement Test2;
	
	@FindBy(xpath="//select[@id='InvestigationControl1_listGRP']")
	@CacheLookup
	public WebElement grptable;
	
	@FindBy(xpath="//option[@value='10965']")
	@CacheLookup
	public WebElement Test3;
	
	@FindBy(xpath="//a[@id='hypLnkFinish']")
	@CacheLookup
	public WebElement actp;
	
	@FindBy(xpath="//input[@id='btnFinish']")
	@CacheLookup
	public WebElement save;
	
	public void maste(String nm , String n,String p) throws InterruptedException {
		masterclick1.click();
		masterclick2.click();
		packname.sendKeys(nm);
		billname.sendKeys(n);
		packcode.sendKeys(p);
		addbtn.click();
		Thread.sleep(3000);
		ok.click();
		Thread.sleep(3000);
	}
	public void srch(String p , String gc1 , String gc2 ,String gc3) throws InterruptedException {
	    Actions act = new Actions(dri);
		pksrch1.sendKeys(p);
		pksrch2.click();
		Thread.sleep(3000);
		shoicon.click();
		Thread.sleep(2000);
		addmore.click();
		Thread.sleep(2000);
		testbox1.sendKeys(gc1);
		Thread.sleep(2000);
		act.doubleClick(Test1).perform();
		Thread.sleep(1000);
		testbox1.sendKeys(gc2);
		Thread.sleep(2000);
		act.doubleClick(Test2).perform();
		Thread.sleep(1000);
		grptable.click();
		testbox1.sendKeys(gc3);
		Thread.sleep(2000);
		act.doubleClick(Test3).perform();
		Thread.sleep(1000);
		actp.click();
		Thread.sleep(3000);
		save.click();
		Thread.sleep(2000);
	}
}

