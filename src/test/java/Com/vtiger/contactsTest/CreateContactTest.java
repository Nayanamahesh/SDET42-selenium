package Com.vtiger.contactsTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;

public class CreateContactTest extends BaseClass
{
	String contactlastname;
	CreateNewContactPage createnewcontact;
	ContactPage contactpagename;
	ContactInformationPage contactinfo;
	
	
	@Test(groups= {"sanity","regression"})
	public void createContactTest() {
	
	
	 String contactfirstname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomNumber;
	 createnewcontact=new CreateNewContactPage(driver);
	 homepage.clickOnContact();
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
     ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
     createnewcontact.clickOnCreateContact();
     contactpagename=new ContactPage(driver);
	 contactpagename.enterContactNameTxtName(contactfirstname);
	 contactpagename.savecontact();
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 4, "Contacts page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 5, "Tc Pass");
	 contactinfo=new ContactInformationPage(driver);
	 jutil.assertionThroughifCondition(contactinfo.getcontactName(),contactfirstname,"Contact");
	
		}
	}

	 
	 
	 
	 

	
	
	
	
