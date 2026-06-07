package com.TestProduct.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.TestProduct.Utility.BaseClass;

public class AccessionPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public AccessionPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "uctlTaskList_txttext")
	@CacheLookup
	WebElement Name;

	@FindBy(name = "uctlTaskList$btn_Go")
	@CacheLookup
	WebElement go;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	public WebElement CommonSearch, commonsearch;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'ReceiveSample')]")
	@CacheLookup
	public WebElement ReceiveSample;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Sample Search')]")
	@CacheLookup
	WebElement Samplesearch, samplesearch;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Sample Transfer')]")
	@CacheLookup
	public WebElement SampleTransfer;

	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientName']")
	@CacheLookup
	public WebElement patientname;

	@FindBy(how = How.XPATH, using = "//input[@name='btnFinish']")
	@CacheLookup
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	public WebElement SearchTrans;

	@FindBy(how = How.XPATH, using = "//input[@name='btnSubmit']")
	@CacheLookup
	public WebElement Save;

	@FindBy(how = How.ID, using = "btnFinish")
	@CacheLookup
	WebElement Gworkorder;

	@FindBy(xpath = "//input[@name='BtnClosePkgItemDetail']")
	@CacheLookup
	WebElement Barcodeclose;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	@CacheLookup
	WebElement Checkbox;

	@FindBy(xpath = "//select[@name='ddltransferloc']")
	@CacheLookup
	WebElement locationTransfer;

	@FindBy(xpath = "//input[@value='Transfer Sample']")
	@CacheLookup
	WebElement TransferSample;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	@CacheLookup
	WebElement Okpopup;

	@FindBy(how = How.ID_OR_NAME, using = "txtPatientName")
	@CacheLookup
	WebElement PatientName, patientname1;

	@FindBy(how = How.XPATH, using = "//input[@id='chkAberrant']")
	@CacheLookup
	WebElement CheckBox, checkbox;

	@FindBy(how = How.XPATH, using = "//select[@name='ddlSampleStatus']")
	@CacheLookup
	WebElement SampleStatus, samplestatus;

	@FindBy(how = How.XPATH, using = "//input[@onclick='return ValidateSearch();']")
	@CacheLookup
	WebElement Search2, Search1;

	@FindBy(how = How.XPATH, using = "//input[@name='grdSample$ctl01$ChkbxHeaderSelect']")
	@CacheLookup
	WebElement Commonbox, Commonbox1;

	@FindBy(how = How.NAME, using = "ddlAction")
	@CacheLookup
	WebElement ActionDropdown, ActionDropdown1;

	@FindBy(how = How.XPATH, using = "//input[@id='btnOK']")
	@CacheLookup
	WebElement okbtn, okbtn1;

	@FindBy(how = How.XPATH, using = "//input[@onclick='javascript:ValidateRdoBtns123();']")
	@CacheLookup
	WebElement receivebtn;

	@FindBy(how = How.XPATH, using = "//textarea[@name='txtCourierDetails']")
	@CacheLookup
	WebElement comments, comments1;

	@FindBy(how = How.XPATH, using = "//input[@name='btnSaveOutsource']")
	@CacheLookup
	WebElement savebtn, savebtn1;

	@FindBy(how = How.XPATH, using = "//button[@id='okbtnid']")
	@CacheLookup
	WebElement alertok, alertok1;

	@FindBy(how = How.XPATH, using = "(//input[@id='grdOutSourcedDetailsTest_ctl02_ChkbxSelectAccessionNumber'])[1]")
	@CacheLookup
	WebElement receiveCheckBox;

//	@FindBy(how = How.XPATH, using = "")
//	@CacheLookup
//	WebElement ;

	/*
	 * @FindBy(xpath = "")
	 * 
	 * @CacheLookup WebElement ;
	 */

	public void samplesearch() {
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Samplesearch)).click();
	}

	public void receicesample(String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ReceiveSample)).click();
		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();

		scrollAndClick(Save);

//Sleep		

//		Thread.sleep(2000);	
//		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
//		Thread.sleep(2000);	
	}

	public void receicesamplewhitefield(String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ReceiveSample)).click();
		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();

		scrollAndClick(Save);
	}

	public void transfer(String a, String b) throws InterruptedException, AWTException {

		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SampleTransfer)).click();
		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(SearchTrans)).click();

		Thread.sleep(2000);
		scrollAndClick(Checkbox);

		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(locationTransfer)));
		s.selectByVisibleText(b);

		scrollAndClick(TransferSample);
//		wait.until(ExpectedConditions.elementToBeClickable(TransferSample)).click();

		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}

	public void OutsourceFlow(String Status, String value1, String name) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Samplesearch)).click();

		wait.until(ExpectedConditions.elementToBeClickable(PatientName)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(CheckBox)).click();

		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(SampleStatus)));
		s.selectByVisibleText(Status);

		wait.until(ExpectedConditions.elementToBeClickable(Search1)).click();
		scrollAndClick(Commonbox);

		Select s2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(ActionDropdown)));
		s2.selectByVisibleText(value1);

		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(comments))
				.sendKeys("Sending the sample to the outsource location");
		wait.until(ExpectedConditions.elementToBeClickable(savebtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(alertok)).click();

	}

	public void receiveOutsource(String Status, String name, String value2) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(commonsearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(samplesearch)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(patientname1)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(samplestatus)));
		s.selectByVisibleText(Status);
		wait.until(ExpectedConditions.elementToBeClickable(receivebtn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Search2)).click();
		scrollAndClick(Commonbox1);

		Select s3 = new Select(wait.until(ExpectedConditions.elementToBeClickable(ActionDropdown1)));
		s3.selectByVisibleText(value2);

		scrollAndClick(okbtn1);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(comments1))
				.sendKeys("Receiving sample from the outsource location");

		wait.until(ExpectedConditions.elementToBeClickable(receiveCheckBox)).click();

		wait.until(ExpectedConditions.elementToBeClickable(savebtn1)).click();
		wait.until(ExpectedConditions.elementToBeClickable(alertok1)).click();
	}
}
