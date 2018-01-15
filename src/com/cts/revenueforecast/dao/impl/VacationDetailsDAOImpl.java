package com.cts.revenueforecast.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IVacationDetailsDAO;
import com.cts.revenueforecast.model.VacationDetails;

@Repository
public class VacationDetailsDAOImpl implements IVacationDetailsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int storeVacationDetails(final List<VacationDetails> vdl) {

		String sql = "insert into Vacation_Details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object[]> inputs = new ArrayList<>();
		for (VacationDetails vd : vdl) {
			inputs.add(vd.getObjectArray());
		}
		return jdbcTemplate.batchUpdate(sql, inputs)[0];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List viewVacationDetails() {
		// TODO Auto-generated method stub
		String sql = "select * from vacation_details";
		return jdbcTemplate.queryForList(sql);
	}

}
