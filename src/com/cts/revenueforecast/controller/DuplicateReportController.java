package com.cts.revenueforecast.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.BaseForm;
import com.cts.revenueforecast.service.DuplicateReportService;

@Controller
@SessionAttributes
public class DuplicateReportController {

	private Logger logger = Logger.getLogger(DuplicateReportController.class.getName());

	@Autowired
	DuplicateReportService duplicateReportService;

	@RequestMapping(value = "/duplicatereport")
	public ModelAndView generateDuplicateReport() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("duplicateReportView");
			List<Base> baseList = duplicateReportService.generateDuplicateReport();
			modelAndView.addObject("baseList", baseList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/saveduplicatereport", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView saveBaseData(@ModelAttribute("baseForm") BaseForm baseForm, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("saveduplicate");
			List<Base> updatedBase = baseForm.getBaseList();
			List<Base> baseToUpdate = new ArrayList<Base>();
			for (Base eachBaseList : updatedBase) {
				if (eachBaseList.isChecked()) {

					Base baseToBeUpdated = new Base();
					baseToBeUpdated.setWorkerEndDate(eachBaseList.getWorkerEndDate());
					baseToBeUpdated.setEmployee_id(eachBaseList.getEmployee_id());
					baseToBeUpdated.setWork_assignment_id(eachBaseList.getWork_assignment_id());
					baseToBeUpdated.setProject(eachBaseList.getProject());
					baseToUpdate.add(baseToBeUpdated);
				}
			}
			int count = 0;
			if (baseToUpdate.size() != 0) {
				count = duplicateReportService.updateBase(baseToUpdate);
				if (count != 0) {

					modelAndView.addObject("dupreport", count + " rows updated in to Base table..");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;
	}

}
