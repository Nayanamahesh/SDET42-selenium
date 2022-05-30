package Com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.sdet34l1.genericUtilty.IconstantClassPath;

public class TestNgPractice1Test {
	
	
	@Test(dataProvider = "loginData")
	public void practice1Test(String username, String password) {
		Reporter.log(username+"    "+password, true);
	}
	
	@DataProvider
	public Object[][] loginData() throws EncryptedDocumentException, IOException{
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
		return ExcelclassFileUtility.getMultipleDataFromExcel("multipledata");
	}

}
