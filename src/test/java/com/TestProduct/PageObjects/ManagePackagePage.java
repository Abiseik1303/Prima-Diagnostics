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
import com.TestProduct.Utility.ScreenshotUtils;

public class ManagePackagePage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;

	public ManagePackagePage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	WebElement Masters;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'ManagePackage')]")
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

	@FindBy(how = How.XPATH, using = "//button[@class='btn Generic_Button Profile_Data_Txt_Styling Submit_Btn']")
	@CacheLookup
	WebElement alertok;

	@FindBy(how = How.XPATH, using = "//input[@id='txtsearchpkg']")
	@CacheLookup
	WebElement enterpkgname, enterpkgname1;

	@FindBy(how = How.XPATH, using = "//input[@id='btnsearch']")
	@CacheLookup
	WebElement searchpkg, searchpkg1;

	@FindBy(how = How.XPATH, using = "//a[@id='grdpackages_ctl02_lnkshow']")
	@CacheLookup
	WebElement eyeicon, eyeicon1;

	@FindBy(how = How.XPATH, using = "//u[normalize-space()='Add More..']")
	@CacheLookup
	WebElement addmore, addmore1;

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

	@FindBy(how = How.XPATH, using = "//option[@value='20166']")
	@CacheLookup
	WebElement groupCBCclick;

	@FindBy(how = How.XPATH, using = "//option[@value='72842']")
	@CacheLookup
	WebElement invvitb12click;

	@FindBy(how = How.XPATH, using = "//option[@value='72875']")
	@CacheLookup
	WebElement invca125click;

	@FindBy(how = How.XPATH, using = "//option[@value='72823']")
	@CacheLookup
	WebElement invzincclick;

	@FindBy(how = How.ID, using = "hypLnkFinish")
	@CacheLookup
	WebElement Addcontent;

	@FindBy(how = How.ID_OR_NAME, using = "btnFinish")
	@CacheLookup
	WebElement save;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Close']")
	@CacheLookup
	WebElement Close1;
	
	@FindBy(how = How.XPATH, using = "")
	@CacheLookup
	WebElement Close2;

	public void addgrouptopackage(String pname, String tcode, String content1, String content2, String content3)
			throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Masters)).click();
		wait.until(ExpectedConditions.elementToBeClickable(managepackage)).click();
		wait.until(ExpectedConditions.elementToBeClickable(packagename)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(billingname)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(packagecode)).sendKeys(tcode);
		wait.until(ExpectedConditions.elementToBeClickable(addbtn)).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(alertok));
		alertok.click();
		
		scrollAndSendKeys(enterpkgname, pname);
		wait.until(ExpectedConditions.elementToBeClickable(searchpkg)).click();
Thread.sleep(3000);		
		wait.until(ExpectedConditions.elementToBeClickable(eyeicon)).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addmore));
		addmore.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(groupclickbox));
		groupclickbox.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(grpcontent1)).sendKeys(content1);
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(groupCBCclick));
		performdoubleclick(groupCBCclick);

		/*
		wait.until(ExpectedConditions.elementToBeClickable(grpcontent2)).sendKeys(content2);
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(groupLipidclick));
		performdoubleclick(groupLipidclick);
		
		wait.until(ExpectedConditions.elementToBeClickable(grpcontent3)).sendKeys(content3);
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(groupLiverclick));
		performdoubleclick(groupLiverclick);  */

	}

	@SuppressWarnings("static-access")
	public void addinvtopackage(String inv1, String inv2, String inv3) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Invclickbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(grpcontent1)).sendKeys(inv1);
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(invvitb12click));
		performdoubleclick(invvitb12click);
		
		wait.until(ExpectedConditions.elementToBeClickable(grpcontent2)).sendKeys(inv2);
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(invca125click));
		performdoubleclick(invca125click);
		
		wait.until(ExpectedConditions.elementToBeClickable(grpcontent3)).sendKeys(inv3);
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(invzincclick));
		performdoubleclick(invzincclick);
		
		wait.until(ExpectedConditions.elementToBeClickable(Addcontent));
		screenshot.captureBeforeClick(driver, Addcontent);
		Addcontent.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
		
	}
	
	@SuppressWarnings("static-access")
	public void recheckPackage(String pname) throws InterruptedException {
		scrollAndSendKeys(enterpkgname1, pname);
		wait.until(ExpectedConditions.elementToBeClickable(searchpkg1)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(eyeicon1)).click();
		
		Thread.sleep(2000);
		screenshot.captureScreenshot(driver);
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
