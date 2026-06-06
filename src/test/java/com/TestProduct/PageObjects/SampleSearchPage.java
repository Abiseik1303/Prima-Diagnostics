package com.TestProduct.PageObjects;

import java.time.Duration;

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

public class SampleSearchPage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	public SampleSearchPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID_OR_NAME, using = "txtPatientName")
	@CacheLookup
	WebElement PatientName;

	@FindBy(how = How.XPATH, using = "//input[@id='chkAberrant']")
	@CacheLookup
	WebElement CheckBox;

	@FindBy(how = How.ID, using = "ddlSampleStatus")
	@CacheLookup
	WebElement SampleStatus;

	@FindBy(how = How.XPATH, using = "//input[@onclick='return ValidateSearch();']")
	@CacheLookup
	WebElement Search, Search1;

	@FindBy(how = How.NAME, using = "grdSample$ctl01$ChkbxHeaderSelect")
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

	@FindBy(how = How.XPATH, using = "//button[@class='btn ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	@CacheLookup
	WebElement alertok, alertok1;

	public void checkbox(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(PatientName)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(CheckBox)).click();
	}

	public void selectstatus(String Status) {	
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(SampleStatus)));
		s.selectByVisibleText(Status);
	}

	public void Search(String value) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Commonbox)).click();
		
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(ActionDropdown)));
		s.selectByVisibleText(value);
		
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();

	}

	public void Outsourcedetails(String value1, String value2) throws Exception {
	
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		scrollAndClick(Commonbox);
		
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(ActionDropdown)));
		s.selectByVisibleText(value1);
		
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(comments))
		.sendKeys("Sending the sample to the outsource location");
		wait.until(ExpectedConditions.elementToBeClickable(savebtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(alertok)).click();
		wait.until(ExpectedConditions.elementToBeClickable(receivebtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search1)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Commonbox1)).click();
		
		Select s1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(ActionDropdown1)));
		s1.selectByVisibleText(value2);
		
		wait.until(ExpectedConditions.elementToBeClickable(okbtn1)).click();
		
//		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(comments1))
		.sendKeys("Receiving sample from the outsource location");
		wait.until(ExpectedConditions.elementToBeClickable(savebtn1)).click();
		wait.until(ExpectedConditions.elementToBeClickable(alertok1)).click();
		

	}

}
