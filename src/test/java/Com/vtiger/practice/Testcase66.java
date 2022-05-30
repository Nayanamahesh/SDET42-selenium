package Com.vtiger.practice;


	import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class Testcase66 {
		
		private static SeleniumDriverUtility seleniumDriverUtility;

		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
			JavaClassFileUtility jutil=new JavaClassFileUtility();
			WebDriver driver=null;
			ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
			FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
			
			String url =FileClassUtility.getDataFromPropertyFile("url");
			String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
			String username =FileClassUtility.getDataFromPropertyFile("username");
			String password = FileClassUtility.getDataFromPropertyFile("password");
			String browser = FileClassUtility.getDataFromPropertyFile("browser");
			String salesman=FileClassUtility.getDataFromPropertyFile("rolename");
			
			long longTimeOut=jutil.StringToLong(timeout);	
			int randomnumber = jutil.getRandomNumber(1000);
			
			
	        WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
			SeleniumDriverUtility.navigateApp(url, driver);
			SeleniumDriverUtility.browsersetting(longTimeOut, driver);
			
			
	       driver.findElement(By.name("user_name")).sendKeys(username);
	       driver.findElement(By.name("user_password")).sendKeys(password);
	       driver.findElement(By.id("submitButton")).click();
	       
	       WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
	      seleniumDriverUtility.mousehoverOntheElement(ele, driver);
	      
			 driver.findElement(By.xpath("//a[.='CRM Settings']")).click();
			driver.findElement(By.xpath("//a[@href='index.php?module=Settings&action=listroles&parenttab=Settings']")).click();
			 WebElement ele1=driver.findElement(By.xpath("//a[.='Sales Man']"));
			 seleniumDriverUtility.mousehoverOntheElement(ele1, driver);
			 driver.findElement(By.xpath("//a[@href='index.php?module=Settings&action=createrole&parenttab=Settings&parent=H5']")).click();
			 driver.findElement(By.xpath("//input[@name='roleName']")).sendKeys(salesman);
			 System.out.println("new role is created for user");
			 
			 WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 
			 seleniumDriverUtility.mousehoverOntheElement(ele2, driver);
			 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			 SeleniumDriverUtility.quitbrowser(driver);	
	}
	}












