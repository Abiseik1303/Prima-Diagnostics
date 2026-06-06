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

public class RoleSelectionPage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	public RoleSelectionPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//span[@id='Attuneheader_UserHeader1_lblRolename']")
	@CacheLookup
	public WebElement Role;

	@FindBy(id = "ddlRole")
	@CacheLookup
	WebElement UserRole;

	@FindBy(id = "ddlLocation")
	@CacheLookup
	WebElement UserLocation;

	@FindBy(how = How.ID, using = "imgGo")
	@CacheLookup
	WebElement go;
	
	@FindBy(xpath = "//input[@name='Attuneheader$btnRoleOK']")
	@CacheLookup
	public WebElement RoleOK;
	
	@FindBy(xpath = "//select[@name='ddlOrg']")
	@CacheLookup
	public WebElement orgName;
	
	
	
	public void selectOrg(String orgname) {
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(orgName)));
		s.selectByVisibleText(orgname);
		}
	
	public void ClickRole() {
		wait.until(ExpectedConditions.elementToBeClickable(Role)).click();
	}

	public void selectRole(String Role) {
		Select rolevalue=new Select(wait.until(ExpectedConditions.elementToBeClickable(UserRole)));
		rolevalue.selectByVisibleText(Role);
	}

	public void selectLocation(String Location) {	
		Select rolevalue=new Select(wait.until(ExpectedConditions.elementToBeClickable(UserLocation)));
		rolevalue.selectByVisibleText(Location);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
	}
	
	public void RoleOK() {
		wait.until(ExpectedConditions.elementToBeClickable(RoleOK)).click();
	}
	

}