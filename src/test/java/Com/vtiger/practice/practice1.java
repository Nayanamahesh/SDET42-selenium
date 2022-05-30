package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class practice1 {
	
	@Test
	public static void test1()
	{
		Reporter.log("hai", true);
	}
	
	@Test
	public static void test2()
	{
		Reporter.log("hello", false);
	}
}
