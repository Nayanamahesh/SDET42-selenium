package Com.vtiger.practice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup {
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker")).click();
		String reqDate="25";
		String reqMonth="August";
		String reqYear="2023";
		int reqMonthOfYear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		
		int reqYearinNumber=Integer.parseInt(reqYear);
		String[] currentMonthYear = driver.findElement(By.className("ui-datepicker-year")).getText().split(" ");
		String currentMonth=currentMonthYear[0];
		int currentMonthOfYear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);
		String currentYear=currentMonthYear[1];
		int currentYearinNumber=Integer.parseInt(currentYear);
		
		while(reqYearinNumber<=currentYearinNumber || reqMonthOfYear>=currentMonthYear) {
			driver.findElement((By.xpath(currentYear));
		}
				
	}

}
