package Com.vtiger.practice;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchexcelPropertiesOrganozationContacts {
	
	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		String organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
		String contactname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.xpath("//a[.='Organizations']")).click();
	 
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[.='Contacts']")).click();
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	// String contactname="prajwalpraju231997";
	 driver.findElement(By.name("lastname")).sendKeys(contactname);
	  driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	  Set<String> sessionId = driver.getWindowHandles();
	  for(String id:sessionId)
	  {
		  driver.switchTo().window(id);
		  if(driver.getTitle().contains("Accounts&action"));
		  {
			  break;
		  }
	  }
	// String orgaoname="prajwal199723381";
	  driver.findElement(By.id("search_txt")).sendKeys(organizationname);
	 Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@name='search']")).click();
	  driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	  
	  WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(atoradminist).build().perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']"));
		 driver.quit(); 
}	  
}