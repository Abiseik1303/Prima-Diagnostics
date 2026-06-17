package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.BulkInvoiceGeneration;
import com.TestProduct.PageObjects.ClientPaymentTracker;
import com.TestProduct.PageObjects.Invoice;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class InvoiceBulk extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();

	@Test(retryAnalyzer = Zretryclass.class)
	public void invoiceBulk() throws Exception {
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

		bp.client(readconfig.bulkclientcode());

		bp.ReferringDR(readconfig.getRefdr());

		bp.FileUpload();

		bp.AddTest(readconfig.getTest1());
		
		bp.Addbtn();
	
		bp.Generatebill();
		
		bp.back();

		BillingPage bp1 = new BillingPage(driver);
		bp1.LabQuickBilling();

		bp1.None();

		bp1.PatientSalutation(readconfig.getSalutation());
		
		String name1 = helper.generatedname();
		String age1 = helper.generatedage();
		String mobno1 = helper.generatedmobno();

		bp1.PatientName(name1);

		bp1.PatientAge(age1);

		bp1.PatientMobile(mobno1);
		
		bp1.PatientEmail(readconfig.getEmail());

		bp1.client(readconfig.bulkclientcode());

		bp1.ReferringDR(readconfig.getRefdr());

		bp1.FileUpload();

		bp1.AddTest(readconfig.getAutoTest1());

		bp1.Addbtn();
		
		bp1.scrolldown1();

		bp1.Generatebill();
		
		bp1.back();
		
		RolesPage r = new RolesPage(driver);
		r.CreditController(readconfig.getCreditcontroller());
		
		Invoice i = new Invoice(driver);
		i.schedules();
		
		BulkInvoiceGeneration b = new BulkInvoiceGeneration(driver);
		b.bulkinvoice1(readconfig.Bussinesstype(), readconfig.bulkclientname());
		
		ClientPaymentTracker c = new ClientPaymentTracker(driver);
		c.tracker();
		
		c.bulk(readconfig.bulkclientname(), readconfig.Showpdf());
		
	}
	
}