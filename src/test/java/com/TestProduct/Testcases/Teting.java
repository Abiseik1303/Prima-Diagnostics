package com.TestProduct.Testcases;

import org.testng.annotations.Test;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class Teting extends BaseClass{

	
	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test
	public void testingDummy() throws Exception {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
	
		RoleSelectionPage roleselection = new RoleSelectionPage(driver);

		roleselection.selectRole(readconfig.getRole1());

		roleselection.selectLocation(readconfig.getLocation());
		
		BillingPage p = new BillingPage(driver);
		p.LabQuickBilling();
		
		BillingPage bp = new BillingPage(driver);
		bp.None();
		
		bp.PatientSalutation(readconfig.getSalutation());
		

		String name = helper.generatedname();
		String age = helper.generatedage();
		String mobno = helper.generatedmobno();

		bp.PatientName(name);

		bp.PatientAge(age);

		bp.PatientMobile(mobno);
		
		bp.PatientEmail(readconfig.getEmail());
		
		bp.ReferringDR(readconfig.getRefdr());
		
		bp.FileUpload();
		
		bp.AddTest(readconfig.getTest1());
		
		bp.Addbtn();
		
		bp.AddPayment();
		
		bp.Generatebill();
	
		bp.back();
		
		RolesPage p1 = new RolesPage(driver);
		p1.phelbotomist(readconfig.getphelborole());
		
		PhelebotomistPage phlebo = new PhelebotomistPage(driver);
		phlebo.samplecollect(name, readconfig.getstatusCollected());
		
		RolesPage acces = new RolesPage(driver);
		acces.Accession(readconfig.getAccessionrole());
				
}
}