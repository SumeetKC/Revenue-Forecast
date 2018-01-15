package com.cts.revenueforecast.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.revenueforecast.dao.IActiveAssignmentsDAO;
import com.cts.revenueforecast.dao.IAllocationReportDAO;
import com.cts.revenueforecast.dao.IEsaVsContractorIdDAO;
import com.cts.revenueforecast.dao.IHolidayListDAO;
import com.cts.revenueforecast.dao.IJustWorkerNewDAO;
import com.cts.revenueforecast.dao.IPPMRecordDAO;
import com.cts.revenueforecast.dao.IProjectListDAO;
import com.cts.revenueforecast.dao.ISowWiseWorkerDataDAO;
import com.cts.revenueforecast.dao.IVacationDetailsDAO;
import com.cts.revenueforecast.model.ActiveAssignments;
import com.cts.revenueforecast.model.AllocationReport;
import com.cts.revenueforecast.model.EsaVsContractorId;
import com.cts.revenueforecast.model.HolidayList;
import com.cts.revenueforecast.model.JustWorkerNew;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.ProjectList;
import com.cts.revenueforecast.model.SowWiseWorkerData;
import com.cts.revenueforecast.model.VacationDetails;

import static com.cts.revenueforecast.common.Constants.esaVsContractorHeader;
import static com.cts.revenueforecast.common.Constants.allocationHeader;
import static com.cts.revenueforecast.common.Constants.projectListHeader;
import static com.cts.revenueforecast.common.Constants.sowWorkerWiseHeader;
import static com.cts.revenueforecast.common.Constants.vacationDetailsHeader;
import static com.cts.revenueforecast.common.Constants.justWorkerNewHeader;
import static com.cts.revenueforecast.common.Constants.ppmSheetHeader;
import static com.cts.revenueforecast.common.Constants.holidayListHeader;;

@Service
public class StoreFileService {
	@Autowired
	private IActiveAssignmentsDAO iActiveAssignmentsDAO;
	@Autowired
	private IVacationDetailsDAO iVacationDetailsDAO;
	@Autowired
	private IEsaVsContractorIdDAO iEsaVsContractorIdDAO;
	@Autowired
	private IJustWorkerNewDAO iJustWorkerNewDAO;
	@Autowired
	private IProjectListDAO iProjectListDAO;
	@Autowired
	private ISowWiseWorkerDataDAO iSowWiseWorkerDataDAO;
	@Autowired
	private IHolidayListDAO iHolidayListDAO;
	@Autowired
	private IPPMRecordDAO ippmRecordDAO;
	@Autowired
	private IAllocationReportDAO iAllocationReportDAO;

	public int storeEsaVsContractorIds(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, esaVsContractorHeader);
		if (status) {
			iEsaVsContractorIdDAO.storeEsaVsContractorIds(parseExcel(sh, 6, EsaVsContractorId.class));
		} else {
			return -1;
		}
		return 0;
	}

	public int storeActiveAssignments(XSSFSheet sh) {

		List<ActiveAssignments> activeAssignmentsListExcel = parseExcel(sh, 31, ActiveAssignments.class);
		return iActiveAssignmentsDAO.storeActiveAssignments(activeAssignmentsListExcel);
	}

	public int storeVacationDetails(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, vacationDetailsHeader);
		if (status) {
			iVacationDetailsDAO.storeVacationDetails(parseExcel(sh, 15, VacationDetails.class));
		} else {
			return -1;
		}
		return 0;
	}

	public int storeAllocationReport(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, allocationHeader);
		if (status) {
			iAllocationReportDAO.storeAllocationReport(parseExcel(sh, 62, AllocationReport.class));
		} else {
			return -1;
		}
		return 0;
	}

	@SuppressWarnings({ "incomplete-switch", "deprecation" })
	public <T> List<T> parseExcel(XSSFSheet sh, int coloumns, Class<T> cls) {

		XSSFRow row;
		XSSFCell cell;
		String v = null;
		List<String> values = new ArrayList<>();
		List<T> list = new ArrayList<>();
		int nr = sh.getPhysicalNumberOfRows();
		for (int i = 1; i < nr; i++) {
			values.clear();
			row = sh.getRow(i);
			for (int j = 0; j < coloumns; j++) {
				cell = row.getCell(j);
				// v=(cell==null|cell.getCellTypeEnum()==CellType.BLANK)?"":cell.getStringCellValue();
				if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
					v = "";
				}

				else {
					switch (cell.getCellTypeEnum()) {
					case STRING:
						v = cell.getStringCellValue();
						if (j == 9) {
							if (String.valueOf(cell.getHyperlink()) != "null") {
								XSSFHyperlink v1 = cell.getHyperlink();
								v = String.valueOf(v1.getAddress()).replace("%40", "@");
								v = v.substring(7);
							}
						}

						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							v = dateFormat.format(cell.getDateCellValue());
						} else {

							/* v = (cell.getNumericCellValue()) + ""; */
							v = (int) (cell.getNumericCellValue()) + "";
						}
						break;
					case BOOLEAN:
						v = String.valueOf(cell.getBooleanCellValue());
						break;
					}
				}
				values.add(v);
			}
			T t = null;
			Constructor<T> c;
			try {
				c = cls.getConstructor(List.class);
				t = (T) (c.newInstance(values));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(t);
			list.add(t);
		}
		return list;
	}

	@SuppressWarnings({ "incomplete-switch", "deprecation" })
	public <T> List<T> parseExcelPPM(XSSFSheet sh, int coloumns, Class<T> cls) {

		XSSFRow row;
		XSSFCell cell;
		String v = null;
		List<String> values = new ArrayList<>();
		List<T> list = new ArrayList<>();
		int nr = sh.getPhysicalNumberOfRows();
		for (int i = 1; i < nr; i++) {
			values.clear();
			row = sh.getRow(i);
			for (int j = 0; j < coloumns; j++) {
				cell = row.getCell(j);
				// v=(cell==null|cell.getCellTypeEnum()==CellType.BLANK)?"":cell.getStringCellValue();
				if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
					v = "";
				}

				else {
					switch (cell.getCellTypeEnum()) {
					case STRING:
						v = cell.getStringCellValue();
						if (j == 9) {
							if (String.valueOf(cell.getHyperlink()) != "null") {
								XSSFHyperlink v1 = cell.getHyperlink();
								v = String.valueOf(v1.getAddress()).replace("%40", "@");
								v = v.substring(7);
							}
						}

						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							v = dateFormat.format(cell.getDateCellValue());
						} else {

							v = (cell.getNumericCellValue()) + "";
						}
						break;
					case BOOLEAN:
						v = String.valueOf(cell.getBooleanCellValue());
						break;
					}
				}
				values.add(v);
			}
			T t = null;
			Constructor<T> c;
			try {
				c = cls.getConstructor(List.class);
				t = (T) (c.newInstance(values));
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			list.add(t);
		}
		return list;
	}

	public int storeJustWorkerNew(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, justWorkerNewHeader);
		if (status) {
			iJustWorkerNewDAO.storeJustWorker(parseExcel(sh, 12, JustWorkerNew.class));
		} else {
			return -1;
		}
		return 0;
	}

	public List<String> storeSowWiseWorkerData(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, sowWorkerWiseHeader);
		List<String> difference=new ArrayList<>();
		if (status) {
			difference=iSowWiseWorkerDataDAO
					.storeSowWiseWorkerDataAndReturnDifference(parseExcelPPM(sh, 10, SowWiseWorkerData.class));
			return difference;
		}
		else
		{
			difference.add("Format Wrong");
			return difference;
		}
	   
	}

	public int storeProjectList(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, projectListHeader);
		if (status) {
			iProjectListDAO.storeProjectList(parseExcel(sh, 19, ProjectList.class));
		} else {
			return -1;
		}
		return 0;
	}

	public int storeHolidayList(XSSFSheet sh) {
		boolean status = checkHeadersExcel(sh, holidayListHeader);
		if (status) {
			iHolidayListDAO.storeHolidayList(parseExcel(sh, 19, HolidayList.class));
		} else {
			return -1;
		}
		return 0;
	}

	public int storePPMRecord(XSSFSheet sh, String month) {
		boolean status = checkHeadersExcel(sh, ppmSheetHeader);
		if (status) {
			List<String> baseContractorList = new ArrayList<String>();
			baseContractorList = ippmRecordDAO.getDistinctContractorIds();
			List<PPMRecord> ppmList = parseExcelPPM(sh, 10, PPMRecord.class);
			List<PPMRecord> newPpmList = new ArrayList<PPMRecord>();
			for (PPMRecord eachppmRecord : ppmList) {
				if (baseContractorList.contains(eachppmRecord.getResource_id())) {
					PPMRecord ppmRecord = new PPMRecord();
					ppmRecord.setProject_id(eachppmRecord.getProject_id());
					ppmRecord.setTask(eachppmRecord.getTask());
					ppmRecord.setTime_period(eachppmRecord.getTime_period());
					ppmRecord.setResource_name(eachppmRecord.getResource_name());
					ppmRecord.setResource_id(eachppmRecord.getResource_id());
					ppmRecord.setResource_manager(eachppmRecord.getResource_manager());
					ppmRecord.setTimesheet_status(eachppmRecord.getTimesheet_status());
					ppmRecord.setTimesheet_hours(eachppmRecord.getTimesheet_hours());
					ppmRecord.setSenior_executive(eachppmRecord.getSenior_executive());
					ppmRecord.setEmail(eachppmRecord.getEmail());
					newPpmList.add(ppmRecord);
				}
			}
			ippmRecordDAO.storePPMRecord(newPpmList, month);
		} else {
			return -1;
		}
		return 0;
	}

	public boolean checkHeadersExcel(XSSFSheet sh, String[] headers) {

		XSSFCell cell;
		XSSFRow row = sh.getRow(0);
		int columns =row.getPhysicalNumberOfCells();
		int length=headers.length;
		for (int i = 0; i < columns; i++) {
			cell = row.getCell(i);
			if (!(cell.getStringCellValue().equals(headers[i]))) {
				return false;
			}
		}
		return true;
	}

}
