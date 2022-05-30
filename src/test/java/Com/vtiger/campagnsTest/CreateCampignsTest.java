package Com.vtiger.campagnsTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CampaignInformationPage;
import Com.vtiger.objectRepository.CampaignPage;
import Com.vtiger.objectRepository.CreateNewCampaignPage;

public class CreateCampignsTest extends BaseClass 
{
	
	String campaignname;
	CampaignPage campaignPage;
	CreateNewCampaignPage createnewcampaignpage;
	CampaignInformationPage campaigninformation;
	
	@Test(groups="sanity")
	public void createCampaignsTest1()  {
		
		campaignname = ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1);
		campaignPage=new CampaignPage(driver);
	createnewcampaignpage=new CreateNewCampaignPage(driver);
	     campaigninformation=new CampaignInformationPage(driver);
	     
	     homepage.clickCampaign(driver);
	     campaignPage.clickcraeteCampaign();
	   
	   createnewcampaignpage.enterCampaignName(campaignname);
	   createnewcampaignpage.saveCampaign();
	   jutil.assertionThroughifCondition(campaigninformation.getCampaignName(), campaignname,"campaign");
	   
	   
		}
}	
		
















		
		
