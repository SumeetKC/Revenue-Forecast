package com.cts.revenueforecast.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cts.revenueforecast.model.AllocationReport;
import com.cts.revenueforecast.model.EsaVsContractorId;
import com.cts.revenueforecast.model.HolidayList;
import com.cts.revenueforecast.model.JustWorkerNew;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.ProjectList;
import com.cts.revenueforecast.model.VacationDetails;
import com.cts.revenueforecast.service.FetchReportService;
import com.cts.revenueforecast.service.StoreFileService;

@Controller
public class ExcelUploadController {
	private Logger logger = Logger.getLogger(ExcelUploadController.class.getName());

	@Autowired
	StoreFileService storeFileService;
	@Autowired
	FetchReportService fetchReportService;

	@RequestMapping("/up_evcis")
	public ModelAndView storeEsaVsContratorId(@RequestParam CommonsMultipartFile Esa_Vs_Contractor_Id_file) {
		XSSFWorkbook wb = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(Esa_Vs_Contractor_Id_file.getInputStream());
			int result = storeFileService.storeEsaVsContractorIds(wb.getSheetAt(0));
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<EsaVsContractorId> list = fetchReportService.viewEsaVsContractorId();
				modelAndView.setViewName("esavscontractorsuccessview");
				modelAndView.addObject("list", list);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	@RequestMapping("/up_pls")
	public ModelAndView storeProjectList(@RequestParam CommonsMultipartFile Project_List_file) {
		XSSFWorkbook wb = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(Project_List_file.getInputStream());
			int result = storeFileService.storeProjectList(wb.getSheetAt(0));
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<ProjectList> list = fetchReportService.viewProjectList();
				modelAndView.setViewName("projectlistsuccessview");
				modelAndView.addObject("list", list);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	@RequestMapping("/up_swwds")
	public ModelAndView storeSowWiseWorkerData(@RequestParam CommonsMultipartFile Sow_Wise_Worker_Data_file) {
		XSSFWorkbook wb = null;
		List<String> differentEmployees;
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(Sow_Wise_Worker_Data_file.getInputStream());
			differentEmployees = storeFileService.storeSowWiseWorkerData(wb.getSheetAt(0));
			if (differentEmployees.contains("Format Wrong")) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				modelAndView.addObject("differentEmployees", differentEmployees);
				modelAndView.setViewName("showdifferenceinupload");
			}
			wb.close();
		} catch (Exception e) {
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message", "Some Error Occurred");
		}
		return modelAndView;
	}

	@RequestMapping("/up_vds")
	public ModelAndView storeVacationDetails(@RequestParam CommonsMultipartFile Vacation_Details_file) {
		XSSFWorkbook wb;
		ModelAndView modelAndView = new ModelAndView();

		try {
			wb = new XSSFWorkbook(Vacation_Details_file.getInputStream());
			int result = storeFileService.storeVacationDetails(wb.getSheetAt(0));
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<VacationDetails> list = fetchReportService.viewVacationDetails();
				modelAndView.setViewName("vacationsuccessview");
				modelAndView.addObject("list", list);
			}

			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	@RequestMapping("/up_jwns")
	public ModelAndView storeJustWorkerNew(@RequestParam CommonsMultipartFile Just_Worker_New_file) {
		XSSFWorkbook wb = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(Just_Worker_New_file.getInputStream());
			int result = storeFileService.storeJustWorkerNew(wb.getSheetAt(0));
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<JustWorkerNew> list = fetchReportService.viewJustWorkerNew();
				modelAndView.setViewName("justworkersuccessview");
				modelAndView.addObject("list", list);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	@RequestMapping("/up_hls")
	public ModelAndView storeHolidayList(@RequestParam CommonsMultipartFile Holiday_List_file) {

		XSSFWorkbook wb = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(Holiday_List_file.getInputStream());
			int result = storeFileService.storeHolidayList(wb.getSheetAt(0));
			modelAndView.setViewName("uploadsuccessview");
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<HolidayList> list = fetchReportService.viewHolidayList();
				/*
				 * modelAndView.setViewName("justworkersuccessview");
				 * modelAndView.addObject("list", list);
				 */
			}

			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	@RequestMapping("/up_ppms")
	public ModelAndView storePPMRecords(@RequestParam CommonsMultipartFile PPMRecord_file) {
		XSSFWorkbook wb = null;
		String month = "0";
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(PPMRecord_file.getInputStream());
			int result = storeFileService.storePPMRecord(wb.getSheetAt(0), month);
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<PPMRecord> list = fetchReportService.viewPPMRecord();
				modelAndView.setViewName("ppmsuccessview");
				modelAndView.addObject("list", list);
			}

			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	@RequestMapping("/up_ar")
	public ModelAndView storeAllocationReprot(@RequestParam CommonsMultipartFile allcoationReportFile) {
		XSSFWorkbook wb = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			wb = new XSSFWorkbook(allcoationReportFile.getInputStream());
			int result = storeFileService.storeAllocationReport(wb.getSheetAt(0));
			if (result != 0) {
				modelAndView.addObject("message",
						"File is not in the prescribed format. Please download the template for correct format");
				modelAndView.setViewName("error");
			} else {
				List<AllocationReport> list = fetchReportService.viewAllocationReport();
				modelAndView.setViewName("allocationsuccessview");
				modelAndView.addObject("list", list);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception Occured", e);
			return new ModelAndView("error", "message",
					"Some Error Occurred or File is not in the prescribed format. Please download the template for correct format");
		}
		return modelAndView;
	}

	/*
	 * @RequestMapping("/up_aas") public ModelAndView
	 * storeActiveAssignment(@RequestParam CommonsMultipartFile
	 * Active_Assignments_file) { XSSFWorkbook wb = null; ModelAndView
	 * modelAndView = new ModelAndView();
	 * modelAndView.setViewName("uploadsuccessview"); try { wb = new
	 * XSSFWorkbook(Active_Assignments_file.getInputStream()); int result =
	 * storeFileService.storeActiveAssignments(wb.getSheetAt(0)); if (result !=
	 * 0) { modelAndView.addObject("message",
	 * "File is not in the prescribed format. Please download the template for correct format"
	 * ); modelAndView.setViewName("error"); } wb.close(); } catch (Exception e)
	 * { // TODO: handle exception logger.error("Exception Occured", e); return
	 * new ModelAndView("error", "message", "Some Error Occurred"); } return
	 * modelAndView; }
	 */

	@RequestMapping("/view_up_aas")
	public String viewstoreActiveAssignment() {
		return "activeassignmentuploadformview";
	}

	@RequestMapping("/view_up_ar")
	public String viewstoreAllocationReport() {
		return "allocationreportuploadformview";
	}

	@RequestMapping("/view_up_evcis")
	public String viewstoreEsaVsContratorId() {
		return "esavscontractoriduploadformview";
	}

	/*
	 * @RequestMapping("/") public String viewstoreProjectList() { return
	 * "projectlistuploadformview"; }
	 */

	@RequestMapping("/view_up_swwds")
	public String viewstoreSowWiseWorkerData() {
		return "sowwiseworkerdatauploadformview";
	}

	@RequestMapping("/view_up_vds")
	public String viewstoreVacationDetails() {
		return "vacationdetailuploadformview";
	}

	@RequestMapping("/view_up_jwns")
	public String viewstoreJustWorkerNew() {
		return "justworkernewuploadformview";
	}

	@RequestMapping("/view_up_hls")
	public String viewstoreHolidayList() {
		return "holidaylistuploadformview";
	}

	@RequestMapping("/view_up_ppms")
	public String viewstorePPMSheet() {
		return "ppmrecorduploadformview";
	}

}
