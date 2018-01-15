package com.cts.revenueforecast.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.revenueforecast.dao.IActiveDAO;
import com.cts.revenueforecast.model.Active;

@Service
public class GenerateActiveSheetService {

	@Autowired
	private IActiveDAO iActiveDAO;
	static ArrayList<Integer> holidays = new ArrayList<Integer>();
	
	
public List<Active> generateActiveSheet() throws IOException{
		
		List<Active> baseData=iActiveDAO.readBaseData();
		
		List<Active> activeData= new ArrayList<Active>();
		
		
		
		Iterator<Active> baseDataIterator = baseData.iterator();
		
		while(baseDataIterator.hasNext()){
			Active active = new Active();
			active =(Active) baseDataIterator.next();
			//System.out.println(active.getWork_assignment_id());
			Calendar c = Calendar.getInstance();
			Calendar workerStartDate = Calendar.getInstance();
			Calendar workerEndDate = Calendar.getInstance();
			
			java.util.Date workerStart_Date = null;
			java.util.Date workerEnd_Date = null;
			try {
				if(null != active.getWorkerStartDate() || null!= active.getWorkerEndDate()){
				workerStart_Date= new SimpleDateFormat("yyyy-MM-dd").parse(active.getWorkerStartDate());
				workerEnd_Date =  new SimpleDateFormat("yyyy-MM-dd").parse(active.getWorkerEndDate());
				workerStartDate.setTime(workerStart_Date);
				workerEndDate.setTime(workerEnd_Date);
				int currentYear = c.get(Calendar.YEAR);
				Calendar monthStartDate;
				Calendar monthEndDate;
				int workingHoursPerDay=0;
				int workDays= 0;
				double rate = 0.0;
				for(int i=1;i<=12; i++)
				{
					monthStartDate  = Calendar.getInstance();
					monthStartDate.set(currentYear,i,1);
					monthEndDate = Calendar.getInstance();
					monthEndDate.set(currentYear, i,monthEndDate.getActualMaximum(Calendar.DAY_OF_MONTH));
					monthEndDate.getActualMaximum(Calendar.DAY_OF_MONTH);
					//System.out.println("monthEndDate ===========>"+monthEndDate);
					
					/*java.util.Date monthStartDt= (java.util.Date)monthEndDate.getTime();
					java.util.Date monthEndDt = (java.util.Date)monthEndDate.getTime();*/
					
					if(((monthStartDate.after(workerStartDate) || monthStartDate.equals(workerStartDate) )&& (monthStartDate.before(workerEndDate) || monthStartDate.equals(workerEndDate))) || 
							((monthEndDate.after(workerStartDate) || monthEndDate.equals(workerStartDate) )&& (monthEndDate.before(workerEndDate) || monthEndDate.equals(workerEndDate))) ){
						//
						switch(i){
						case 1:
							
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_jan() && !active.getPto_jan().equals("")){
							 workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_jan());
							active.setRevJan(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Jan(String.valueOf(workDays*workingHoursPerDay));
							}
							
							break;
						case 2:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_feb() && !active.getPto_feb().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_feb());
							active.setRevFeb(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Feb(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 3:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_mar() && !active.getPto_mar().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_mar());
							active.setRevMar(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Mar(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 4:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_apr() && !active.getPto_apr().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_apr());
							active.setRevApr(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Apr(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 5:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_may() && !active.getPto_may().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_may());
							active.setRevMay(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_May(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 6:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_june() && !active.getPto_june().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_june());
							active.setRevJun(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Jun(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 7:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_july() && !active.getPto_july().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_july());
							active.setRevJul(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Jul(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 8:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_aug() && !active.getPto_aug().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_aug());
							active.setRevAug(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Aug(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 9:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_sept() && !active.getPto_sept().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_sept());
							active.setRevSep(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Sep(String.valueOf(workDays*workingHoursPerDay));
							}
							break;
						case 10:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_oct() && !active.getPto_oct().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_oct());
							active.setRevOct(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Oct(String.valueOf(workDays));
							}
							break;
						case 11:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_nov() && !active.getPto_nov().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_nov());
							active.setRevNov(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Nov(String.valueOf(workDays));
							}
							break;
						case 12:
							workingHoursPerDay = Integer.parseInt(active.getBilling_hours_per_day());
							rate = Double.valueOf(active.getCurrent_Bill_Rate_ST_Hr());
							if(null!=active.getPto_dec() && !active.getPto_dec().equals("")){
								workDays = getWorkingDaysBetweenTwoDates(monthStartDate,monthEndDate) - Integer.parseInt(active.getPto_dec());
							active.setRevDec(String.valueOf(workingHoursPerDay * workDays * rate));
							active.setEffort_Dec(String.valueOf(workDays));
							}
							break;
						}
					}else if(workerEndDate.before(monthEndDate)){
						//in between worker start date and month end date
						//getWorkingDaysBetweenTwoDates(monthStartDt,monthEndDt) - Integer.parseInt(active.getPto_jan())
					}else{
						//revenue as 0
						active.setRevDec("0");
						active.setEffort_Dec("0");
					}
				}
				}else{
					active.setRevDec("0");
					active.setEffort_Dec("0");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			activeData.add(active);	
		}
		return activeData;
	}


public static int getWorkingDaysBetweenTwoDates(Calendar startDate, Calendar endDate) {  
	  
	    //startCal = Calendar.getInstance();  
	    //startCal.setTime(startDate);  
	    //endCal = Calendar.getInstance();  
	    //endCal.setTime(endDate);  
	    int workDays = 0;  

	    //Return 0 if start and end are the same  
	    if (startDate.getTimeInMillis() == endDate.getTimeInMillis()) {  
	        return 0;  
	    }  

	   /* if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {  
	        startCal.setTime(endDate);  
	        endCal.setTime(startDate);  
	    } */ 

	    do {  
	    	startDate.add(Calendar.DAY_OF_MONTH, 1);  
	        if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY   
	       && startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
	       && !holidays.contains((Integer) startDate.get(Calendar.DAY_OF_YEAR))
	       ) {  
	            ++workDays;  
	        }  
	    } while (startDate.getTimeInMillis() < endDate.getTimeInMillis());  

	    return workDays;
}
public IActiveDAO getiActiveDAO() {
	return iActiveDAO;
}



public void setiActiveDAO(IActiveDAO iActiveDAO) {
	this.iActiveDAO = iActiveDAO;
}


}
