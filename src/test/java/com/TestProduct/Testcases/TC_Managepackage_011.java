package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.ManagePackagePage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.Readconfig;

public class TC_Managepackage_011 extends BaseClass {
	Readconfig readconfig = new Readconfig();

	@Test
	public void managepackage() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login(Username, Password);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);
		rsp.selectRole(readconfig.getRole2());
		rsp.selectLocation(readconfig.getLocation());

		ManagePackagePage mpp = new ManagePackagePage(driver);
		mpp.addgrouptopackage(readconfig.getpackagename(), readconfig.getpackagecode(), readconfig.getpkgcont1(),
				readconfig.getpkgcont2(), readconfig.getpkgcont3());
		mpp.addinvtopackage(readconfig.getpkgcont4(), readconfig.getpkgcont5(), readconfig.getpkgcont6());
Thread.sleep(3000);
		mpp.recheckPackage(readconfig.getpackagename());

	}

}
