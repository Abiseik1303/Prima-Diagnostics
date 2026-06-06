package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.AddGroupMaster;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.Readconfig;

public class AddNewGroup extends BaseClass {
	Readconfig readconfig = new Readconfig();

	@Test
	public void addGroup() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.login(Username, Password);

		Thread.sleep(3000);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);
		rsp.selectRole(readconfig.getRole2());
		Thread.sleep(3000);
		rsp.selectLocation(readconfig.getLocation());

		AddGroupMaster agm = new AddGroupMaster(driver);
		agm.ADDinv1togroup(readconfig.getgroupname(), readconfig.getgroupcode(),readconfig.getgrpcontent1());
		agm.ADDinv2togroup(readconfig.getgrpcontent2());
		agm.ADDinv3togroup(readconfig.getgrpcontent3());
		agm.ADDsubgrptogroup(readconfig.getsubgroup());
		Thread.sleep(2000);
		
		agm.AssociateGroupDetails(readconfig.getgroupname(), readconfig.getmasterupdation());
	}
}
