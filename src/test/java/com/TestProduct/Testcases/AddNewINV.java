package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.AddGroupInvestigations;
import com.TestProduct.PageObjects.AddnewInvestigationPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.TestmasterDetails;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class AddNewINV extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test
	public void addNewinvestigation() throws Exception {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);

		RoleSelectionPage roleselection = new RoleSelectionPage(driver);

		roleselection.selectRole(readconfig.getRole2());

		roleselection.selectLocation(readconfig.getLocation());

		//String Invname=helper.generatedname();
		//String Invcode=helper.generatedname();

		AddnewInvestigationPage anip = new AddnewInvestigationPage(driver);
		anip.NewInvestigation(readconfig.getinvname(), readconfig.getinvcode());
		
//		 RolesPage rp = new RolesPage(driver);
//		 rp.samerole();

		 AddGroupInvestigations agi=new AddGroupInvestigations(driver);
		 agi.MapInvtoLIS(readconfig.gettype(), readconfig.getinvname());
		 
		 TestmasterDetails ts = new TestmasterDetails(driver);
		 ts.findINV(readconfig.getinvname());
		 
		 ts.Selectdept(readconfig.getdepartment(), readconfig.getdepartmentheader(), 
				 readconfig.getresultvalue(), readconfig.getsample(), readconfig.getadditive());
		 
	     ts.rangemapping(readconfig.getRangetype(), readconfig.getgender(), readconfig.getcategory(),
	    		 readconfig.getvaluetype(), readconfig.getvalue1(), readconfig.getvalue2());
	     
	    ts.Testmasterupdation(readconfig.getmasterupdation());
	     
	     
	}

}
