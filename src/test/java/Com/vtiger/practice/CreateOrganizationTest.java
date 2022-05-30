package Com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import Com.vtiger.objectRepository.CreateNewOrganizationPage;
import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import Com.vtiger.objectRepository.OrganizationInfoPage;
import Com.vtiger.objectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	
	private static SeleniumDriverUtility SeleniumDriverUtility;

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		JavaClassFileUtility jutil=new JavaClassFileUtility();
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
		
		
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		String username =FileClassUtility.getDataFromPropertyFile("username");
		String password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		
		long longTimeOut =jutil.StringToLong(timeout);
	   int randomnumber  = jutil.getRandomNumber(1000);
		
		String organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
		
		WebDriver driver=null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default: {
			System.out.println("please specifiy the browser");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}		
		}

		SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	    
	    LoginPage loginPage=new LoginPage(driver);
	    loginPage.loginActions(username, password);
	    HomePage homePage=new HomePage(driver);
	    homePage.clickOnOrganzations();
	    
	    CreateNewOrganizationPage createneworganization=new CreateNewOrganizationPage(driver);
	    createneworganization.clickOnCreateOrganization();
	    OrganizationPage organizationpage=new OrganizationPage(driver);
	    organizationpage.enterOrganizationNameTxtName(organizationname);
	    organizationpage.saveOrganization();
	    OrganizationInfoPage orgoInfo=new OrganizationInfoPage(driver);
	    Thread.sleep(2000);
	    homePage.signOut(driver);
	    SeleniumDriverUtility.quitbrowser(driver);
	}
}
	    
	    
	  /* boolean p = ele.isDisplayed();
	 
	 if(p)
	 {
		 System.out.println("Element is displayed");
	 }
	 else
	 {
		 System.out.println("Element is not displayed");
	 }
	    
	 jutil.assertionThroughifCondition(orgoInfo.getOrganizationName(),organizationname,"Organization");
	 WebElement organization1=  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 SeleniumDriverUtility.mousehoverOntheElement(organization1, driver);
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);
	 
	Actions act=new Actions(driver);
	 act.moveToElement(ele1).build().perform();
	 ele1.click();*/
	


