package com.cts.revenueforecast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.revenueforecast.dao.DuplicateReportDAO;
import com.cts.revenueforecast.model.Base;

@Service
public class DuplicateReportService {

	@Autowired
	DuplicateReportDAO duplicateReportDAO;
	
	public List<Base> generateDuplicateReport(){
		return duplicateReportDAO.generateDuplicateReport();
		
	}
	
	public int updateBase(List<Base> baseToUpdate){
		return duplicateReportDAO.updateBase(baseToUpdate);
	}

	public DuplicateReportDAO getDuplicateReportDAO() {
		return duplicateReportDAO;
	}

	public void setDuplicateReportDAO(DuplicateReportDAO duplicateReportDAO) {
		this.duplicateReportDAO = duplicateReportDAO;
	}
	
	

}
