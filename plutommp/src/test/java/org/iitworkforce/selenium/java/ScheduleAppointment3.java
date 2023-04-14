package org.iitworkforce.selenium.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointment3 {

	@Test( description="US_004 Schedule Appointment",groups={"US_004","regression","sanity","patientmodule"})
	public void validateBooking() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
	
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		String expectedDoctorName ="Beth";
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+expectedDoctorName+"']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		
		String expectedDate=getFutureDate(60,"MMMM/d/yyyy");
		System.out.println(expectedDate);
		String dateArr[]=expectedDate.split("/");
		
		String expectedMonth = dateArr[0];//April
		String expectedDay = dateArr[1];//24
		String expectedYear = dateArr[2];//2023
		
		String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();//2023
		while(!(actualYear.equals(expectedYear)))
		{
			
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		

		String actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();//March
		while(!(actualMonth.equals(expectedMonth)))
		{
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}
		
		driver.findElement(By.linkText(expectedDay)).click();
		
		expectedDate=getFutureDate(60,"MM/dd/yyyy");
		
		Select timeSelect = new Select(driver.findElement(By.id("time")));
		String expectedTime="12Pm";
		timeSelect.selectByVisibleText(expectedTime);
		
		driver.findElement(By.id("ChangeHeatName")).click();
		Thread.sleep(2000);
		String expectedSym="Fever,Cold,Cough";
		driver.findElement(By.id("sym")).sendKeys(expectedSym);
		
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
		//Fetching the actual Values
		String actualDate =driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		String actualTime =driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
		String actualSym =driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
		String actualDoctor =driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
	
		//Assert.assertEquals(actualDoctor,expectedDoctorName);
		//Assert.assertEquals(actualTime,expectedTime);
		//Assert.assertEquals( actualSym,expectedSym);
		//Assert.assertEquals(actualDate,expectedDate);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTime,expectedTime);
		Thread.sleep(2000);
		sa.assertEquals( actualSym,expectedSym);
		sa.assertEquals(actualDoctor,expectedDoctorName);
		sa.assertEquals(actualDate,expectedDate);
		
		sa.assertAll();
		
		
		
	}
	
	
	
	
	
	public String getFutureDate(int noofdays,String pattern)
		{
	
			Calendar cal = 	Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, noofdays);
			
			Date d =cal.getTime();
			System.out.println("Current Date :" + d);
					
			SimpleDateFormat sdf = new SimpleDateFormat();
			String defaultformat = sdf.format(d);
			System.out.println(defaultformat);
			
			sdf = new SimpleDateFormat(pattern);
			String formatDate = sdf.format(d);
			System.out.println(formatDate);
			return formatDate;
		}
	
	
	
}
