package com.TestProduct.PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.TestProduct.Utility.BaseClass;

public class SampleCollectionPage extends BaseClass {

	WebDriver driver;

	public SampleCollectionPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//select[@name='ctlCollectSample$rptSamples$ctl00$ddlStatus']")
	@CacheLookup
	WebElement Sample;

	@FindBy(how = How.XPATH, using = "(//select[@title='Select Reason'])[2]")
	@CacheLookup
	WebElement SampleReason;

	@FindBy(how = How.XPATH, using = "//input[@value='Generate Work Order']")
	@CacheLookup
	WebElement Workorder;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnDisableIframSRC']")
	@CacheLookup
	WebElement Closebill;
	
	 @FindBy(xpath = "//input[@name='BtnClosePkgItemDetail']")
	 @CacheLookup
	 WebElement Barcodeclose;
	

	public void Samplestatus(String Status) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", Workorder);
		Sample.sendKeys(Status);
		Sample.click();
	}

	public void Reason(String Reason) {
		SampleReason.sendKeys(Reason);
		SampleReason.click();
		Workorder.click();
	}

	public void billprintclose() {
		Closebill.click();
	}
	public void GenerateWorkorder() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", Workorder);
		Workorder.click();
	}
	
	public void BarcodeClose() {
		Barcodeclose.click();
	}
	

}