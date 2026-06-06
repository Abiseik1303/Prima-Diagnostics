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

public class smpletsfr extends baseclass {

	WebDriver dri;

	public smpletsfr(WebDriver localdriver) {
		this.dri = localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(id = "Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement head1,head2,head3;

	@FindBy(id = "ddlRole")
	@CacheLookup
	public WebElement roleselectclick,roleselectclick1;

	@FindBy(id = "ddlOrgHeaderLocation")
	@CacheLookup
	public WebElement locationselect;

	@FindBy(id = "Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement okbtn1,okbtn2;

	@FindBy(xpath = "//div[@headerindex='0h']")
	@CacheLookup
	
	public WebElement menu1,menu2;

	@FindBy(xpath = "//div[@id='hideOPdiv']//ul//li//a[contains(text(),'Sample Transfer')]")
	@CacheLookup
	public WebElement st1;
	
	@FindBy(xpath ="//div[@id='hideOPdiv']//ul//li//a[contains(text(),'ReceiveSample')]")
	@CacheLookup
	public WebElement rc1;

	@FindBy(id = "txtPatientName")
	@CacheLookup
	public WebElement pnm;

	@FindBy(id = "btnGo")
	@CacheLookup
	public WebElement bgo;

	@FindBy(id = "grdSample_ctl01_chkHeader")
	@CacheLookup
	public WebElement chk;

	@FindBy(xpath = "//select[@id='ddltransferloc']")
	@CacheLookup
	public WebElement tf;

	@FindBy(id = "btnOK")
	@CacheLookup
	public WebElement bgo2;

	@FindBy(id = "ddltransferloc")
	@CacheLookup
	public WebElement tfc;

	@FindBy(id = "okbtnid")
	@CacheLookup
	public WebElement btn2;
	
	@FindBy(id ="txtPatientName")
	@CacheLookup
	public WebElement pmne;
	
	@FindBy(id ="btnFinish")
	@CacheLookup
	public WebElement sc;
	
	@FindBy(id ="btnSubmit")
	@CacheLookup
	public WebElement save;

	public void acc() throws InterruptedException {
		head1.click();
		Thread.sleep(1000);
		roleselectclick.click();
	}

	public void sel(String n) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(dri, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(roleselectclick));
		Select s = new Select(roleselectclick);
		s.selectByVisibleText("Accession");
		Thread.sleep(1000);
		okbtn1.click();
		Thread.sleep(1000);
		menu1.click();
		st1.click();
		Thread.sleep(1000);
		pnm.sendKeys(n);
		bgo.click();
		Thread.sleep(2000);
		chk.click();
	}

	public void tflc() throws InterruptedException {
		tfc.click();
		Thread.sleep(2000);
		tf.click();
		Select s = new Select(tf);
		s.selectByVisibleText("Anderson Diagnostics & Labs(St.Antony Hospital)");
		Thread.sleep(1000);
		bgo2.click();
		Thread.sleep(1000);
		btn2.click();
		Thread.sleep(3000);
	}

	public void rclv(String e) throws InterruptedException {
		head2.click();
		Thread.sleep(1000);
		locationselect.click();
		Select s = new Select(locationselect);
		s.selectByVisibleText("St.Antony Hospital");
		Thread.sleep(1000);
		okbtn2.click();
		Thread.sleep(1000);
		menu2.click();
		rc1.click();
		pmne.sendKeys(e);
		sc.click();
		Thread.sleep(3000);
		save.click();
		Thread.sleep(3000);
		head3.click();
		Thread.sleep(1000);
	}
		
	public void tech () throws InterruptedException {
		Select s1= new Select(roleselectclick1);
		s1.selectByVisibleText("Lab Technician");
		Thread.sleep(2000);
		okbtn2.click();
	}
}