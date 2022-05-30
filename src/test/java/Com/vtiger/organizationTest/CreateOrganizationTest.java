package Com.vtiger.organizationTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CreateNewOrganizationPage;
import Com.vtiger.objectRepository.OrganizationInfoPage;
import Com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	
	String organizationname;
	CreateNewOrganizationPage createneworganization;
	OrganizationPage organizationpage;
	OrganizationInfoPage organizationInfoPage ;
	
	@Test(groups= "regression")
	public void createorganization() {
		
	     organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 8, 0)+randomNumber;
	     
	     homepage.clickOnOrganzations();
	    createneworganization=new CreateNewOrganizationPage(driver);
	    createneworganization.clickOnCreateOrganization();
	    organizationpage=new OrganizationPage(driver);
	    organizationpage.enterOrganizationNameTxtName(organizationname);
	    organizationpage.saveOrganization();
	    organizationInfoPage=new OrganizationInfoPage(driver);
	     jutil.assertionThroughifCondition(organizationInfoPage.getOrganizationName(), organizationname, "Organization");
	   
	}
}
	    
	  