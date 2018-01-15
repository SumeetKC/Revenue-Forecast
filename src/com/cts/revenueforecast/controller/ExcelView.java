package com.cts.revenueforecast.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.cts.revenueforecast.model.PPMActuals;

public class ExcelView extends AbstractExcelView {
	private Logger logger=Logger.getLogger(ExcelView.class.getName());

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook arg1, HttpServletRequest arg2, HttpServletResponse arg3) 
	{
		try
		{
			HSSFWorkbook workbook = new HSSFWorkbook();
			List<PPMActuals> ppmActualsList = (List<PPMActuals>) model.get("ppmActualsList");
			HSSFSheet sheet = workbook.createSheet("ppmActualsList");
			// description,project,employee_id, onsite_offshore,name,am,
			// ce_id,pm_id,pm_name, ppmactuals
			HSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("project description");
			header.createCell(1).setCellValue("project");
			header.createCell(2).setCellValue("employee_id");
			header.createCell(3).setCellValue("onsite_offshore");
			header.createCell(4).setCellValue("name");
			header.createCell(5).setCellValue("am");
			header.createCell(6).setCellValue("ce_id");
			header.createCell(7).setCellValue("pm_id");
			header.createCell(8).setCellValue("pm_name");
			header.createCell(9).setCellValue("ppmactuals");

			int counter = 1;
			for (PPMActuals e : ppmActualsList) {
				HSSFRow row = sheet.createRow(counter++);
				row.createCell(0).setCellValue(e.getDescription());
				row.createCell(1).setCellValue(e.getProject());
			}
			
			workbook.close();
		
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occured", e);
			//return new ModelAndView("error", "message", "Some Error Occurred");
			
		}
	
	}
}
