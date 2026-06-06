package com.TestProduct.Testcases;

import org.testng.annotations.Test;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LabTechnicianPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PathologistPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class Rerun extends BaseClass{

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void reRun() throws Exception {
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
		
		bp.AddTest(readconfig.getTest1());
		
		bp.Addbtn();

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
		l.enterresult(name, readconfig.getResultentry1());
		
		RolesPage p2 = new RolesPage(driver);
		p2.SeniorLabtech(readconfig.getSeniorLab());
		
		l.validation(name);
	
		BillingPage bp1 = new BillingPage(driver);
		bp1.scrollup();
		
		RolesPage p4 = new RolesPage(driver);
		p4.Pathologist(readconfig.getPathorole());
		
		PathologistPage patho1 = new PathologistPage(driver);
		patho1.rerun(name, readconfig.rerun());
		
		RolesPage p3 = new RolesPage(driver);
		p3.LabTech(readconfig.getLabTechrole());
		
		LabTechnicianPage l1 = new LabTechnicianPage(driver);
		l1.enterresult(name, readconfig.getResultentry1());
		
		RolesPage p5 = new RolesPage(driver);
		p5.SeniorLabtech(readconfig.getSeniorLab());
		
		l1.validation(name);
	
		BillingPage bp2 = new BillingPage(driver);
		bp2.scrollup();
		
		RolesPage p6 = new RolesPage(driver);
		p6.Pathologist(readconfig.getPathorole());
		
		PathologistPage patho = new PathologistPage(driver);
		patho.Approval(name);
		
	}
}
