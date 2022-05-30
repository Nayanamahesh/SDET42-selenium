package Com.vtiger.practice;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CampaignInformationPage;
import Com.vtiger.objectRepository.CampaignPage;
import Com.vtiger.objectRepository.CreateNewCampaignPage;

public class CreateCampgainsPropertiesTest extends BaseClass
{
	String campaignname;
	CampaignPage campaignpage;
	CreateNewCampaignPage createnewcampaignpage;
	CampaignInformationPage campaigninformation;
	
	
	@Test
	public void createCampaignTest() {
		
	campaignname=ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1);	
	campaignpage=new CampaignPage(driver);
    createnewcampaignpage=new CreateNewCampaignPage(driver);
    campaigninformation=new CampaignInformationPage(driver);
    
    homepage.clickCampaign(driver);
    campaignpage.clickcraeteCampaign();
   
   createnewcampaignpage.enterCampaignName(campaignname);
   createnewcampaignpage.saveCampaign();
   jutil.assertionThroughifCondition(campaigninformation.getCampaignName(), campaignname,"campaign");
	}
}
		
		
		












//public static void main(String[] args) throws IOException, InterruptedException
//{
//	JavaClassFileUtility jutil=new JavaClassFileUtility();	
//	
//	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
//	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
////FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
////Properties property=new Properties();
////property.load(fis);
//	
//String url =FileClassUtility.getDataFromPropertyFile("url");
//String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
//String username =FileClassUtility.getDataFromPropertyFile("username");
//String password = FileClassUtility.getDataFromPropertyFile("password");
//String browser = FileClassUtility.getDataFromPropertyFile("browser");
//	
//long longTimeOut=jutil.StringToLong(timeout);	
//int randomnumber = jutil.getRandomNumber(1000);
//
//String campaignname = ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1)+randomnumber;
//WebDriver driver=null;
//switch (browser) {
//case "chrome":
//	WebDriverManager.chromedriver().setup();
//	driver=new ChromeDriver();
//	break;
//	
//case "firefox":
//	WebDriverManager.firefoxdriver().setup();
//	driver=new FirefoxDriver();
//	break;
//default: {
//	System.out.println("please specifiy the browser");
//	WebDriverManager.firefoxdriver().setup();
//	driver=new FirefoxDriver();
//}		
//}
//    SeleniumDriverUtility.navigateApp(url, driver);
//    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
//LoginPage loginpage=new LoginPage(driver);
//HomePage homepage=new HomePage(driver);
//loginpage.loginActions(username, password);