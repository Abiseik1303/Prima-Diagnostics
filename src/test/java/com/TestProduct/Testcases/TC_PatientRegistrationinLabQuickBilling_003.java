package com.TestProduct.Testcases;


import org.testng.annotations.Test;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.SampleCollectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class TC_PatientRegistrationinLabQuickBilling_003 extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();

	@Test
	public void PatientBilling() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
		

		Thread.sleep(2000);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);

		rsp.selectRole(readconfig.getRole1());
		
		
		Thread.sleep(5000);

		rsp.selectLocation(readconfig.getLocation());
		

		Thread.sleep(2000);

		BillingPage billpage = new BillingPage(driver);
		billpage.LabQuickBilling();// Lab Quick Bill Registration
		
		billpage.None();

		billpage.PatientSalutation(readconfig.getSalutation());
		

		String name = helper.generatedname();
		String age = helper.generatedage();
		String mobno = helper.generatedmobno();

		billpage.PatientName(name);
		

		billpage.PatientAge(age);
	

		billpage.PatientMobile(mobno);
		
		
        billpage.PatientEmail(readconfig.getEmail());
		
        billpage.ReferringDR(readconfig.getRefdr());
		
        billpage.FileUpload();

		billpage.AddTest(readconfig.getTest1());
		

		billpage.Addbtn();
		
		Thread.sleep(1000);
		billpage.scrolldown1();
		
		Thread.sleep(1000);
		billpage.AddPayment();
		
		Thread.sleep(1000);
		billpage.scrolldown1();
		
		billpage.Generatebill();
	
		Thread.sleep(4000);

		Thread.sleep(4000);
		SampleCollectionPage SampleCollect = new SampleCollectionPage(driver);
		
		SampleCollect.billprintclose();
		
		Thread.sleep(2000);

		RolesPage rolepage = new RolesPage(driver);
		rolepage.phelbotomist(readconfig.getphelborole());

		PhelebotomistPage phelbo = new PhelebotomistPage(driver);
		phelbo.patientname(name);
		
		

	}

}
