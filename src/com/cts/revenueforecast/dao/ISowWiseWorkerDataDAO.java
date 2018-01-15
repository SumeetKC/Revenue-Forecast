package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.SowWiseWorkerData;

public interface ISowWiseWorkerDataDAO {

	public List<String> storeSowWiseWorkerDataAndReturnDifference(List<SowWiseWorkerData> swwdl);

}
