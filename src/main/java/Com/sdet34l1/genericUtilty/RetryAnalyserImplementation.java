package Com.sdet34l1.genericUtilty;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int maxRetry=4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxRetry)
		{
	    count++;
	    return true;
		}
		return false;
}
}
