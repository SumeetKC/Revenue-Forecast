package com.cts.revenueforecast.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.ISowWiseWorkerDataDAO;
import com.cts.revenueforecast.model.SowWiseWorkerData;

@Repository
public class SowWiseWorkerDataDAOImpl implements ISowWiseWorkerDataDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<String> storeSowWiseWorkerDataAndReturnDifference(final List<SowWiseWorkerData> swwdl) {
		// TODO Auto-generated method stub
		
		String truncateSowTable="truncate sow_wise_worker_data";
		jdbcTemplate.update(truncateSowTable);
		
		List<Object[]> inputs = new ArrayList<>();
		String sql = "insert into sow_wise_worker_data values(?,?,?,?,?,?,?,?,?,?)";
		for (SowWiseWorkerData sow_Wise_Worker_data : swwdl) {
			inputs.add(sow_Wise_Worker_data.getObjectAsArray());
		}
		jdbcTemplate.batchUpdate(sql, inputs);
		
		String finddifference="SELECT B.employee_id "
				+ " from sow_wise_worker_data SOW right join base B on B.contractor_number=SOW.Contractor_ID"
				+ " where B.Worker_End_Date <> SOW.Worker_End_Date or B.Current_Bill_Rate_ST_Hr!=SOW.Current_Bill_Rate_ST_Hr";
		return jdbcTemplate.queryForList(finddifference,String.class);
		
		
		
	}
}
