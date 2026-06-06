package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class mngrt {
	
	WebDriver dri;

	public mngrt (WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(xpath="//div[@headerindex='3h']")
	@CacheLookup
	public WebElement master1;
	
	@FindBy(xpath="//div[@id='hidedivRates']//ul//li//a[contains(text(),'Manage Rates')]")
	@CacheLookup
	public WebElement mnge;
	
	@FindBy(id="drpTrustedOrg")
	@CacheLookup
	public WebElement orgname;
	
	@FindBy(id="drpVendorType")
	@CacheLookup
	public WebElement  ratecrd;
	
	@FindBy(id="ddlSubtype")
	@CacheLookup
	public WebElement sub;
	
	@FindBy(id="txtRateCard")
	@CacheLookup
	public WebElement ratename;
	
	@FindBy(id="ddlFeeType")
	@CacheLookup
	public WebElement fee;
	
	@FindBy(id="btnGo")
	@CacheLookup
	public WebElement bgok;
	
	@FindBy(id="txtsearch")
	@CacheLookup
	public WebElement testsrch;
	
	@FindBy(id="btnSearch")
	@CacheLookup
	public WebElement sh;
	
	
	public void mstr() throws InterruptedException {
		master1.click();
		mnge.click();
		Select s=new Select(orgname);
		s.selectByVisibleText("Anderson Diagnostics & Labs");
	}
	public void rte() throws InterruptedException {
		Select s1=new Select(ratecrd);
		s1.selectByVisibleText("Normal");
		Thread.sleep(2000);
	}
	public void sub() throws InterruptedException {
		Select s2=new Select(sub);
		s2.selectByVisibleText("Agreement");
	}
	public void sub2(String nm) throws InterruptedException {
		ratename.sendKeys(nm);
		Thread.sleep(3000);
		ratename.sendKeys(Keys.DOWN);
		ratename.sendKeys(Keys.ENTER);
	}
	public void feet(String f1) throws InterruptedException {
		Select s3=new Select(fee);
		s3.selectByVisibleText(f1);
		Thread.sleep(2000);
		bgok.click();
		Thread.sleep(5000);
	}	
	public void testde(String a) throws InterruptedException {
		testsrch.sendKeys(a);
		Thread.sleep(2000);
		testsrch.sendKeys(Keys.ENTER);
		sh.click();		
	}
}
