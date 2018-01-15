package com.cts.revenueforecast.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.revenueforecast.dao.IPPMStatusDAO;
import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.PPMActuals;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.User;

@Service
public class PPMStatusService {

	@Autowired
	IPPMStatusDAO iPPMStatusDAO;

	public List<PPMRecord> getPPMTaskReport() {

		return iPPMStatusDAO.getPPMTaskReport();
	}

	public List<Base> getPPMStatusReport() {
		// reusing the getPPMTaskReport to get all the tasks
		List<PPMRecord> ppmTaskList = iPPMStatusDAO.getPPMStatusReport();
		List<Base> contractorList = new ArrayList<Base>();
		List<PPMRecord> uniquetimePeriodList = new ArrayList<PPMRecord>();
		contractorList = iPPMStatusDAO.getDistinctContractorIds();
		uniquetimePeriodList = getUniqueTimePeriod();
		Map<String, Base> associateDetailsMap = new TreeMap<String, Base>();
		Map<String, String> timePeriodMap = null;
		int totalHours = 0;
		List<Base> finalBaseList = new ArrayList<Base>();
		for (Base eachContractor : contractorList) {
			Base finalBase = new Base();
			totalHours = 0;
			if (null != eachContractor.getCe_id()) {
				timePeriodMap = new TreeMap<String, String>();
				for (PPMRecord eachWeek : uniquetimePeriodList) {
					for (PPMRecord eachPPMTask : ppmTaskList) {
						if (eachContractor.getCe_id().equals(eachPPMTask.getResource_id())) {
							if (eachWeek.getTime_period().equals(eachPPMTask.getTime_period())) {
								// if(eachPPMTask.getTimesheet_status().equals("Approved")
								// ||
								// eachPPMTask.getTimesheet_status().equals("Submitted")){
								if (eachPPMTask.getTimesheet_hours().length() != 0) {
									totalHours = (int) (totalHours + Double.valueOf(eachPPMTask.getTimesheet_hours()));
									/*
									 * finalBase.setName(eachPPMTask.
									 * getResource_name());
									 */

									finalBase.setProject(eachPPMTask.getProject_id());
									finalBase.setEmail(eachPPMTask.getEmail());

								}
								// }

							}
						}

					}

					timePeriodMap.put(eachWeek.getTime_period(), String.valueOf(totalHours));
					totalHours = 0;
				}
				eachContractor.setTimePeriodMap(timePeriodMap);

				associateDetailsMap.put(eachContractor.getCe_id(), eachContractor);
				finalBase.setCe_id(eachContractor.getCe_id());
				finalBase.setEmployee_id(eachContractor.getEmployee_id());
				finalBase.setProject(eachContractor.getProject());
				finalBase.setPm_id(eachContractor.getPm_id());
				finalBase.setPm_name(eachContractor.getPm_name());
				finalBase.setName(eachContractor.getName());
				finalBase.setWorkerEndDate(eachContractor.getWorkerEndDate());
				finalBase.setTimePeriodMap(timePeriodMap);
				finalBaseList.add(finalBase);
			}
		}

		return finalBaseList;
	}

	// To get the unique time period
	public List<PPMRecord> getUniqueTimePeriod() {

		return iPPMStatusDAO.getUniqueTimePeriod();
	}

	public List<PPMActuals> getPPMActuals() {
		return iPPMStatusDAO.getPPMActuals();
	}

	public List<PPMActuals> getPPMActualsByPMAndProject(String pmId, String pId) {
		return iPPMStatusDAO.getPPMActualsByPMAndProject(pmId, pId);
	}

	@SuppressWarnings("deprecation")
	public String generatePPMActualsExcel(String path) {
		List<PPMActuals> ppmActuals = iPPMStatusDAO.getPPMActuals();

		String[] headers = { "Project Name", "Project Id", "Emp. id", "On/Off", "Name", "Acct Manager", "Ce_id",
				"PM Id", "PM Name", "StartDate", "EndDate", "End date by PM", "Sow Role", "SoW", "Ct. Bill Rate",
				"Rate by PM", "PPM Hrs", "PPM hours by PM" };
		int c = 0;
		for (PPMActuals b : ppmActuals) {
			System.out.println(b);
			c++;
		}
		System.out.println(c);
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("PPMActuals");
		sh.setColumnWidth(0, 5000);
		sh.setColumnWidth(1, 2500);
		sh.setColumnWidth(2, 2500);
		sh.setColumnWidth(3, 2500);
		sh.setColumnWidth(4, 4500);
		sh.setColumnWidth(5, 2000);
		sh.setColumnWidth(6, 3000);
		sh.setColumnWidth(7, 3000);
		sh.setColumnWidth(8, 5000);
		sh.setColumnWidth(9, 3000);
		sh.setColumnWidth(10, 3000);
		sh.setColumnWidth(11, 3000);
		sh.setColumnWidth(12, 10000);
		sh.setColumnWidth(13, 3000);
		sh.setColumnWidth(14, 3000);
		sh.setColumnWidth(15, 3000);
		sh.setColumnWidth(16, 3000);
		sh.setColumnWidth(17, 3000);
		sh.setColumnWidth(18, 3000);
		XSSFRow row;
		XSSFCell cell;

		XSSFCellStyle borderstyle = wb.createCellStyle();
		borderstyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		borderstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		borderstyle.setBorderBottom(CellStyle.BORDER_THIN);
		borderstyle.setBorderLeft(CellStyle.BORDER_THIN);
		borderstyle.setBorderRight(CellStyle.BORDER_THIN);
		borderstyle.setBorderTop(CellStyle.BORDER_THIN);

		XSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);

		PPMActuals bb;
		Object[] b;
		int nr = ppmActuals.size();
		row = sh.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(borderstyle);

			cell.setCellValue(headers[i]);

		}
		for (int i = 1; i < nr; i++) {
			row = sh.createRow(i);
			bb = ppmActuals.get(i - 1);

			b = bb.getAsObjectArray();
			for (int j = 0; j < b.length; j++) {
				cell = row.createCell(j);
				cell.setCellStyle(style);
				cell.setCellValue((String) b[j]);
			}
		}
		System.out.println(path + "\\");
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path + "\\" + "PPMActuals.xlsx");
			wb.write(fileOut);
			wb.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path + "\\" + "PPMActuals.xlsx";

	}

	public void updatePPMActuals(List<PPMActuals> ppmActualsList, User user) {
		iPPMStatusDAO.updatePPMActuals(ppmActualsList, user);
	}

	public Map<String, String> getProjetctByPM(String pmId) {
		return iPPMStatusDAO.getProjetctByPM(pmId);
	}
}
