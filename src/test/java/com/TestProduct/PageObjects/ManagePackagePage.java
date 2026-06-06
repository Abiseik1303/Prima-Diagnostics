package com.TestProduct.PageObjects;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProduct.Utility.BaseClass;

public class ManagePackagePage extends BaseClass{
	WebDriver driver;

	public ManagePackagePage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	WebElement Masters;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='ManagePackage']")
	@CacheLookup
	WebElement managepackage;

	@FindBy(how = How.XPATH, using = "//input[@id='txtpackagename']")
	@CacheLookup
	WebElement packagename;

	@FindBy(how = How.XPATH, using = "//input[@id='txtBillingName']")
	@CacheLookup
	WebElement billingname;

	@FindBy(how = How.XPATH, using = "//input[@id='grdInvCodingScheme_ctl02_txtCodingSchemeNameMaster']")
	@CacheLookup
	WebElement packagecode;

	@FindBy(how = How.XPATH, using = "//input[@id='btnsave']")
	@CacheLookup
	WebElement addbtn;

	@FindBy(how = How.XPATH, using = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close']")
	@CacheLookup
	WebElement alertok;

	@FindBy(how = How.XPATH, using = "//input[@id='txtsearchpkg']")
	@CacheLookup
	WebElement enterpkgname;

	@FindBy(how = How.XPATH, using = "//input[@id='btnsearch']")
	@CacheLookup
	WebElement searchpkg;

	@FindBy(how = How.XPATH, using = "//a[@id='grdpackages_ctl02_lnkshow']")
	@CacheLookup
	WebElement eyeicon;

	@FindBy(how = How.XPATH, using = "//u[normalize-space()='Add More..']")
	@CacheLookup
	WebElement addmore;

	@FindBy(how = How.XPATH, using = "//select[@name='InvestigationControl1$listGRP']")
	@CacheLookup
	WebElement groupclickbox;

	@FindBy(how = How.XPATH, using = "//select[@name='InvestigationControl1$listINV']")
	@CacheLookup
	WebElement Invclickbox;

	@FindBy(how = How.XPATH, using = "//input[@id='txtBX']")
	@CacheLookup
	WebElement grpcontent1, grpcontent2, grpcontent3;

	@FindBy(how = How.XPATH, using = "//option[@value='11010']")
	@CacheLookup
	WebElement groupLipidclick;

	@FindBy(how = How.XPATH, using = "//option[@value='11006']")
	@CacheLookup
	WebElement groupLiverclick;

	@FindBy(how = How.XPATH, using = "//option[@value='10965']")
	@CacheLookup
	WebElement groupCBCclick;

	@FindBy(how = How.XPATH, using = "//option[@value='40216']")
	@CacheLookup
	WebElement invvitb12click;

	@FindBy(how = How.XPATH, using = "//option[@value='40261']")
	@CacheLookup
	WebElement invca125click;

	@FindBy(how = How.XPATH, using = "//option[@value='39961']")
	@CacheLookup
	WebElement invzincclick;

	@FindBy(how = How.ID, using = "hypLnkFinish")
	@CacheLookup
	WebElement Addcontent;

	@FindBy(how = How.ID_OR_NAME, using = "btnFinish")
	@CacheLookup
	WebElement save;

	public void addgrouptopackage(String pname, String tcode, String content1, String content2, String content3)
			throws InterruptedException {
		Masters.click();
		managepackage.click();
		packagename.sendKeys(pname);
	billingname.sendKeys(pname);
		packagecode.sendKeys(tcode);
		addbtn.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(alertok));
		alertok.click();
		enterpkgname.sendKeys(pname);
		searchpkg.click();
	    Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.pollingEvery(Duration.ofSeconds(10));
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElement(enterpkgname, enterpkgname.getText()));
		eyeicon.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addmore));
		addmore.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(groupclickbox));
		groupclickbox.click();
		grpcontent1.sendKeys(content1);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(groupCBCclick));
		performdoubleclick(groupCBCclick);
		grpcontent1.sendKeys(content2);
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(groupLipidclick));
		performdoubleclick(groupLipidclick);
		grpcontent1.sendKeys(content3);
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(groupLiverclick));
		performdoubleclick(groupLiverclick);

	}

	public void addinvtopackage(String inv1, String inv2, String inv3) {
		Invclickbox.click();
		grpcontent1.sendKeys(inv1);
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(invvitb12click));
		performdoubleclick(invvitb12click);
		grpcontent1.sendKeys(inv2);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(invca125click));
		performdoubleclick(invca125click);
		grpcontent1.sendKeys(inv3);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(invzincclick));
		performdoubleclick(invzincclick);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Addcontent));
		Addcontent.click();
		save.click();
	}

	public void performdoubleclick(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.doubleClick(ele).perform();
	}
	
	public void waitthedriver() {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3));
		
		wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return eyeicon;
				
			}
		});
	}

}
