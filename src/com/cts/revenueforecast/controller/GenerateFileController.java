package com.cts.revenueforecast.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.service.FetchReportService;
import com.cts.revenueforecast.service.GenerateFileService;

@Controller
public class GenerateFileController {

	private Logger logger = Logger.getLogger(GenerateFileController.class.getName());

	@Autowired
	private GenerateFileService generateFileService;
	@Autowired
	private FetchReportService fetchReportService;

	@RequestMapping(value = "/generatenewemployees")
	public ModelAndView newEmployees(HttpServletRequest request, HttpServletResponse response,
			@RequestHeader String referer) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("newEmployeeView");
		try {

			Map<String, String> newEmployees = generateFileService.generateNewAddedEmployees();
			modelAndView.addObject("newEmployees", newEmployees);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", e.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "/generatebasefile")
	public ModelAndView generateFinalBase() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<Base> baseList = generateFileService.generateBase();
			modelAndView.addObject("baseList", baseList);
			modelAndView.setViewName("viewbasereporttabularview");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/exportbase")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) {

		logger.info("Start of Export To Excel Base");
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/download/");
		generateFileService.generateBaseExcel(dataDirectory);
		Path file = Paths.get(dataDirectory, "BaseSheet.xlsx");

		if (Files.exists(file)) {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.addHeader("Content-Disposition", "attachment; filename=BaseSheet.xlsx");

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

	@RequestMapping("/downloadtemplate")
	public void generateTemplate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("name") String fname) {

		String filename = "";
		try {
			switch (fname) {
			case "allocation":
				filename = "Allocation_Report.xlsx";
				break;
			case "esavscontractor":
				filename = "ESA_Vs_Contractor_id.xlsx";
				break;
			case "justworkernew":
				filename = "Just_Worker_New.xlsx";
				break;
			case "ppm":
				filename = "PPM.xlsx";
				break;
			case "projectlist":
				filename = "Project_List.xlsx";
				break;
			case "sowwiseworkerdata":
				filename = "SoW_wise_worker_data.xlsx";
				break;
			case "vacationdetails":
				filename="VACATION_DETAILS.xlsx";
				break;

			}

			String filePath = request.getServletContext().getRealPath("/Templates");
			Path file = Paths.get(filePath, filename);

			if (Files.exists(file)) {
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

				OutputStream out = response.getOutputStream();
				Files.copy(file, out);
				out.flush();
			}

		} catch (IOException ex) {
			logger.error("Exception Occurred", ex);
		}

	}

	/*
	 * @RequestMapping(value = "/saveContractor") public ModelAndView
	 * saveContractor(@ModelAttribute("employeemappingform")
	 * EmployeeContractorMap employeeContractorMap) { ModelAndView modelAndView
	 * = new ModelAndView();
	 * System.out.println(employeeContractorMap.getEmpContratMap()); return
	 * modelAndView; }
	 */

	/*
	 * @RequestMapping(value = "/generateterminated") public ModelAndView
	 * terminatedEmployees(HttpServletRequest request, HttpServletResponse
	 * response, // @PathVariable("fileName") String fileName,
	 * 
	 * @RequestHeader String referer, @RequestParam("datestamp") String
	 * datestamp) {
	 * 
	 * ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("viewbasereporttabularview"); try { List<String>
	 * baseList = generateFileService.generateTerminatedEmployees("D:\\",
	 * datestamp);
	 * 
	 * modelAndView.addObject("baseList", baseList); } catch (Exception e) { //
	 * TODO Auto-generated catch block // e.printStackTrace();
	 * logger.error("Exception Occured", e); return new ModelAndView("error",
	 * "message", e.getMessage()); } return modelAndView;
	 * 
	 * }
	 */
	@RequestMapping(value = "/viewbase")
	public ModelAndView viewbase(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewbasereporttabularview");
		try {
			List<Base> baseList = generateFileService.viewBaseDetailsList();
			modelAndView.addObject("baseList", baseList);

		} catch (Exception e) {
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;

	}

	@RequestMapping("/generatebase")
	public ModelAndView generateBaseView() {
		return new ModelAndView("generatebase");
	}

	@RequestMapping("/movebase")
	public ModelAndView moveBase() {
		if (generateFileService.movebasetohistory() == 0) {
			return new ModelAndView("errorview");
		} else {
			return new ModelAndView("uploadsuccessview");
		}

	}

	@RequestMapping("/fetchreportbypm")
	public ModelAndView reportByPMId() {

		return new ModelAndView("viewreportbypmview", "pms", fetchReportService.retrieveAllPMs());
	}

	@RequestMapping("/fetchreportbyproject")
	public ModelAndView reportByProjectId() {
		/*
		 * Map<String, String> m=fetchReportService.retrieveAllProjects();
		 * System.out.println(m);
		 */
		return new ModelAndView("viewreportbyprojectview", "projects", fetchReportService.retrieveAllProjects());
	}

	@RequestMapping("/showreportbypm")
	public ModelAndView viewreportByPMId(@RequestParam("pms") String pmid) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("viewreportbypmview");
			modelAndView.addObject("pmid", pmid);
			modelAndView.addObject("pms", fetchReportService.retrieveAllPMs());
			modelAndView.addObject("basedata", fetchReportService.retrieveBaseRecordsByPM(pmid));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;// new
							// ModelAndView("viewreportbypmview","basedata",fetchReportService.retrieveBaseRecordsByPM(pmid));
	}

	@RequestMapping("/showreportbyproject")
	public ModelAndView showreportByProjectId(@RequestParam("projects") String pid) {

		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("viewreportbyprojectview");
			modelAndView.addObject("pid", pid);
			modelAndView.addObject("projects", fetchReportService.retrieveAllProjects());
			modelAndView.addObject("basedata", fetchReportService.retrieveBaseRecordsByProject(pid));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}

		return modelAndView;// new
							// ModelAndView("","basedata",fetchReportService.retrieveBaseRecordsByProject(pid));
	}
}
