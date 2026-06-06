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


public class AddGroupInvestigations extends BaseClass{
	
	WebDriver driver;
	WebDriverWait wait;

	public AddGroupInvestigations(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	public WebElement Masters;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Add Investigation/Groups')]")
	@CacheLookup
	public WebElement addinvgrp;

	@FindBy(how = How.NAME, using = "ddlLocation")
	@CacheLookup
	public WebElement inv;

	@FindBy(how = How.ID, using = "btnOk")
	@CacheLookup
	public WebElement ok;

	@FindBy(how = How.NAME, using = "TabContainer1$tab1$ManageInvestigation$txt_search")
	@CacheLookup
	public WebElement investname;

	@FindBy(how = How.ID, using = "TabContainer1_tab1_ManageInvestigation_btnmassearch")
	@CacheLookup
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//input[@id='TabContainer1_tab1_ManageInvestigation_chklstGrp_0']")
	@CacheLookup
	public WebElement SearchMasterInv;

	@FindBy(how = How.NAME, using = "TabContainer1$tab1$ManageInvestigation$btnInvAdd")
	@CacheLookup
	public WebElement add;
	
    @FindBy(how = How.ID, using = "okbtnid")
	@CacheLookup
	public WebElement alertok;
    
	@FindBy(how = How.ID, using = "TabContainer1_tab1_ManageInvestigation_txt_searchmap")
	@CacheLookup
	public WebElement SearchMappedInv;

	@FindBy(how = How.NAME, using = "TabContainer1$tab1$ManageInvestigation$btnmapsearch")
	@CacheLookup
	public WebElement Mappedsearch;
	
	public void MapInvtoLIS(String type, String tname) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(Masters)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addinvgrp)).click();
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(inv)));
		select.selectByVisibleText(type);
		
		wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
		wait.until(ExpectedConditions.elementToBeClickable(investname)).sendKeys(tname);
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SearchMasterInv)).click();
		wait.until(ExpectedConditions.elementToBeClickable(add)).click();
		wait.until(ExpectedConditions.elementToBeClickable(alertok)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SearchMappedInv)).sendKeys(tname);
		wait.until(ExpectedConditions.elementToBeClickable(Mappedsearch)).click();
		

	}


	
}
