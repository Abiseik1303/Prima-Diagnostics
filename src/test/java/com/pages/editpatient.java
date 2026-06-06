package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.billgenerate;

public class editpatient {
	WebDriver dri;
	WebDriverWait wait;
	billgenerate bg = new billgenerate();
	String v1;

	public editpatient(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}
	
	@FindBy(xpath = "//div[@headerindex='0h']")
	@CacheLookup
	public WebElement menu;

	@FindBy(xpath = "//div[@id='hideOPdiv']//ul//li//a[contains(text(),'Visit Search')]")
	@CacheLookup
	public WebElement visitsrch;

	@FindBy(id="txtPname")
	@CacheLookup
	public WebElement ptsrch;
	
	@FindBy(id="btnSearch")
	@CacheLookup
	public WebElement btsr;
	
	@FindBy(id="grdResult_ctl02_rdSel")
	@CacheLookup
	public WebElement rdt2;
	
	@FindBy(id="ddlVisitActionName")
	@CacheLookup
	public WebElement edslt;
	
	@FindBy(id="btnGo")
	@CacheLookup
	public WebElement go;
	
	@FindBy(id="btnGenerate")
	@CacheLookup
	public WebElement bsrch;
	
	@FindBy(id = "txtName")
	@CacheLookup
	public WebElement name;

	@FindBy(id = "txtDOBNos")
	@CacheLookup
	public WebElement age;
	
	@FindBy(xpath="(//input[@value='Update'])[1]")
	@CacheLookup
	public WebElement ok;
	
	@FindBy(id="btnBack")
	@CacheLookup
	public WebElement back;
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	@CacheLookup
	public WebElement ClickOK;
	
	
	
	public void visit(String na,String ag, String n1,String a2) throws InterruptedException {
		menu.click();
		visitsrch.click();
		ptsrch.sendKeys(na);
		btsr.click();
		Thread.sleep(2000);
		rdt2.click();
		Select select = new Select(edslt);
		select.selectByVisibleText("Edit Patient Registration Details");
		go.click();
		Thread.sleep(2000);
		name.clear();
		Thread.sleep(1000);
		name.sendKeys(n1);
		Thread.sleep(1000);
		age.clear();
		age.sendKeys(a2);
		Thread.sleep(3000);
		ok.click();
		Thread.sleep(2000);
		dri.switchTo().alert().accept();
		Thread.sleep(2000);
		ClickOK.click();
		back.click();
	
	}

	
}
