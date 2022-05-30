package Com.vtiger.practice;

import java.io.IOException;

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

public class CreateProductPropertiesTest {
	
	private static SeleniumDriverUtility seleniumDriverUtility;

	public static void main(String[] args) throws IOException
	{
		JavaClassFileUtility jutil=new JavaClassFileUtility();
		WebDriver driver=null;
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
		/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
		Properties property=new Properties();
		property.load(fis);*/
		
		
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		String username =FileClassUtility.getDataFromPropertyFile("username");
		String password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		
		long longTimeOut=jutil.StringToLong(timeout);	
		int randomnumber = jutil.getRandomNumber(1000);

	
		String productname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		SeleniumDriverUtility.navigateApp(url, driver);
		SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.xpath("//a[.='Products']")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		 //String productname = "prajwal234";
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 WebElement product1 = driver.findElement(By.xpath("//td[@id='mouseArea_Product Name']"));
		 
		 jutil.assertionThroughifCondition(product1.getText(), productname, "Product name is created");
		/* if(product1.getText().equalsIgnoreCase(productname));
			{
				jutil.printStatement("Product name is created");
				jutil.printStatement("TC pass");
			}*/
				
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 seleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	 
	}
	}

