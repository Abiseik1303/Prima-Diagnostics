package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.baseclass;

public class grpcre extends baseclass {

	WebDriver dri;

	public grpcre(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Masters')]")
	@CacheLookup
	public WebElement masterclick1;

	@FindBy(xpath = "//div[@id='hidedivRates']//ul//li//a[contains(text(),'Add Investigation/Groups')]")
	@CacheLookup
	public WebElement masterclick2;

	@FindBy(id = "btnOk")
	@CacheLookup
	public WebElement gok;

	@FindBy(id = "grouptab_Createtab_txtpackage")
	@CacheLookup
	public WebElement gpnam;

	@FindBy(id = "grouptab_Createtab_grdInvCodingScheme_ctl02_txtCodingSchemeNameMaster")
	@CacheLookup
	public WebElement gcd;

	@FindBy(id = "grouptab_Createtab_Add")
	@CacheLookup
	public WebElement gadd;

	@FindBy(id = "okbtnid")
	@CacheLookup
	public WebElement gok2;

	@FindBy(id = "__tab_grouptab_addgrouptab")
	@CacheLookup
	public WebElement addgro;

	@FindBy(id = "grouptab_addgrouptab_txt_searchmap")
	@CacheLookup
	public WebElement gpnsrch;

	@FindBy(id = "grouptab_addgrouptab_btnmapsearch")
	@CacheLookup
	public WebElement gpsrch;

	@FindBy(xpath = "//input[@onclick='show(name);']")
	@CacheLookup
	public WebElement showicon;

	@FindBy(id = "grouptab_addgrouptab_ManageInvestigation_rdoInvestigation")
	@CacheLookup
	public WebElement invclk;


	@FindBy(xpath = "//input[@id='grouptab_addgrouptab_ManageInvestigation_txt_search']")
	@CacheLookup
	public WebElement invsrch1,invsrch2,invsrch3,invsrch4,invsrch5;
	
	By invsrch=By.xpath("//input[@id='grouptab_addgrouptab_ManageInvestigation_txt_search']");
	
	@FindBy(id = "grouptab_addgrouptab_ManageInvestigation_btnmassearch")
	@CacheLookup
	public WebElement srchicon,srchicon1,srchicon2,srchicon3,srchicon4;	

	@FindBy(id = "grouptab_addgrouptab_ManageInvestigation_chklstGrp_0")
	@CacheLookup
	public WebElement checkbox,checkbox1,checkbox2,checkbox3,checkbox4;

	@FindBy(id = "grouptab_addgrouptab_ManageInvestigation_btnInvAdd")
	@CacheLookup
	public WebElement addbtn,addbtn1,addbtn2,addbtn3,addbtn4;

	@FindBy(id = "grouptab_addgrouptab_ManageInvestigation_rdoGroup")
	@CacheLookup
	public WebElement groupclick;

	@FindBy(id = "grouptab_addgrouptab_OKButton")
	@CacheLookup
	public WebElement close;

	public void mas(String Name, String gcde) throws InterruptedException {
		masterclick1.click();
		masterclick2.click();
		gok.click();
		gpnam.sendKeys(Name);
		System.out.println(Name);
		gcd.sendKeys(gcde);
		System.out.println(gcde);
		gadd.click();
		Thread.sleep(3000);
		gok2.click();
		Thread.sleep(3000);
		addgro.click();
		Thread.sleep(3000);
		gpnsrch.sendKeys(gcde);
		
		Thread.sleep(3000);
		gpsrch.click();
		Thread.sleep(2000);
		showicon.click();
	}

	public void addinc1(String CT1) throws Exception {
		Thread.sleep(3000);
		invclk.click();
		Thread.sleep(3000);
		invsrch1.sendKeys(CT1);
		Thread.sleep(3000);
		srchicon.click();
		Thread.sleep(3000);
		checkbox.click();
		addbtn.click();
		Thread.sleep(2000);
		dri.switchTo().alert().accept();
	}
		
		public void addinc2(String CT2) throws InterruptedException {
		Thread.sleep(3000);
		invsrch2.sendKeys(CT2);
		Thread.sleep(3000);
		srchicon1.click();
		Thread.sleep(3000);
		checkbox1.click();
		Thread.sleep(3000);
		addbtn1.click();
		Thread.sleep(2000);
		dri.switchTo().alert().accept();
		}

		public void addinc3(String CT3) throws InterruptedException {
		Thread.sleep(3000);
		invsrch3.sendKeys(CT3);
		Thread.sleep(3000);
		srchicon2.click();
		Thread.sleep(3000);
		checkbox2.click();
		Thread.sleep(3000);
		addbtn2.click();
		Thread.sleep(2000);
		dri.switchTo().alert().accept();
	}

	public void addgcp(String gc1) throws Exception {
		groupclick.click();
		Thread.sleep(3000);
		invsrch4.sendKeys(gc1);
		Thread.sleep(3000);
		srchicon3.click();
		Thread.sleep(3000);
		checkbox3.click();
		Thread.sleep(3000);
		addbtn3.click();
		Thread.sleep(2000);
		dri.switchTo().alert().accept();
	}
	
	public void addgcp2(String gc2) throws Exception {
		Thread.sleep(5000);
		invsrch5.clear();
		invsrch5.sendKeys(gc2);
		Thread.sleep(3000);
		srchicon4.click();
		Thread.sleep(3000);
		checkbox4.click();
		Thread.sleep(3000);
		addbtn4.click();
		Thread.sleep(2000);
		dri.switchTo().alert().accept();
		Thread.sleep(3000);
		close.click();
		
		Thread.sleep(2000);
	}
	
	//input[@value='Close']

	}

