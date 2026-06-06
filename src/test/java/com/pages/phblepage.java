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

import com.helperclass.baseclass;

public class phblepage extends baseclass {

	
	WebDriver dri;
	WebDriverWait wait;
	
	public phblepage(WebDriver localdriver) {
		
	this.dri=localdriver;
	WebDriverWait wait=new WebDriverWait(dri,Duration.ofSeconds(10));
	PageFactory.initElements(dri, this);
	}
	
	@FindBy(id="Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement header1;
	
	@FindBy(id="ddlRole")
	@CacheLookup
	public WebElement roleselectclick;
		
	@FindBy(id="Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement okbtn;
		
	@FindBy(id = "uctlTaskList_txttext")
	@CacheLookup
	public WebElement numberenter;

	@FindBy(id = "uctlTaskList_btn_Go")
	@CacheLookup
	public WebElement okgo1;

	@FindBy(id="ctlCollectSample_rptSamples_ctl00_ddlStatus")
	@CacheLookup
	public WebElement statuschange;
	
	@FindBy(id="btnFinish")
	@CacheLookup
	public WebElement work;
	
	public void rolechge() throws InterruptedException {
		header1.click();
		Thread.sleep(1000);
		roleselectclick.click();
		
	}
	public void selection(String rol1) throws InterruptedException {
	 WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(roleselectclick));
     Select s=new Select(roleselectclick);
     s.selectByVisibleText(rol1);
     Thread.sleep(1000);
     okbtn.click();
	}
	public void vidselection(String Name) {
		WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(numberenter));
		numberenter.sendKeys(Name);
		okgo1.click();
	}
	
	public void statuschange1(String st1) {
		WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(statuschange));
		Select s=new Select(statuschange);
	     s.selectByVisibleText(st1);

	}
	public void work1() {
		work.click();
	}
	
	
}
