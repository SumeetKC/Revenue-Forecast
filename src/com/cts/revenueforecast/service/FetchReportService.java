package com.cts.revenueforecast.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.revenueforecast.dao.IAllocationReportDAO;
import com.cts.revenueforecast.dao.IBaseDAO;
import com.cts.revenueforecast.dao.IEsaVsContractorIdDAO;
import com.cts.revenueforecast.dao.IHolidayListDAO;
import com.cts.revenueforecast.dao.IJustWorkerNewDAO;
import com.cts.revenueforecast.dao.IPPMRecordDAO;
import com.cts.revenueforecast.dao.IProjectListDAO;
import com.cts.revenueforecast.dao.IVacationDetailsDAO;
import com.cts.revenueforecast.model.AllocationReport;
import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.EsaVsContractorId;
import com.cts.revenueforecast.model.HolidayList;
import com.cts.revenueforecast.model.JustWorkerNew;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.ProjectForm;
import com.cts.revenueforecast.model.ProjectList;
import com.cts.revenueforecast.model.VacationDetails;

@Service
public class FetchReportService {

	@Autowired
	private IBaseDAO iBaseDAO;
	@Autowired
	private IAllocationReportDAO iAllocationReportDAO;
	@Autowired
	private IEsaVsContractorIdDAO iEsaVsContractorIdDAO;
	@Autowired
	private IHolidayListDAO iHolidayListDAO;
	@Autowired
	private IJustWorkerNewDAO iJustWorkerNewDAO;
	@Autowired
	private IPPMRecordDAO ippmRecordDAO;
	@Autowired
	private IProjectListDAO iProjectListDAO;
	@Autowired
	private IVacationDetailsDAO iVacationDetailsDAO;

	public Map<String, String> retrieveAllProjects() {
		return iBaseDAO.retrieveAllProjectIds();
	}

	public Map<String, String> retrieveAllPMs() {
		return iBaseDAO.retrieveAllProjectManagerIds();
	}

	public List<Base> retrieveBaseRecordsByProject(String pid) {
		return iBaseDAO.retrieveBaseRecordsByProjectId(pid);
	}

	public List<Base> retrieveBaseRecordsByPM(String pmid) {
		return iBaseDAO.retrieveBaseRecordsByProjectManagerId(pmid);
	}

	public List<ProjectForm> retrieveAllProject() {
		return iBaseDAO.retrieveAllProject();
	}

	public List<AllocationReport> viewAllocationReport() {
		return iAllocationReportDAO.viewAllocationReport();
	}

	public List<EsaVsContractorId> viewEsaVsContractorId() {
		return iEsaVsContractorIdDAO.viewEsaVsContractorId();
	}

	public List<ProjectList> viewProjectList() {
		return iProjectListDAO.viewProjectList();
	}

	public List<VacationDetails> viewVacationDetails() {
		return iVacationDetailsDAO.viewVacationDetails();
	}

	public List<JustWorkerNew> viewJustWorkerNew() {
		return iJustWorkerNewDAO.viewJustWorkerNew();
	}

	public List<HolidayList> viewHolidayList() {
		return iHolidayListDAO.viewHolidayList();
	}

	public List<PPMRecord> viewPPMRecord() {
		return ippmRecordDAO.viewPPMRecord();
	}

}
