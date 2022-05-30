package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class TestbaseeeeeeeeeeeTest {
	
	@BeforeSuite()
	public void Beforesuite() {
		Reporter.log("beforesuite", true);
		
	}
	
	
	public void BeforeClass() {
		Reporter.log("BeforeClass",true);
	}
	
	
	

}
