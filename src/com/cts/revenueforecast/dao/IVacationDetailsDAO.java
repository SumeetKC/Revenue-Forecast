package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.VacationDetails;

public interface IVacationDetailsDAO {

	int storeVacationDetails(List<VacationDetails> vdl);
	public List<VacationDetails> viewVacationDetails();

}