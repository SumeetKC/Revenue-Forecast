package com.cts.revenueforecast.dao;

import java.util.List;
import java.util.Map;

import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.PPMActuals;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.User;

public interface IPPMStatusDAO {
	public List<PPMRecord> getPPMTaskReport();

	public List<Base> getDistinctContractorIds();

	public List<PPMRecord> getUniqueTimePeriod();

	public List<PPMActuals> getPPMActuals();

	public List<PPMRecord> getPPMStatusReport();

	public List<PPMActuals> updatePPMActuals(List<PPMActuals> ppmActualsList, User user);

	public Map<String, String> getProjetctByPM(String pmId);

	public List<PPMActuals> getPPMActualsByPMAndProject(String pmId, String pId);

}
