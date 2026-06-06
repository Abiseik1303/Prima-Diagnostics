package com.TestProduct.Testcases;

import org.testng.annotations.Test;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.CommonTasks;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.VisitSearch;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class DoFromVisit extends BaseClass{

	
	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void Dofrom() throws Exception {
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
	
		bp.AddPayment();
		
		bp.Generatebill();
		
		bp.back();
		
		RolesPage p = new RolesPage(driver);
		p.phelbotomist(readconfig.getphelborole());
		
		PhelebotomistPage phlebo = new PhelebotomistPage(driver);
		phlebo.sampleReceive(name);

		VisitSearch v = new VisitSearch(driver);
		v.visit(name);
		
		String visit = helper.visit();
		
		RolesPage r = new RolesPage(driver);
		r.LabReception(readconfig.getReceptionrole());

		driver.navigate().refresh();
		
		CommonTasks c = new CommonTasks(driver);
		c.RegistrationBilling();
	
		BillingPage bp1 = new BillingPage(driver);
		bp1.dofromvisit(visit, name.toUpperCase());
		
		bp1.AddTest(readconfig.getAutoTest2());
		
		bp1.Addbtn();

		bp1.Generatebill();
		
Thread.sleep(2000);	
		bp1.FileUpload2();
		
		bp1.Generateworkorder();
		
		bp1.back();
		
		
		
	}		
}
