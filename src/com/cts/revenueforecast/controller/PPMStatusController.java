package com.cts.revenueforecast.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.dao.IBaseDAO;
import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.PPMActuals;
import com.cts.revenueforecast.model.PPMActualsList;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.User;
import com.cts.revenueforecast.service.PPMStatusService;

@Controller
@SessionAttributes(types = { PPMActualsList.class })
public class PPMStatusController {

	private Logger logger = Logger.getLogger(PPMStatusController.class.getName());

	@Autowired
	PPMStatusService ppmStatusService;

	@Autowired
	private IBaseDAO iBaseDAO;

	@RequestMapping(value = "/ppmtaskreport")
	public ModelAndView getPPMStatus() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("ppmtaskreport");
			List<PPMRecord> ppmTaskList = ppmStatusService.getPPMTaskReport();
			modelAndView.addObject("ppmTaskList", ppmTaskList);
		} catch (Exception e) {

			logger.error("Exception Occurred", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;
	}

	/*
	 * @RequestMapping(value="/ppmtaskforselectedmonth") public ModelAndView
	 * getPPMTaskForSelectedMonth(@RequestParam("month") String month){
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("selectedmonthforppmtask"); List<PPMRecord>
	 * ppmTaskList = ppmStatusService.getPPMTaskReport();
	 * modelAndView.addObject("ppmTaskList",ppmTaskList); return modelAndView; }
	 */
	@RequestMapping(value = "/ppmstatusreport")
	public ModelAndView getPPMStatusMonthly() {
		ModelAndView modelAndView = new ModelAndView();
		logger.info("Start of the GetPPMStatusMonthly");
		// modelAndView.setViewName("selectPPMMonthforStatus");
		try {
			modelAndView.setViewName("ppmstatusreportview");
			List<Base> baseList = ppmStatusService.getPPMStatusReport();
			modelAndView.addObject("baseList", baseList);
			List<PPMRecord> uniquetimePeriodList = new ArrayList<PPMRecord>();

			uniquetimePeriodList = ppmStatusService.getUniqueTimePeriod();
			Iterator<PPMRecord> i = uniquetimePeriodList.iterator();
			List<String> uniqueWeek = new ArrayList<String>();
			while (i.hasNext()) {
				PPMRecord ppmRecord = (PPMRecord) i.next();
				uniqueWeek.add(ppmRecord.getTime_period());
			}
			modelAndView.addObject("uniqueWeek", uniqueWeek);
		} catch (Exception e) {

			logger.error("Exception Occurred", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		logger.info("End of the GetPPMStatusMonthly");

		return modelAndView;
	}

	/*
	 * @RequestMapping(value="/ppmstatusforselectedmonth") public ModelAndView
	 * getPPMStatusForSelectedMonth(@RequestParam("month") String month){
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("selectedmonthforppmstatus"); List<Base>
	 * baseList = ppmStatusService.getPPMStatusReport(month);
	 * modelAndView.addObject("baseList",baseList); List<PPMRecord>
	 * uniquetimePeriodList = new ArrayList<PPMRecord>();
	 * 
	 * uniquetimePeriodList = ppmStatusService.getUniqueTimePeriod(month);
	 * Iterator<PPMRecord> i = uniquetimePeriodList.iterator(); List<String>
	 * uniqueWeek = new ArrayList<String>(); while(i.hasNext()){ PPMRecord
	 * ppmRecord =(PPMRecord) i.next();
	 * uniqueWeek.add(ppmRecord.getTime_period()); }
	 * modelAndView.addObject("uniqueWeek", uniqueWeek); return modelAndView; }
	 */

	@RequestMapping(value = "/ppmactuals")
	public ModelAndView getPPMActuals(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		// System.out.println("Inside PPM");
		logger.info("Start of the GetPPMActuals");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("ppmactuals");
			List<PPMActuals> ppmActuals = ppmStatusService.getPPMActuals();
			PPMActualsList ppmActualsList = new PPMActualsList();
			ppmActualsList.setPpmActuals(ppmActuals);
			modelAndView.addObject("ppmActualsList", ppmActualsList);
			Map<String, String> pms = iBaseDAO.retrieveAllProjectManagerIds();
			modelAndView.addObject("pms", pms);

			/*
			 * String pmId = session.getAttribute("selectedPM") != null ?
			 * session.getAttribute("selectedPM").toString() : null; Map<String,
			 * String> projDetails = ppmStatusService.getProjetctByPM(pmId);
			 * modelAndView.addObject("projDetails", projDetails);
			 * 
			 * String project = request.getParameter("project");
			 * session.setAttribute("selProject", project);
			 * 
			 * if (!(pmId == null || project == null)) { List<PPMActuals>
			 * ppmActuals = ppmStatusService.getPPMActualsByPMAndProject(pmId,
			 * project); PPMActualsList ppmActualsList = new PPMActualsList();
			 * ppmActualsList.setPpmActuals(ppmActuals);
			 * modelAndView.addObject("ppmActualsList", ppmActualsList);
			 * 
			 * 
			 * System.out.println(ppmActualsList.toString());
			 * System.out.println(ppmActualsList.getPpmActuals().toArray());
			 * 
			 * 
			 * }
			 */

		} catch (Exception e) {

			logger.error("Exception Occurred", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		logger.info("End of the GetPPMActuals");

		return modelAndView;

	}

	@RequestMapping(value = "/ppmactualsProjectPM")
	public ModelAndView getPPMActualsByProjectAndPm(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		// System.out.println("Inside PPM");
		logger.info("Start of the GetPPMActuals");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("ppmactuals");
			Map<String, String> pms = iBaseDAO.retrieveAllProjectManagerIds();
			modelAndView.addObject("pms", pms);

			String pmId = session.getAttribute("selectedPM") != null ? session.getAttribute("selectedPM").toString()
					: null;
			Map<String, String> projDetails = ppmStatusService.getProjetctByPM(pmId);
			modelAndView.addObject("projDetails", projDetails);

			String project = request.getParameter("project");
			session.setAttribute("selProject", project);

			if (!(pmId == null || project == null)) {
				List<PPMActuals> ppmActuals = ppmStatusService.getPPMActualsByPMAndProject(pmId, project);
				PPMActualsList ppmActualsList = new PPMActualsList();
				ppmActualsList.setPpmActuals(ppmActuals);
				modelAndView.addObject("ppmActualsList", ppmActualsList);
				/*
				 * System.out.println(ppmActualsList.toString());
				 * System.out.println(ppmActualsList.getPpmActuals().toArray());
				 */
			}
		} catch (Exception e) {
			logger.error("Exception Occurred", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		// List<PPMActuals> ppmActuals = ppmStatusService.getPPMActuals();
		// PPMActualsList ppmActualsList = new PPMActualsList();

		// ppmActualsList.setPpmActuals(ppmActuals);
		// modelAndView.addObject("ppmActualsList", ppmActualsList);

		logger.info("End of the GetPPMActuals");

		return modelAndView;
	}

	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) {

		logger.info("Start of ExportExcel");
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/download/");
		ppmStatusService.generatePPMActualsExcel(dataDirectory);
		Path file = Paths.get(dataDirectory, "PPMActuals.xlsx");

		if (Files.exists(file)) {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.addHeader("Content-Disposition", "attachment; filename=PPMActuals.xlsx");

			try {
				OutputStream out = response.getOutputStream();
				Files.copy(file, out);
				out.flush();
				Files.deleteIfExists(file);
			} catch (IOException ex) {
				logger.error("Exception Occurred", ex);
			}
		}
		logger.info("End of ExportExcel");
	}

	@RequestMapping(value = "/savePPMActuals", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView savePPMActuals(@ModelAttribute("ppmActualsList") PPMActualsList ppmActualsList, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		/*
		 * ModelAndView modelAndView = new ModelAndView();
		 * modelAndView.setViewName("ppmactuals"); Map<String,String> pms =
		 * iBaseDAO.retrieveAllProjectManagerIds();
		 * modelAndView.addObject("pms",pms); System.out.println("test");
		 * System.out.println(ppmActualsList);
		 */
		ModelAndView modelAndView = new ModelAndView();
		logger.info("Start of SavePpmActuals");
		try {
			List<PPMActuals> actuals = ppmActualsList.getPpmActuals();
			User user = (User) session.getAttribute("userValid");
			ppmStatusService.updatePPMActuals(actuals, user);
			modelAndView=getPPMActuals(request, response, session);
			//modelAndView.setViewName("ppmactuals");
			modelAndView.addObject("statusMessage", "Data Update Successful");
			
		} catch (Exception e) {

			logger.error("Exception Occurred", e);
		}
		//String message = "Data Updated Successfully";
		logger.info("End of SavePpmActuals");
		return modelAndView;
	}

	@RequestMapping(value = "/selectedpm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView selectProjectManagerwiseProjects(@ModelAttribute("pmdetails") PPMActuals pmDetails,
			HttpServletRequest request, HttpSession session) {
		logger.info("Start of SelectProjectManagerwiseProjects");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("ppmactuals");
			String pm = pmDetails.getPms();
			session.setAttribute("selectedPM", pm);

			modelAndView.addObject("pm", pm);
			Map<String, String> pms = iBaseDAO.retrieveAllProjectManagerIds();

			Map<String, String> projDetails = ppmStatusService.getProjetctByPM(pm);
			modelAndView.addObject("pms", pms);
			modelAndView.addObject("projDetails", projDetails);
		} catch (Exception e) {

			logger.error("Exception Occurred", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		logger.info("End of SelectProjectManagerwiseProjects");
		return modelAndView;
	}

}
