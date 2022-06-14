package Com.vtiger.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Gridpractice {
	
	RemoteWebDriver driver;
	@Parameters("Browser")
	@BeforeClass
	
	public void gridprac(String Browser) throws MalformedURLException {
		URL url = new URL("http://localhost:4444");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(Browser.equals("chrome"))
		{
			cap.setPlatform(Platform.WINDOWS);
            cap.setBrowserName("chrome");
		}
		else
			if(Browser.equals("firefox"))
			{
				cap.setPlatform(Platform.WINDOWS);
	            cap.setBrowserName("firefox");	
			}
		
		 driver = new RemoteWebDriver(url, cap);
	}
	@Test
	public void remoteexecution()
	{
		driver.get("http://gmail.com");
	}
}		
	
	
	