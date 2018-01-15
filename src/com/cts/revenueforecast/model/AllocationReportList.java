package com.cts.revenueforecast.model;

import java.util.List;

public class AllocationReportList {
	
	List<AllocationReport> allocationReportList;

	public List<AllocationReport> getAllocationReportList() {
		return allocationReportList;
	}

	public void setAllocationReportList(List<AllocationReport> allocationReportList) {
		this.allocationReportList = allocationReportList;
	}

	public AllocationReportList(List<AllocationReport> allocationReportList) {
		super();
		this.allocationReportList = allocationReportList;
	}

}
