package Com.vtiger.practice;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.ContactInformationPage;
import Com.vtiger.objectRepository.ContactPage;
import Com.vtiger.objectRepository.CreateNewContactPage;

public class CreateContactsProperitesTest extends BaseClass{
	
	String contactlastname;
	CreateNewContactPage createnewcontact;
	ContactPage contactpagename;
	ContactInformationPage contcatinfo;
	
	
	
	@Test
	public void createContact() {
		
	
		contactlastname=ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 2)+randomNumber;
         createnewcontact=new CreateNewContactPage(driver);
         homepage.clickOnContact();
		 createnewcontact.clickOnCreateContact();
		 contactpagename=new ContactPage(driver);
		 contactpagename.enterContactNameTxtName(contactlastname);
		contactpagename.savecontact();
		contcatinfo=new ContactInformationPage(driver);
		
		 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactlastname,"Contact");
	
		  
		
	}
}
		
		
		
		
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		
//				public static void main(String[] args) throws IOException, InterruptedException {
//					JavaClassFileUtility jutil=new JavaClassFileUtility();	
//				
//					ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
//					FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
//				/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
//					Properties property = new Properties();
//					property.load(fis);*/
//					
//					String url =FileClassUtility.getDataFromPropertyFile("url");
//					String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
//					String username =FileClassUtility.getDataFromPropertyFile("username");
//					String password = FileClassUtility.getDataFromPropertyFile("password");
//					String browser = FileClassUtility.getDataFromPropertyFile("browser");
//							
//					
//					long longTimeOut=jutil.StringToLong(timeout);	
//					int randomnumber = jutil.getRandomNumber(1000);
//					
//					String contactfirstname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
//					String contactlastname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 2)+randomnumber;
//					
//					WebDriver driver=null;
//					switch (browser) {
//					case "chrome":
//						WebDriverManager.chromedriver().setup();
//						driver=new ChromeDriver();
//						break;
//						
//					case "firefox":
//						WebDriverManager.firefoxdriver().setup();
//						driver=new FirefoxDriver();
//						break;
//					default: {
//						System.out.println("please specifiy the browser");
//						WebDriverManager.firefoxdriver().setup();
//						driver=new FirefoxDriver();
//					}		
//					}
//					  SeleniumDriverUtility.navigateApp(url, driver);
//					    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
//					LoginPage loginpage=new LoginPage(driver);
//				    HomePage homepage=new HomePage(driver);
//				    loginpage.loginActions(username, password);	
//		
//		
		
//	/**	WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//        SeleniumDriverUtility.navigateApp(url, driver);	
//		SeleniumDriverUtility.browsersetting(longTimeOut, driver);
//
//	    driver.findElement(By.name("user_name")).sendKeys(username);
//		 driver.findElement(By.name("user_password")).sendKeys(password);
//		 driver.findElement(By.id("submitButton")).click();
//		 
//		 driver.findElement(By.linkText("Contacts")).click();
//		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		 
//		 driver.findElement(By.name("firstname")).sendKeys(contactfirstname);
//		 driver.findElement(By.name("lastname")).sendKeys(contactlastname);
//		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		 WebElement Actualfirstname = driver.findElement(By.id("dtlview_First Name"));
//		 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
//		 
//		/* if(Actualfirstname.getText().equalsIgnoreCase(firstname)&&Actualastname.getText().equalsIgnoreCase(lastname));
//		 {
//			System.out.println("contact created successfully");
//			 System.out.println("TC pass");
//		 }*/
//		/* jutil.assertionThroughifCondition(Actualfirstname.getText(), contactfirstname, "Contact name is created");
//		 jutil.assertionThroughifCondition(Actualastname.getText(), contactlastname, "Contacts name is created");
//		
//		 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
//		 /** Actions act=new Actions(driver);
//		 act.moveToElement(atoradminist).build().perform();*/
//		/* driver.findElement(By.xpath("//a[.='Sign Out']"));
//		 SeleniumDriverUtility.quitbrowser(driver);	*/
//	}
//}

