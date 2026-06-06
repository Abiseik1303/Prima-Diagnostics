package com.TestProduct.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProduct.Utility.BaseClass;

public class AddnewInvestigationPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public AddnewInvestigationPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	public WebElement Masters;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Add New Investigation')]")
	@CacheLookup
	WebElement addnewinv;
	

	@FindBy(how = How.NAME, using = "txtInvestigation")
	@CacheLookup
	public WebElement invname;

	@FindBy(how = How.NAME, using = "grdInvCodingScheme$ctl02$txtCodingSchemeNameMaster")
	@CacheLookup
	public WebElement invcode;

	@FindBy(how = How.NAME, using = "btnGo")
	@CacheLookup
	public WebElement save;

	@FindBy(how = How.ID, using = "okbtnid")
	@CacheLookup
	public WebElement addbutton;

	
	public void NewInvestigation(String iname, String icode) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(Masters)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addnewinv)).click();
		wait.until(ExpectedConditions.elementToBeClickable(invname)).sendKeys(iname);
		wait.until(ExpectedConditions.elementToBeClickable(invcode)).sendKeys(icode);
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addbutton)).click();

	}

}
