package Com.vtiger.practice;


	
	import java.io.IOException;
import java.util.Set;

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

	public class Testcase67 {

		private static SeleniumDriverUtility seleniumDriverUtility;

		public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
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
			
			long longTimeOut=jutil.StringToLong(timeout);	
			int randomnumber = jutil.getRandomNumber(1000);
			
			String admin = ExcelclassFileUtility.getDataFromExcel("createuser", 1, 0)+randomnumber;
			String admin1= ExcelclassFileUtility.getDataFromExcel("createuser", 1, 1);
			String admin2 = ExcelclassFileUtility.getDataFromExcel("createuser", 1, 1);
			String saigun = ExcelclassFileUtility.getDataFromExcel("createuser", 1, 2);
			String mail = ExcelclassFileUtility.getDataFromExcel("createuser", 1, 3);
			String nnn =ExcelclassFileUtility.getDataFromExcel("createuser", 1, 4);
			String salesman = ExcelclassFileUtility.getDataFromExcel("createuser", 1, 5);
			
	        WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
			SeleniumDriverUtility.navigateApp(url, driver);
			SeleniumDriverUtility.browsersetting(longTimeOut, driver);
			
	       driver.findElement(By.name("user_name")).sendKeys(username);
	       driver.findElement(By.name("user_password")).sendKeys(password);
	       driver.findElement(By.id("submitButton")).click();
	       
	       WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
	       seleniumDriverUtility.mousehoverOntheElement(ele,driver);
	       
	 		 driver.findElement(By.xpath("//a[.='CRM Settings']")).click();
	 		 driver.findElement(By.xpath("//a[@href='index.php?module=Administration&action=index&parenttab=Settings']")).click();
	 		 driver.findElement(By.xpath("//input[@title='New User [Alt+N]']")).click();
	 		 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(admin);
	 		 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(admin1);
	 		 driver.findElement(By.xpath("//input[@name='confirm_password']")).sendKeys(admin2);
	 		 driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(saigun);
	 		 driver.findElement(By.xpath("//input[@name='is_admin']")).click();
	 		 driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(mail);
	 	WebElement ele2 = driver.findElement(By.xpath("//select[@name='status']"));
	     seleniumDriverUtility.intializeSelect(ele2);
	 		driver.findElement(By.xpath("//select[@name='status']"));
	 		 driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(nnn);
	 		 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	 		 Thread.sleep(2000);
	 		String parentwindow = driver.getWindowHandle();
	 		Set<String> sessionId = driver.getWindowHandles();
	 		  for(String id:sessionId)
	 		  {
	 			  
	 			  driver.switchTo().window(id);
//	 			  if(driver.getCurrentUrl().contains("Users&action"));
//	 			  {
//	 				  
//	 				  break;
//	 			  }
	 		  }
	 		  
	 		  //Thread.sleep(3000);
	 		  driver.findElement(By.xpath("//a[.='Sales Man']")).click();
	 		  driver.switchTo().window(parentwindow);
	 		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 		  Thread.sleep(3000);
	 		  System.out.println("new user is created for user");
	 		  
	  WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 seleniumDriverUtility.mousehoverOntheElement(ele1, driver);
	 		  driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			 SeleniumDriverUtility.quitbrowser(driver);
		}
	}
	 		  
	 		  
	 		 
	 		 


