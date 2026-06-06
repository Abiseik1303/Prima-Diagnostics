package com.TestProduct.Testcases;

import org.testng.annotations.Test;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.Manageuser;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;



public class ManageUserPrima extends BaseClass{
	
	Readconfig config = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void newUserCreation() throws Exception {
		LoginPage l = new LoginPage(driver);
		l.login(Username, Password);
		
		RoleSelectionPage role = new RoleSelectionPage(driver);
		role.selectRole(config.getRole2());
		
		role.selectLocation(config.getLocation());
		
		Manageuser user = new Manageuser(driver);
		user.newuser(config.getempID() ,config.getusername(), config.getemail(), 
				config.getaddress1() ,config.getcity1(), config.getmobilenum());
		
		user.logout();
		
		user.newuserlogin(config.getusername(), config.getusername());
		
		user.passwordReset(config.getusername(), config.getNewpassword(),
				config.getNewpassword());
		
		
	}

}
