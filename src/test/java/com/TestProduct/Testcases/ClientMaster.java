package com.TestProduct.Testcases;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.TestProduct.PageObjects.ClientMasterPage;
import com.TestProduct.PageObjects.ClientRateMappingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class ClientMaster extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;

	@Test
	public void clientCreation() throws Exception {

		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
		

		Thread.sleep(2000);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);

		rsp.selectRole(readconfig.getRole2());
		
		
		Thread.sleep(5000);

		rsp.selectLocation(readconfig.getLocation());
	

		ClientMasterPage cmp = new ClientMasterPage(driver);
		Thread.sleep(3000);
		cmp.clientidentity(readconfig.getclienttype(),readconfig.getclientname(),readconfig.getclientcode(),readconfig.getbussinestype());
		Thread.sleep(2000);
		cmp.scrolldown2();
		Thread.sleep(2000);
		cmp.clientcommercial(readconfig.getinvoicecycle());
		Thread.sleep(2000);
		cmp.scrollup();
		cmp.clientNotification();
		cmp.clientshipinfo(readconfig.getaddresstype(), readconfig.getaddress(),readconfig.getcity(), readconfig.getmobilenumber(), readconfig.getemailid());
		cmp.clientcontactinfo(readconfig.getcontacttype(), readconfig.getcontactname());
		cmp.saveclient();
		
		ClientRateMappingPage crm=new ClientRateMappingPage(driver);
		crm.clientratemap(readconfig.getbussinestype(),readconfig.getclientname(),readconfig.getratetype(),readconfig.getratecard());
		crm.selectcalender();
		Thread.sleep(2000);
	}
}
