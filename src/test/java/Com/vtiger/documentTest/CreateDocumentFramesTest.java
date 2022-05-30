package Com.vtiger.documentTest;

import org.testng.annotations.Test;

import Com.sdet34l1.genericUtilty.BaseClass;
import Com.sdet34l1.genericUtilty.ExcelclassFileUtility;
import Com.vtiger.objectRepository.CreateNewDocumentPage;
import Com.vtiger.objectRepository.DocumentInfoPage;
import Com.vtiger.objectRepository.DocumentPage;

public class CreateDocumentFramesTest extends BaseClass {
	
  String documentt;
  String documentpath;
  String documentdescription;
  CreateNewDocumentPage createDocument;
  DocumentPage documentName;
  DocumentInfoPage documentname;
  
  @Test(groups= {"sanity","regression"})
  public void createDocumentwithFrames() {
	  
	  
	documentt = ExcelclassFileUtility.getDataFromExcel("document", 1, 0)+randomNumber;
	documentpath = ExcelclassFileUtility.getDataFromExcel("document", 1, 1);
	documentdescription = ExcelclassFileUtility.getDataFromExcel("document", 1, 2)+randomNumber;
	
        homepage.clickOnDocument();
        createDocument=new CreateNewDocumentPage(driver);
	    createDocument.clickOnCreateDocument();
	     documentName=new DocumentPage(driver);
	    documentName.enterdocumentNameTxtName(documentt);
	    driver.switchTo().frame(0);
	    documentName.enterdocumentinfoTxt(documentdescription);
	    driver.switchTo().defaultContent();
	    documentName.clickOnBold();
	    documentName.clickOnItalic();
	    documentName.clickOnFiles(documentpath);
	    documentName.saveDocument();
	     documentname=new DocumentInfoPage(driver);
	    jutil.assertionThroughifCondition(documentname.getDocumentName(),documentt ,"Document");
		   
  }
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
