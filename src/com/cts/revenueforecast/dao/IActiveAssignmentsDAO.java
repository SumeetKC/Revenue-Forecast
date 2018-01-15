package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.ActiveAssignments;

public interface IActiveAssignmentsDAO {

	int storeActiveAssignments(List<ActiveAssignments> aal);
	List<ActiveAssignments> selectAllWorkAssignmentIds();

}