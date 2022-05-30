package Com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.FileClassUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;
import Com.sdet34l1.genericUtilty.JavaClassFileUtility;
import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase68 {
	

	public static void main(String[] args) throws IOException
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
       
       driver.findElement(By.xpath("//a[.='Contacts']")).click();
     driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=CustomView&parenttab=Marketing']")).click();
  
       
       

}
}
