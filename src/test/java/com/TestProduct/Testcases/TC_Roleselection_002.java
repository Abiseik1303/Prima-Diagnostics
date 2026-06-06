package com.TestProduct.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.Readconfig;

public class TC_Roleselection_002 extends BaseClass {

	Readconfig readConfig = new Readconfig();

	@Test
	public void Roleselection() throws Exception {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
		

		Thread.sleep(2000);

		RoleSelectionPage roleselection = new RoleSelectionPage(driver);

		roleselection.selectRole(readConfig.getRole1());
		
		
		Thread.sleep(5000);
		
		roleselection.selectLocation(readConfig.getLocation());
		
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("Billing")) {
			Assert.assertTrue(true);
			
		}

		else {
			screenshot(driver, "TC_Roleselection_002");
			Assert.assertTrue(false);
			

		}
			

	}

}

