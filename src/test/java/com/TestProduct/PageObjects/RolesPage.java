package com.TestProduct.PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

public class RolesPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public RolesPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@id='Attuneheader_UserHeader1_lblRolename']")
	@CacheLookup
	public WebElement box;

	@FindBy(how = How.ID, using = "ddlRole")
	@CacheLookup
	WebElement Roles;

	@FindBy(how = How.XPATH, using = "//input[@name='Attuneheader$btnRoleOK']")
	@CacheLookup
	WebElement okbtn;

	@FindBy(xpath = "//input[@name='BtnClosePkgItemDetail']")
	@CacheLookup
	WebElement Barcodeclose;

	@FindBy(xpath = "//select[@name='Attuneheader$ddlOrg']")
	@CacheLookup
	WebElement SelectOrg;

	@FindBy(xpath = "//select[@id='ddlOrgHeaderLocation']")
	@CacheLookup
	WebElement SelectLocation;

	/*
	 * @FindBy(xpath = "")
	 * 
	 * @CacheLookup WebElement ;
	 */

	public void CloseBarcode() {
		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
	}

	public void phelbotomist(String postion1) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion1);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
		
	}

	public void Accession(String postion2) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion2);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}

	public void LabTech(String postion3) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion3);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}

	public void LabReception(String postion4) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion4);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}

	public void Pathologist(String postion5) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion5);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}

	public void samerole() {
		box.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		okbtn.click();

	}

	public void Admin(String postion6) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion6);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}

	public void SeniorLabtech(String postion7) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion7);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}

	public void scrollup() throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false)", box);
	}

	public void AccessionOrgtoOrg(String a, String postion10, String b) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		
		Select s = new Select(SelectOrg);
		s.selectByVisibleText(a);
		
		Select s1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s1.selectByVisibleText(postion10);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Select s2 = new Select(SelectLocation);
		s2.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
		
	}
	
	public void CenterManager(String postion8) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion8);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}
	
	public void CreditController(String postion9) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(box)).click();
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Roles)));
		s.selectByVisibleText(postion9);
		wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
	}
	
	
}
