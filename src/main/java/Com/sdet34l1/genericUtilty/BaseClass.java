package Com.sdet34l1.genericUtilty;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Com.vtiger.objectRepository.HomePage;
import Com.vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;



/**
 * This class is  used to access covhjghjgmmon methods to all the scripts
 * @author user
 *This is the base class
 */
public class BaseClass {
	
    public int randomNumber;
	public String password;
	public  String username;
	public long longTimeOut;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homepage;
	public JavaClassFileUtility jutil;
	public String industryname;
	public String type;
	public String emailid;
	public SeleniumDriverUtility seleniumDriverUtility;
	
	/**
	 * this method is used to open the excel and property file and get the database connection
	 * @throws Encr      yptedDocumentException
	 * @throws IOException
	 */
	
	@BeforeSuite(groups="BaseClass")
	public void beforeSuite1Test() throws EncryptedDocumentException, IOException {
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);	
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
		
	}
	
	/**
	 *  this method is used to fetch the data from excelfile and property file,launch the browser and navigate the application 
	 *  create the instance for common object repository class
	 * @throws IOException
	 */
	//@Parameters("browser")
	@BeforeClass(groups="BaseClass")
	public void beforeClass1Test() throws IOException {
		jutil=new JavaClassFileUtility();
		SeleniumDriverUtility seleniumDriverUtility=new SeleniumDriverUtility();
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		 username =FileClassUtility.getDataFromPropertyFile("username");
		 password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		 industryname = FileClassUtility.getDataFromPropertyFile("industryname");
		 type = FileClassUtility.getDataFromPropertyFile("typename");
		 emailid =FileClassUtility.getDataFromPropertyFile("emailid");
		
		long longTimeOut=jutil.StringToLong(timeout);	
		 randomNumber = jutil.getRandomNumber(1000);
		
		
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
			break;
		}		
		}
		SeleniumDriverUtility.navigateApp(url, driver);
		SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		seleniumDriverUtility.explicitlyWait(driver, longTimeOut);
		loginPage=new LoginPage(driver);
		homepage=new HomePage(driver);
	}
	
	
	/**
	 * this method is used to perform login action
	 */
	@BeforeMethod(groups="BaseClass")
	public void beforeMethodTest() {
		loginPage.loginActions(username, password);
	}
	
	/**
	 * this method is used to perform logout action
	 */
	@AfterMethod(groups="BaseClass")
	public void afteraMethodTest() {
	homepage.signOut(driver);
	}
	
/**
 * this method is used to close the browser
 */
	@AfterClass(groups="BaseClass")
	public void afterClass1Test() {
		SeleniumDriverUtility.quitbrowser(driver);
	}
/**
 * this method is used to close the excel and database connection	
 */
	@AfterSuite(groups="BaseClass")
	public void afterSuite1Test() {
		ExcelclassFileUtility.closeExcel();	
	}
}
