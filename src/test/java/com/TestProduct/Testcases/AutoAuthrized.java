package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LabTechnicianPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.VisitSearch;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class AutoAuthrized extends BaseClass{

	
	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void autoAuthrized() throws Exception {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
		
		RoleSelectionPage roleselection = new RoleSelectionPage(driver);

		roleselection.selectRole(readconfig.getRole1());

		roleselection.selectLocation(readconfig.getLocation());
		
		BillingPage bp = new BillingPage(driver);
		bp.LabQuickBilling();
		
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
		
		bp.AddTest(readconfig.getAutoTest1());
		
		bp.Addbtn();
	
		bp.isStat();

		bp.AddPayment();
	
		bp.Generatebill();
		
		bp.back();
	
		RolesPage p = new RolesPage(driver);
		p.phelbotomist(readconfig.getphelborole());

		PhelebotomistPage phlebo = new PhelebotomistPage(driver);
		phlebo.sampleReceive(name);

		RolesPage p1 = new RolesPage(driver);
		p1.LabTech(readconfig.getLabTechrole());
		
		LabTechnicianPage l = new LabTechnicianPage(driver);
		l.enterresult(name, readconfig.getResultentry2());

		VisitSearch v = new VisitSearch(driver);
		v.visit(name);
		
		
			
}
}