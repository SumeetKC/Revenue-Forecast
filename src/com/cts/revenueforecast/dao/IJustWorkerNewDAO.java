package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.JustWorkerNew;

public interface IJustWorkerNewDAO {
	public int storeJustWorker(List<JustWorkerNew> jwnl);
	public List<JustWorkerNew> viewJustWorkerNew();

}



