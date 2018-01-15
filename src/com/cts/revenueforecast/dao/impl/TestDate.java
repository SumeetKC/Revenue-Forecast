package com.cts.revenueforecast.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date = "03/10/2016";
		
		try {
			Date convertedDate;
			convertedDate = dateFormat.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(convertedDate);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			
			System.out.println(c.get(Calendar.DATE));
			int currentYear = c.get(Calendar.YEAR);
			
			Calendar sDate = null;
			Calendar eDate;
			for(int i=1;i<=12; i++)
			{
				sDate  = Calendar.getInstance();
				sDate.set(currentYear,i,1);
				eDate = Calendar.getInstance();
				eDate.set(currentYear, i,sDate.getActualMaximum(Calendar.DAY_OF_MONTH));
				System.out.println(sDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
