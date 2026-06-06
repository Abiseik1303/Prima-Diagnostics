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

public class RevisitPID extends BaseClass{

	
	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@SuppressWarnings("static-access")
	@Test(retryAnalyzer = Zretryclass.class)
	public void pid() throws Exception {
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
		
		String pidnumber = helper.pid();
		
		RolesPage r = new RolesPage(driver);
		r.LabReception(readconfig.getReceptionrole());
		
		driver.navigate().refresh();
		
		CommonTasks c = new CommonTasks(driver);
		c.RegistrationBilling();
	
		BillingPage bp1 = new BillingPage(driver);
		bp1.pidRevist(pidnumber);
		
		bp1.ReferringDR(readconfig.getRefdr());
		
		bp1.FileUpload();
		
		Thread.sleep(2000);
		bp1.AddTest(readconfig.getAutoTest2());
		
		bp1.screenShot();
		
		bp1.Addbtn();

		bp1.Generatebill();
		
		bp1.Generateworkorder();
		
		bp1.back();
		
		
		
	}	
}
