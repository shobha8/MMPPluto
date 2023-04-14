package org.iitworkforce.selenium.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DateFunctionality {
	 
	public static void main(String[] args) {
		DateFunctionality d1 = new DateFunctionality();
		String result = d1.getFutureDate(20);
		System.out.println(result);
		}
	public String getFutureDate(int noofDays)
	{

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofDays);
		System.out.println("To Date:" + cal.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(cal.getTime()));
		
		sdf = new SimpleDateFormat("dd/MMM/yyyy");
		System.out.println(sdf.format(cal.getTime()));
		
		sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(sdf.format(cal.getTime()));

		sdf = new SimpleDateFormat("MMM/dd/yyyy");
		System.out.println(sdf.format(cal.getTime()));

		return cal.getTime().toString();
		
	}
	public String getFutureDate(int noofDays,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofDays);
		System.out.println("To Date:" + cal.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		System.out.println(sdf.format(cal.getTime()));
	    return cal.getTime().toString();
	}
}
//Calendar java.util.Calendar.getInstance()
//
//getInstance() is a static method
//Calendar is a Abstract class
//java.util is package
//Calendar object it is returning
//
//sdf = new SimpleDateFormat("dd/MMMM/yyyy");
//		String formattedDate = sdf.format(d);
//		System.out.println("Formatted Date   " + formattedDate);
/*

sdf = new SimpleDateFormat("dd/MM/yyyy");
System.out.println(sdf.format(cal.getTime()));
cal.add(Calendar.DATE,10);
System.out.println("From Date:" + cal.getTime());

sdf = new SimpleDateFormat("MM/dd/yyyy");
System.out.println(sdf.format(cal.getTime()));

sdf = new SimpleDateFormat("dd/MMM/yyyy");
System.out.println(sdf.format(cal.getTime()));*/
















