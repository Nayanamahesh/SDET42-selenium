package Com.vtiger.contacts.Tc31to35Test;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;

public class CreatecontactMandatoryCancel extends BaseClass {
	
	String contactlasttname;
	CreateNewContactPage createNewContactPage;
	ContactPage contactPage;
	ContactInformationPage contactInformationPage;
	@Test(groups= {"sanity","regression"})
	public void contactTestCase32() {
		
		contactlasttname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomNumber;

		 homepage.clickOnContact();
		 createNewContactPage=new CreateNewContactPage(driver);
		 createNewContactPage.clickOnCreateContact();
		 contactPage=new ContactPage(driver);
		 contactPage.enterContactNameTxtName(contactlasttname); 
		 contactPage.savecontact();
		 contactInformationPage=new ContactInformationPage(driver);
			
			 jutil.assertionThroughifCondition(contactInformationPage.getcontactName(),contactlasttname,"createmandatoryfield");	
	}
}