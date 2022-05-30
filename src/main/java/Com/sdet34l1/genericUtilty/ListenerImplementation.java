package Com.sdet34l1.genericUtilty;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	
	@Override
	public void onStart(ITestContext context) {
	   System.out.println("on Start");
	   ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
	   spark.config().setDocumentTitle("DocumentTitle");
	   spark.config().setTheme(Theme.DARK);
	   spark.config().setReportName("ReportName");
	   
	   report=new ExtentReports();
	   report.attachReporter(spark);
	   report.setSystemInfo("Environment", "Testing Enviroment");
	   report.setSystemInfo("reporter name", "nayana");
	   report.setSystemInfo("platform", "windows 10 ");
	   report.setSystemInfo("unit testing tool", "TESTNG");
	   report.setSystemInfo("build management tool", "Maven");
	   report.setSystemInfo("Automation Tool", "Selenium");
	   
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("on Test Start");
		
		test=report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on Test Success");
		
		test.log(Status.PASS,result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
        System.out.println("on Test Failure");
        
        test.log(Status.PASS,result.getMethod().getMethodName()+" is Failed");
        test.log(Status.FAIL, result.getThrowable());
        
        SeleniumDriverUtility seleDriverUtility=new SeleniumDriverUtility();
        
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on Test Failed But Within Success Percentage");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on Finish");
		
	}

}
