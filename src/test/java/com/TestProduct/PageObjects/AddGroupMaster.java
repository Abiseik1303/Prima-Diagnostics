package com.TestProduct.PageObjects;


import java.time.Duration;
import java.util.List;

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

public class AddGroupMaster extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;

	public AddGroupMaster(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	public WebElement Masters;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Add Investigation/Groups')]")
	@CacheLookup
	public WebElement Groupmaster;

	@FindBy(how = How.NAME, using = "btnOk")
	@CacheLookup
	public WebElement okbtn;

	@FindBy(how = How.ID, using = "grouptab_Createtab_txtpackage")
	@CacheLookup
	public WebElement Groupname;

	@FindBy(how = How.ID, using = "grouptab_Createtab_grdInvCodingScheme_ctl02_txtCodingSchemeNameMaster")
	@CacheLookup
	public WebElement Groupcode;

	@FindBy(how = How.NAME, using = "grouptab$Createtab$Add")
	@CacheLookup
	public WebElement Addbtn;

	@FindBy(how = How.ID, using = "okbtnid")
	@CacheLookup
	public WebElement alertok;

	@FindBy(how = How.ID, using = "__tab_grouptab_addgrouptab")
	@CacheLookup
	public WebElement AddGroup;

	@FindBy(how = How.ID, using = "grouptab_addgrouptab_txt_searchmap")
	@CacheLookup
	public WebElement SearchGroup;

	@FindBy(how = How.ID, using = "grouptab_addgrouptab_btnmapsearch")
	@CacheLookup
	public WebElement Searchbtn;

	@FindBy(how = How.XPATH, using = "//input[@onclick='show(name);']")
	@CacheLookup
	public WebElement showbtn;

	@FindBy(how = How.XPATH, using = "//input[@value='rdoInvestigation']")
	@CacheLookup
	public WebElement RadioINV;

	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_addgrouptab_ManageInvestigation_txt_search']")
	@CacheLookup
	public WebElement INV1;

	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_addgrouptab_ManageInvestigation_txt_search']")
	@CacheLookup
	public WebElement INV2;

	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_addgrouptab_ManageInvestigation_txt_search']")
	@CacheLookup
	public WebElement INV3;

	@FindBy(how = How.NAME, using = "grouptab$addgrouptab$ManageInvestigation$btnmassearch")
	@CacheLookup
	public WebElement InsideSearchbtn1;

	@FindBy(how = How.NAME, using = "grouptab$addgrouptab$ManageInvestigation$btnmassearch")
	@CacheLookup
	public WebElement InsideSearchbtn2;

	@FindBy(how = How.NAME, using = "grouptab$addgrouptab$ManageInvestigation$btnmassearch")
	@CacheLookup
	public WebElement InsideSearchbtn3;

	@FindBy(how = How.ID, using = "grouptab_addgrouptab_ManageInvestigation_chklstGrp_0")
	@CacheLookup
	public WebElement Inv1Chkbox;

	@FindBy(how = How.ID, using = "grouptab_addgrouptab_ManageInvestigation_chklstGrp_0")
	@CacheLookup
	public WebElement Inv2chkbox;

	@FindBy(how = How.ID, using = "grouptab_addgrouptab_ManageInvestigation_chklstGrp_0")
	@CacheLookup
	public WebElement Inv3chkbox;

	@FindBy(how = How.XPATH, using = "(//input[@value='Add'])[3]")
	@CacheLookup
	public WebElement InsADDbtn1, InsAddbtn2, InsAddbtn3, InsAddbtn4;

	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_addgrouptab_ManageInvestigation_rdoGroup']")
	@CacheLookup
	public WebElement selectgrp;

	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_addgrouptab_ManageInvestigation_txt_search']")
	@CacheLookup
	public WebElement grp1;

	@FindBy(how = How.NAME, using = "grouptab$addgrouptab$ManageInvestigation$btnmassearch")
	@CacheLookup
	public WebElement InsideSearchbtn4;

	@FindBy(how = How.ID, using = "grouptab_addgrouptab_ManageInvestigation_chklstGrp_0")
	@CacheLookup
	public WebElement Inv4chkbox;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Close'])[1]")
	@CacheLookup
	public WebElement Closebtn;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Associate Group')]")
	@CacheLookup
	public WebElement associateTab;
	
	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_AssociateGroupTab_txtTestCodeScheme']")
	@CacheLookup
	public WebElement passGroupName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='grouptab$AssociateGroupTab$btnLoadGroupDetails']")
	@CacheLookup
	public WebElement loadGroup;
	
	@FindBy(how = How.XPATH, using = "//input[@id='grouptab_AssociateGroupTab_TabContainer1_TabGeneral_txtCutOffValue']")
	@CacheLookup
	public WebElement processingTime;
	
	@FindBy(how = How.XPATH, using = "//select[@name='grouptab$AssociateGroupTab$ddlReasonn']")
	@CacheLookup
	public WebElement selectReason;
	
	@FindBy(how = How.XPATH, using = "//input[@title='Click here to Save Details']")
	@CacheLookup
	public WebElement saveGroupDetails;
					
					

	public void ADDinv1togroup(String gname, String gcode, String content1) throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(Masters)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Groupmaster)).click();
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Groupname)).sendKeys(gname);
		wait.until(ExpectedConditions.elementToBeClickable(Groupcode)).sendKeys(gcode);
		wait.until(ExpectedConditions.elementToBeClickable(Addbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(alertok)).click();
		wait.until(ExpectedConditions.elementToBeClickable(AddGroup)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SearchGroup)).sendKeys(gname);
		wait.until(ExpectedConditions.elementToBeClickable(Searchbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(showbtn)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(RadioINV)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(INV1)).sendKeys(content1);
		wait.until(ExpectedConditions.elementToBeClickable(InsideSearchbtn1)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Inv1Chkbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(InsADDbtn1)).click();
		
		handleAlertIfPresent();
	}

	public void ADDinv2togroup(String content2) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(INV2)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(INV2)).sendKeys(content2);
		wait.until(ExpectedConditions.elementToBeClickable(InsideSearchbtn2)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Inv2chkbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(InsAddbtn2)).click();
		
		handleAlertIfPresent();
	}

	public void ADDinv3togroup(String content3) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(INV3)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(INV3)).sendKeys(content3);
		wait.until(ExpectedConditions.elementToBeClickable(InsideSearchbtn3)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Inv3chkbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(InsAddbtn3)).click();

		handleAlertIfPresent();
	}

	public void ADDsubgrptogroup(String subgroup) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(selectgrp)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(grp1)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(grp1)).sendKeys(subgroup);
		waitForPageLoad(2);
		wait.until(ExpectedConditions.elementToBeClickable(InsideSearchbtn4)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Inv4chkbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(InsAddbtn4)).click();
		
		handleAlertIfPresent();

		wait.until(ExpectedConditions.elementToBeClickable(Closebtn)).click();
	}
	

	public void AssociateGroupDetails(String a, String b) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(associateTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(passGroupName)).sendKeys(a);
		
		List<WebElement> Grp = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("(//ul[@id='grouptab_AssociateGroupTab_ACETestCodeScheme_completionListElem'])[12]"), 0));
		for(WebElement list: Grp) {
			if(list.getText().contains(a)) {
				wait.until(ExpectedConditions.elementToBeClickable(list)).click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(loadGroup)).click();
		
		Thread.sleep(2000);
		
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(selectReason)));
		s.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(processingTime)).sendKeys("1");
		
		scrollAndClick(saveGroupDetails);
	}
	
	
}
