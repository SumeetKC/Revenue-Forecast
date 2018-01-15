package com.cts.revenueforecast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IPPMRecordDAO;
import com.cts.revenueforecast.model.PPMRecord;

@Repository
public class PPMRecordDAOImpl implements IPPMRecordDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int storePPMRecord(List<PPMRecord> ppml,String month){
				List<Object[]> inputs = new ArrayList<>();
				//String sql = "insert into ppm_"+month+" values(?,?,?,?,?,?,?,?,?)";
				String sql = "insert into ppmsheet values(?,?,?,?,?,?,?,?,?,?)";
				for (PPMRecord ppmr : ppml) {
					inputs.add(ppmr.getObjectAsArray());
				}
				return jdbcTemplate.batchUpdate(sql, inputs)[0];
				
	}

	@Override
	public List<String> getDistinctContractorIds() {
		
		return jdbcTemplate.query("select distinct(ce_id) from base", new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}
			
		}) ;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List viewPPMRecord() {
		// TODO Auto-generated method stub
		String sql="select * from ppmsheet";
		return jdbcTemplate.queryForList(sql);
	}
}
