package com.cts.revenueforecast.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IJustWorkerNewDAO;
import com.cts.revenueforecast.model.JustWorkerNew;

@Repository
public class JustWorkerNewDAOImpl implements IJustWorkerNewDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public int storeJustWorker(List<JustWorkerNew> jwnl) {
		// TODO Auto-generated method stub
		List<Object[]> inputs = new ArrayList<>();
		String sql = "insert into just_worker_new values(?,?,?,?,?,?,?,?,?,?,?,?)";
		for (JustWorkerNew just_Worker_New : jwnl) {
			inputs.add(just_Worker_New.getObjectAsArray());
		}

		return jdbcTemplate.batchUpdate(sql, inputs)[0];
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List viewJustWorkerNew() {
		// TODO Auto-generated method stub
		String sql = "select * from just_worker_new";
		return jdbcTemplate.queryForList(sql);
	}


}
