package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.billgenerate;

public class invgn {

	WebDriver dri;
	WebDriverWait wait;
	billgenerate bg = new billgenerate();
	String v1;

	public invgn(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}
	
	
	@FindBy(xpath="//div[@headerindex='1h']")
	@CacheLookup
	public WebElement cmntk;
	
	@FindBy(xpath="//div[@id='hideOPdiv']//ul//li//a[contains(text(),'Home')]")
	@CacheLookup
	public WebElement cltmastrhm;
	
	@FindBy(id="rdoSchedules")
	@CacheLookup
	public WebElement radio;
	
	@FindBy(id="CSchedule_drpCustomerType")
	@CacheLookup
	public WebElement bsty;
	
	@FindBy(xpath="//input[@id='CSchedule_txtClientName']")
	@CacheLookup
	public WebElement ctname;
	
	@FindBy(id="CSchedule_ImgBntCalcFrom")
	@CacheLookup
	public WebElement fda;
	
	@FindBy(id="CSchedule_CalendarExtender1_today")
	@CacheLookup
	public WebElement tdy1;
	
	@FindBy(xpath="//input[@id='CSchedule_ImgBntCalcTo']")
	@CacheLookup
	public WebElement tda;
	
	@FindBy(id="CSchedule_txtTo")
	@CacheLookup
	public WebElement tdy2;
	
	@FindBy(id="CSchedule_btnSearch")
	@CacheLookup
	public WebElement srch;
	
	public void cm() {
//		cmntk.click();
//		cltmastrhm.click();
		radio.click();
		
	}
	public void bt(String bu) {
			Select s2 = new Select(bsty);
//			bustyp.click();
			s2.selectByVisibleText(bu);
	}
	public void c(String nm , String nme) throws InterruptedException {
		Thread.sleep(3000);
		ctname.sendKeys(nm);
		fda.click();
		tdy1.click();
		tda.click();
		tdy2.sendKeys(nme);
		srch.click();		
	}	
}




