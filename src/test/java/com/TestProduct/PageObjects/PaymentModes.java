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

public class PaymentModes extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;

	public PaymentModes(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
}
	
	@FindBy(how = How.XPATH, using = "//select[@name='billPart$PaymentType$ddlPaymentType']")
	@CacheLookup
	public WebElement Paymenttype;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billPart$PaymentType$txtAmount']")
	@CacheLookup
	public WebElement Amount;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Add'])[3]")
	@CacheLookup
	public WebElement Addpayment;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billPart$PaymentType$txtBankType']")
	@CacheLookup
	public WebElement Cardtype;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billPart$PaymentType$txtUPITypeSearch']")
	@CacheLookup
	public WebElement UPI;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billPart$PaymentType$txtNumber']")
	@CacheLookup
	public WebElement Cardnumber;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billPart$PaymentType$txtCardHolderName']")
	@CacheLookup
	public WebElement CardHoldername;
	
	
	public void Onlinepayment(String a, Double b) throws InterruptedException {
		
		
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Paymenttype)));
		s.selectByVisibleText(a);
		
		wait.until(ExpectedConditions.elementToBeClickable(Amount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Amount)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(Amount)).sendKeys(String.valueOf(b));
		wait.until(ExpectedConditions.elementToBeClickable(Addpayment)).click();
	}
	
	public void Cardpayment( String c, Double d, String e, String f, String g) throws InterruptedException {
		Select s1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Paymenttype)));
		s1.selectByVisibleText(c);
		
		wait.until(ExpectedConditions.elementToBeClickable(Amount)).sendKeys(String.valueOf(d));
		wait.until(ExpectedConditions.elementToBeClickable(Cardtype)).sendKeys(e);
		wait.until(ExpectedConditions.elementToBeClickable(Cardnumber)).sendKeys(f);
		wait.until(ExpectedConditions.elementToBeClickable(CardHoldername)).sendKeys(g);
		wait.until(ExpectedConditions.elementToBeClickable(Addpayment)).click();
	}
	
	public void CreditNote(String c, Double d, String e, String f) throws InterruptedException {
		Select s1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Paymenttype)));
		s1.selectByVisibleText(c);
		
		wait.until(ExpectedConditions.elementToBeClickable(Amount)).sendKeys(String.valueOf(d));
		wait.until(ExpectedConditions.elementToBeClickable(Cardtype)).sendKeys(e);
		wait.until(ExpectedConditions.elementToBeClickable(Cardnumber)).sendKeys(f);
		wait.until(ExpectedConditions.elementToBeClickable(Addpayment)).click();
	}
	
	public void UpiPayments(String a,  String c, Double b, String d) throws InterruptedException {
		Select s1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Paymenttype)));
		s1.selectByVisibleText(a);
		wait.until(ExpectedConditions.elementToBeClickable(UPI)).sendKeys(c);
		wait.until(ExpectedConditions.elementToBeClickable(Amount)).sendKeys(String.valueOf(b));
		wait.until(ExpectedConditions.elementToBeClickable(Cardnumber)).sendKeys(d);
		wait.until(ExpectedConditions.elementToBeClickable(Addpayment)).click();
	}
	
}
