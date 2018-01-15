package com.cts.revenueforecast.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.cts.revenueforecast.dao.IBaseDAO;
import com.cts.revenueforecast.model.Base;

@Service
public class GenerateFileService {

	@Autowired
	private IBaseDAO iBaseDAO;
	/*
	 * @SuppressWarnings("deprecation") //public String generateBase(String
	 * path,String datestamp) throws IOException{ public List<Base>
	 * generateBase(String path,String datestamp) throws IOException{
	 * 
	 * List<Base> brl=iBaseDAO.retrieveBaseDetailsList(datestamp); String[]
	 * headers = { "Work Assignment ID", "Associate ID", "Associate Name",
	 * "Project ID", "Project Name", "PM ID", "PM Name", "ProjectId_EmpId",
	 * "City", "Country", "Associate Billability", "CE ID", "Contractor number",
	 * "AM", "SoW", "SoW Number", "Billing in", "Worker Start Date",
	 * "Worker End Date", "Current Bill Rate [ST/Hr]", "PTO Jan", "PTO Feb",
	 * "PTO Mar", "PTO Apr", "PTO May", "PTO Jun", "PTO Jul", "PTO Aug",
	 * "PTO Sep", "PTO Oct", "PTO Nov", "PTO Dec", "Total PTO",
	 * "Onsite/Offshore", "Billing Hours per day", "Date Stamp"}; int c=0; for
	 * (Base b : brl) { System.out.println(b); c++; } System.out.println(c);
	 * XSSFWorkbook wb=new XSSFWorkbook(); XSSFSheet sh=wb.createSheet("Base");
	 * XSSFRow row; XSSFCell cell;
	 * 
	 * CellStyle style=null,removed= wb.createCellStyle();
	 * removed.setFillForegroundColor(IndexedColors.RED.getIndex());
	 * removed.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 * 
	 * CellStyle latest = wb.createCellStyle();
	 * latest.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	 * latest.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 * 
	 * Base bb; Object[] b; int nr=brl.size(); row=sh.createRow(0); for(int
	 * i=0;i<headers.length;i++){ cell=row.createCell(i);
	 * cell.setCellValue(headers[i]); } for(int i=1;i<nr;i++){
	 * row=sh.createRow(i); bb=brl.get(i-1); if(bb.getStatus().equals("r")){
	 * style=removed; }else if(bb.getStatus().equals("n")){ style=latest; }else
	 * if(bb.getStatus().equals("o")) { style=row.getRowStyle(); }
	 * b=bb.getAsObjectArray(); for(int j=0;j<b.length;j++){
	 * cell=row.createCell(j); cell.setCellValue((String)b[j]);
	 * cell.setCellStyle(style); } } System.out.println(path+"\\");
	 * FileOutputStream fileOut = new FileOutputStream(path+"\\"+"Base.xlsx");
	 * wb.write(fileOut); wb.close(); fileOut.close();
	 * 
	 * //return path+"\\"+"Base.xlsx"; return brl;
	 * 
	 * }
	 */

	@SuppressWarnings("deprecation")
	public String generateBaseExcel(String path) {
		List<Base> baseDetails = iBaseDAO.retrieveBaseDetailsListForExcel();

		/*
		 * String[] headers = { "Project Name", "Project Id", "Emp. id",
		 * "On/Off", "Name", "Acct Manager", "Ce_id", "PM Id", "PM Name",
		 * "StartDate", "EndDate", "End date by PM", "Sow Role", "SoW",
		 * "Ct. Bill Rate", "Rate by PM", "PPM Hrs", "PPM hours by PM" };
		 */

		String[] headers = { "Project Name", "Project Id", "Associate Id", "Onsite/Offshore", "Associate Name",
				"Practice Name", "City", "Start Date", "End Date", "Bill Rate", "Sow Worker Role", "Sow Number",
				"PTO Jan", "PTO Feb", "PTO Mar", "PTO Apr", "PTO May", "PTO June", "PTO July", "PTO Aug", "PTO Sept",
				"PTO Oct", "PTO Nov", "PTO Dec", "Expr1", "CE ID", "AM", "PM Name", "Actuals" };

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Base Sheet");
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
		sh.setColumnWidth(19, 3000);
		sh.setColumnWidth(20, 3000);
		sh.setColumnWidth(21, 3000);
		sh.setColumnWidth(22, 3000);
		sh.setColumnWidth(23, 3000);
		sh.setColumnWidth(24, 3000);
		sh.setColumnWidth(25, 3000);
		sh.setColumnWidth(26, 3000);
		sh.setColumnWidth(27, 3000);
		sh.setColumnWidth(28, 3000);
		sh.setColumnWidth(29, 3000);
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

		Base base;
		Object[] b;
		int nr = baseDetails.size();
		row = sh.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(borderstyle);

			cell.setCellValue(headers[i]);

		}
		for (int i = 1; i < nr; i++) {
			row = sh.createRow(i);
			base = baseDetails.get(i - 1);

			b = base.getAsObjectArrayBase();
			for (int j = 0; j < b.length; j++) {
				cell = row.createCell(j);
				cell.setCellStyle(style);
			/*	if(j==8)
				{
					
				}
				if(j==9)
				{
					
				}*/
				cell.setCellValue((String) b[j]);
			}
		}
		System.out.println(path + "\\");
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(path + "\\" + "BaseSheet.xlsx");
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

		return path + "\\" + "BaseSheet.xlsx";

	}

	public List<Base> generateBase() throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String datestamp = dateFormat.format(date);
		List<Base> baseList = iBaseDAO.retrieveBaseDetailsList(datestamp);
		return baseList;
	}

	public Map<String, String> generateNewAddedEmployees() throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String datestamp = dateFormat.format(date);;
		Map<String, String> newEmployees = iBaseDAO.retrieveNewAddedEmployees(datestamp);
		return newEmployees;
	}

	/*
	 * public List<String> generateTerminatedEmployees(String path, String
	 * datestamp) throws IOException {
	 * 
	 * List<String> brl = iBaseDAO.retrieveTerminatedEmployees(datestamp);
	 * return brl; }
	 */
	public List<Base> viewBaseDetailsList() {

		return iBaseDAO.viewBaseDetailsList();

	}

	public int movebasetohistory() {
		return iBaseDAO.movebasetohistory();

	}

}
