package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test1Test extends TestNgBasicPracticeTest {
	
	@Test(groups="sanity")
	public void test1()
	{
		Reporter.log("Testcase 1",true);

	}
	
@Test(groups="regression")
	public void test2()
	{
		Reporter.log("Testcase 2", true);
	}

@Test(groups= {"sanity","regression"})
public void test3()
{
	Reporter.log("Testcase 3", true);
}

@Test(groups="regression")
public void test4()
{
	Reporter.log("Testcase 4", true);
}

@Test(groups="sanity")
public void test5()
{
	Reporter.log("Testcase 5", true);
}




}
