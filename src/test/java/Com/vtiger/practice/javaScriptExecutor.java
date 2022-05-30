package Com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.sdet34l1.genericUtilty.SeleniumDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 SeleniumDriverUtility.intializeJs(driver);
	 driver.manage().window().maximize();
	 SeleniumDriverUtility.navigateApplicationThroughJs("http://localhost:8888/");
	 SeleniumDriverUtility.enterDataThroughJs(driver.findElement(By.name("user_name")), "admin");
	 SeleniumDriverUtility.enterDataThroughJs(driver.findElement(By.name("user_password")), "admin"); 
	 SeleniumDriverUtility.clickThrouhgJs(driver.findElement(By.id("submitButton")));
	 Thread.sleep(2000);
	SeleniumDriverUtility.scroolTillElement(driver.findElement(By.xpath("//b[.=' Upcoming Activities']")));
	String fileName = new javaScriptExecutor().getClass().getName();
	SeleniumDriverUtility.takeScreenShot(fileName, driver);
	}
}
