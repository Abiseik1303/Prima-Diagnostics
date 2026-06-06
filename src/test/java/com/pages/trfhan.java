package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.baseclass;

public class trfhan extends baseclass {

	WebDriver dri;
	WebDriverWait wait;
	
	public trfhan(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	
	@FindBy(xpath="//input[@id='ChkTRFImage']")
	@CacheLookup
	public WebElement trfclick;
	
	@FindBy(xpath="//input[@type='file']")
	@CacheLookup
	public WebElement chfl;
	
	@FindBy(xpath = "//div[@headerindex='0h']")
	@CacheLookup
	public WebElement menu;

	@FindBy(xpath = "//div[@id='hideOPdiv']//ul//li//a[contains(text(),'Visit Search')]")
	@CacheLookup
	public WebElement visit1;
	
	@FindBy(id="txtPname")
	@CacheLookup
	public WebElement name1;
	
	@FindBy(id="btnSearch")
	@CacheLookup
	public WebElement srch;
	
	@FindBy(id="grdResult_ctl02_rdSel")
	@CacheLookup
	public WebElement rdoclk;
	
	@FindBy(id="grdResult_ctl02_lnklabno")
	@CacheLookup
	public WebElement vid;
	
//	public void tf() throws InterruptedException {
//		trfclick.click();
//		Thread.sleep(5000);
//		chfl.sendKeys("C:\\Users\\Mahalingam\\Downloads\\Automation.pdf"); 
////		Thread.sleep(5000);
//		trfclick.click();
//
//	}
//	
	public void trf() throws InterruptedException {
		trfclick.click();
		Thread.sleep(5000);
		chfl.sendKeys("C:\\Users\\Abiseik C\\OneDrive\\Pictures\\OIP (1).jpg");
		trfclick.click();
	}
	public void vs(String nme) {
		menu.click();
		visit1.click();
		name1.sendKeys(nme);
		srch.click();
		rdoclk.click();
		vid.click();
	}
}






