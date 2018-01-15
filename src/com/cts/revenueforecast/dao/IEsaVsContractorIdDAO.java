package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.EsaVsContractorId;

public interface IEsaVsContractorIdDAO {

	int storeEsaVsContractorIds(List<EsaVsContractorId> vdl);
	List<EsaVsContractorId> viewEsaVsContractorId();

}