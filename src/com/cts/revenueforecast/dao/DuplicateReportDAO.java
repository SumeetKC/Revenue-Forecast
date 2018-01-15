package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.Base;

public interface DuplicateReportDAO {

	public List<Base> generateDuplicateReport();
	public int updateBase(List<Base> baseToUpdate);
}
