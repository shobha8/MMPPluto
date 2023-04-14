package org.iitworkforce.selenium.mmppluto.patienttests;

import org.iitwforce.selenium.mmppluto.lib.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTests extends BaseClass{
	
	@Test(description="TC_003 Validation of the Schedule appointment Booking",groups= {"Sanity","Regression"})
	public void validateBooking_TC001()
	{
		 
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@value='Register']")).click();
		driver.findElement(By.id("firstname")).sendKeys("AutomationQA123");
		String fName = driver.findElement(By.id("firstname")).getAttribute("value");
		System.out.println(fName);
		
		
		
	}

}
