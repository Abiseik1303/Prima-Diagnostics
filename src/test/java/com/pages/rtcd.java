package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.helperclass.baseclass;

public class rtcd extends baseclass {

	WebDriver dri;

	public rtcd(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(xpath = "//div[@headerindex='2h']")
	@CacheLookup
	public WebElement master1;

	@FindBy(xpath = "//div[@id='hidedivRates']//ul//li//a[contains(text(),'Rate Mapping')]")
	@CacheLookup
	public WebElement master2;

	@FindBy(id = "ddlClientType")
	@CacheLookup
	public WebElement clttyp;

	@FindBy(id = "txtClientName")
	@CacheLookup
	public WebElement cltname;

	@FindBy(id = "ddlratetype")
	@CacheLookup
	public WebElement ratetype;

	@FindBy(id = "txtRateCard")
	@CacheLookup
	public WebElement ratecard;

	@FindBy(xpath = "//input[@id='ChkBaserate']")
	@CacheLookup
	public WebElement base;

	@FindBy(id = "txtValidFrom")
	@CacheLookup
	public WebElement from;

	@FindBy(id = "CalendarExtender2_today")
	@CacheLookup
	public WebElement fromdate;

	@FindBy(id = "txtValidTo")
	@CacheLookup
	public WebElement to;

	@FindBy(id = "CalendarExtender1_nextArrow")
	@CacheLookup
	public WebElement todatearrow;

	@FindBy(id = "CalendarExtender1_day_4_6")
	@CacheLookup
	public WebElement rndmdateselect;

	@FindBy(id = "ddlReason")
	@CacheLookup
	public WebElement reasonn;

	@FindBy(id = "btnAdd")
	@CacheLookup
	public WebElement save;

	public void rone(String but, String Name) throws InterruptedException {
		master1.click();
		master2.click();
		Thread.sleep(3000);
		Select s1 = new Select(clttyp);
		s1.selectByVisibleText(but);
		Thread.sleep(3000);
		cltname.sendKeys(Name);
		Thread.sleep(3000);
		cltname.sendKeys(Keys.DOWN);
		Thread.sleep(5000);
		cltname.sendKeys(Keys.ENTER);
		Select s2 = new Select(ratetype);
		s2.selectByVisibleText("Normal");
		Thread.sleep(3000);
		ratecard.sendKeys("General");
		Thread.sleep(3000);
		ratecard.sendKeys(Keys.ENTER);
		base.click();
		Thread.sleep(2000);
		from.click();
		Thread.sleep(2000);
		fromdate.click();
		Thread.sleep(2000);
		to.click();
		Thread.sleep(2000);
		todatearrow.click();
		todatearrow.click();
		todatearrow.click();
		Thread.sleep(2000);
		rndmdateselect.click();
		Thread.sleep(2000);
		Select s3 = new Select(reasonn);
		s3.selectByVisibleText("ClientRatemaster Updation");
		Thread.sleep(2000);
		save.click();
		Thread.sleep(5000);

	}
}
