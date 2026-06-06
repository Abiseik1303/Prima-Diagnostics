package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.AccessionPage;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LabTechnicianPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PathologistPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.Viewregisterationpage;
import com.TestProduct.PageObjects.VisitSearch;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class BillingtoApproval extends BaseClass{

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void billtoapproval() throws Exception {
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
		
		bp.isStat();
		
		bp.AddPayment();
	
		bp.Generatebill();
		
		bp.back();
		
		RolesPage p = new RolesPage(driver);
		p.phelbotomist(readconfig.getphelborole());
		
		PhelebotomistPage phlebo = new PhelebotomistPage(driver);
		phlebo.samplecollect(name, readconfig.getstatusCollected());
		
		RolesPage acces = new RolesPage(driver);
		acces.Accession(readconfig.getAccessionrole());
		
		AccessionPage a = new AccessionPage(driver);
		a.receicesample(name);
		
		RolesPage labtech = new RolesPage(driver);
		labtech.LabTech(readconfig.getLabTechrole());
		
		LabTechnicianPage l = new LabTechnicianPage(driver);
		l.enterresult(name, readconfig.getResultentry1());
		
		RolesPage senior = new RolesPage(driver);
		senior.SeniorLabtech(readconfig.getSeniorLab());
		
		LabTechnicianPage l1 = new LabTechnicianPage(driver);
		l1.validation(name);
		
		BillingPage bp1 = new BillingPage(driver);
		bp1.scrollup();
		
		RolesPage patholo = new RolesPage(driver);
		patholo.Pathologist(readconfig.getPathorole());
		
		PathologistPage patho = new PathologistPage(driver);
		patho.Approval(name);
		
		VisitSearch v = new VisitSearch(driver);
		v.visit(name);
		
		Viewregisterationpage view = new Viewregisterationpage(driver);
		String visitnum = view.visitnumber();
		
		view.ViewRegistration(visitnum);
		
		
	}
}
