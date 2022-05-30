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

public class DataFetchExcelPropertiesProductCampaignTest {
	
	private static SeleniumDriverUtility seleniumDriverUtility;

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
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
		
		String productnname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
		String campaignname = ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1)+randomnumber;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		SeleniumDriverUtility.navigateApp(url, driver);
		SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.xpath("//a[.='Products']")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productnname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 WebElement moreLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
			seleniumDriverUtility.mousehoverOntheElement(moreLink, driver);	
			
				driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
				  Set<String> sessionId = driver.getWindowHandles();
				  for(String id:sessionId)
				  {
					  driver.switchTo().window(id);
					  if(driver.getTitle().contains("Products&action"));
					  {
						  break;
					  }
				  }
				  driver.findElement(By.id("search_txt")).sendKeys(productnname);
					 Thread.sleep(2000);
					  driver.findElement(By.xpath("//input[@name='search']")).click();
					  driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();	
	}
}
