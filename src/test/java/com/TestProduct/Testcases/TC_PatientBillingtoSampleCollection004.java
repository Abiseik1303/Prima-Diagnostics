
package com.TestProduct.Testcases;


import com.TestProduct.Utility.HelperClass;
import org.testng.annotations.Test;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LabTechnicianPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PathologistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.SampleCollectionPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.Closebill;
import com.TestProduct.Utility.Readconfig;

public class TC_PatientBillingtoSampleCollection004 extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();

	@Test
	public void SampleCollected() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
		

		Thread.sleep(2000);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);

		rsp.selectRole(readconfig.getRole1());
		

		Thread.sleep(3000);

		rsp.selectLocation(readconfig.getLocation());
	

		Thread.sleep(5000);

		BillingPage bp = new BillingPage(driver);
		Thread.sleep(2000);
		bp.RegistrationBilling();
		
		bp.None();

		bp.PatientSalutation(readconfig.getSalutation());
		

		String name = helper.generatedname();
		String age = helper.generatedage();
		String mobno = helper.generatedmobno();

		bp.PatientName(name);
		

		bp.PatientAge(age);
	

		bp.PatientMobile(mobno);
		

		bp.AddTest(readconfig.getTest1());
		

		bp.Addbtn();
		
		
		Thread.sleep(1000);
		bp.scrolldown1();
		
		Thread.sleep(1000);
		bp.AddPayment();
		
		Thread.sleep(1000);
		bp.scrolldown1();

		bp.Generatebill();
		

		Thread.sleep(4000);

		SampleCollectionPage SampleCollect = new SampleCollectionPage(driver);
		SampleCollect.Samplestatus(readconfig.getStatus());

	

		SampleCollect.GenerateWorkorder();
		
		
		Thread.sleep(3000);
		bp.back();

		Thread.sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='Panel5']")))).getText();

		
		SampleCollect.billprintclose();
		
		Thread.sleep(2000);
		bp.VisitSearch();
		
		Thread.sleep(2000);
		bp.Visitsearch(name);
		
		String visitnumber = Closebill.visit();
	

		Thread.sleep(5000);
		RolesPage rolepage = new RolesPage(driver);
		rolepage.LabTech(readconfig.getLabTechrole());
	
		
			
        LabTechnicianPage labpage = new LabTechnicianPage(driver);
		labpage.TestDetails(name, readconfig.gettestvalue(),visitnumber);

		RolesPage rolepage1 = new RolesPage(driver);
		rolepage1.Pathologist(readconfig.getPathorole());
		

		PathologistPage pathpage = new PathologistPage(driver);
		pathpage.Approval(name);
		pathpage.InvestigationReport(name);
	    pathpage.pdfs();

	}


}