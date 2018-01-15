package com.cts.revenueforecast.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IEsaVsContractorIdDAO;
import com.cts.revenueforecast.model.EsaVsContractorId;

@Repository
public class EsaVsContractorIdDAOImpl implements IEsaVsContractorIdDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int storeEsaVsContractorIds(final List<EsaVsContractorId> evcil) {
		String sql = "insert into Esa_Vs_Contractor_Id values(?,?,?,?,?,?)";
		List<Object[]> inputs = new ArrayList<>();
		for (EsaVsContractorId evci : evcil) {
			inputs.add(evci.getObjectArray());
		}
		return jdbcTemplate.batchUpdate(sql, inputs)[0];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List viewEsaVsContractorId() {
		// TODO Auto-generated method stub
		String sql="select * from esa_vs_contractor_id";
		return jdbcTemplate.queryForList(sql);
	}
}
