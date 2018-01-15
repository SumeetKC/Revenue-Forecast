package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.PPMRecord;

public interface IPPMRecordDAO {
	public int storePPMRecord(List<PPMRecord> ppml,String month); 
	public List<String> getDistinctContractorIds();
	List<PPMRecord> viewPPMRecord();
}
