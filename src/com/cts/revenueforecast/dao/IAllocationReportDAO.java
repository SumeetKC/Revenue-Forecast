package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.AllocationReport;
import com.cts.revenueforecast.model.AllocationReportList;

public interface IAllocationReportDAO {

	List<AllocationReport> storeAllocationReport(List<AllocationReport> allocationReportList);
	List<AllocationReport> viewAllocationReport();
}
