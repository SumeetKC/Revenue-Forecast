package com.cts.revenueforecast.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.model.Active;
import com.cts.revenueforecast.service.GenerateActiveSheetService;

@Controller
@SuppressWarnings("deprecation")
public class GenerateActiveSheetController {
	private Logger logger = Logger.getLogger(ProjectController.class.getName());

	@Autowired
	GenerateActiveSheetService generateActiveSheetService;
	static ArrayList<Integer> holidays = new ArrayList<Integer>();

	@RequestMapping(value = "/generateActiveSheet")
	public ModelAndView generateActiveSheet() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("generateActiveSheetView");
		List<Active> activeData = new ArrayList<Active>();
		try {
			activeData = generateActiveSheetService.generateActiveSheet();
			modelAndView.addObject("activeData", activeData);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			logger.error("Exception Occured", e1);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		Calendar cal = new GregorianCalendar();

		String strDate = "2017-04-14";

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = formatter.parse(strDate);
			cal.setTime(dt);
		} catch (ParseException e) {
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
			// e.printStackTrace();
		}

		holidays.add(cal.get(Calendar.DAY_OF_YEAR));
		
		Date startDate = new Date("1-Apr-2017");
		Date endDate = new Date("30-Apr-2017");
		System.out.println(getWorkingDaysBetweenTwoDates(startDate, endDate));

		return modelAndView;
	}

	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
		
		Calendar startCal;
		Calendar endCal;
		startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		int workDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		/*
		 * if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
		 * startCal.setTime(endDate); endCal.setTime(startDate); }
		 */

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
					&& !holidays.contains((Integer) startCal.get(Calendar.DAY_OF_YEAR))) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

		return workDays;
	}

}
