package com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.baseclass;

public class pathologist extends baseclass {

	WebDriver dri;
	WebDriverWait wait;
		

	public pathologist(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(id = "Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement pathhead;

	@FindBy(id = "ddlRole")
	@CacheLookup
	public WebElement pathrole;

	@FindBy(id = "Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement pathok;

	@FindBy(id = "lnkPDFReportPreviewer")
	@CacheLookup
	public WebElement preview;

	@FindBy(id="uctlTaskList_txttext")
	@CacheLookup
	public WebElement tskpick;
	
	@FindBy(id="uctlTaskList_btn_Go")
	@CacheLookup
	public WebElement go3;	
	
	@FindBy(id = "btnSaveToDispatch")
	@CacheLookup
	public WebElement approval;
	
	@FindBy(xpath="//div[@headerindex='0h']")
	@CacheLookup
	public WebElement report;

	@FindBy(xpath = "//div[@id='hideOPdiv']//ul//li//a[contains(text(),'Investigation Report')]")
	@CacheLookup
	public WebElement reportpage;

	@FindBy(id = "txtName")
	@CacheLookup
	public WebElement reportsearch1;

	@FindBy(id = "btnSearch")
	@CacheLookup
	public WebElement reportsearch2;
	
	@FindBy(id = "grdResult_ctl02_Image1")
	@CacheLookup
	public WebElement pdfview;
	
	@FindBy(id = "img2")
	@CacheLookup
	public WebElement pdfclose;
	

	public void pathselect(String rol3,String Name) throws InterruptedException {
		pathhead.click();
		Thread.sleep(1000);
		
		pathrole.click();
		wait=new WebDriverWait(dri, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pathrole));
		Select s1 = new Select(pathrole);
		s1.selectByVisibleText(rol3);
		pathok.click();
		wait.until(ExpectedConditions.visibilityOf(tskpick));
		tskpick.sendKeys(Name);	
		
	    go3.click();
//	    preview.click();
	    wait.until(ExpectedConditions.visibilityOf(approval));
		approval.click();
		Alert alert = dri.switchTo().alert();
    	alert.accept();
		wait.until(ExpectedConditions.visibilityOf(report));
		report.click();
		wait.until(ExpectedConditions.visibilityOf(reportpage));
		reportpage.click();
		wait.until(ExpectedConditions.visibilityOf(reportsearch1));
		reportsearch1.sendKeys(Name);
		reportsearch2.click();
		reportsearch2.click();
		Thread.sleep(15000);
		pdfview.click();
		Thread.sleep(10000);
		pdfclose.click();

	}

}