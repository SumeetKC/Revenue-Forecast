package com.cts.revenueforecast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.DuplicateReportDAO;
import com.cts.revenueforecast.model.Base;


@Repository
public class DuplicateReportDAOImpl implements DuplicateReportDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Base> generateDuplicateReport() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("Select employee_id,work_assignment_id,project,SoW, ce_id,city, Worker_Start_Date,Worker_End_Date,Current_Bill_Rate_ST_Hr, pm_id,pm_name,SoW_Number,name,description from base where employee_id in(SELECT employee_id FROM revenue_forecast.base group by employee_id having count(employee_id)>1) order by employee_id asc", new RowMapper<Base>(){

			@Override
			public Base mapRow(ResultSet rs, int arg1) throws SQLException {
				Base base = new Base();
				
				base.setEmployee_id(rs.getString(1));
				base.setWork_assignment_id(rs.getString(2));
				base.setProject(rs.getString(3));
				base.setSow(rs.getString(4));
				base.setCe_id(rs.getString(5));
				base.setCity(rs.getString(6));
				base.setWorkerStartDate(rs.getString(7));
				base.setWorkerEndDate(rs.getString(8));
				base.setCurrent_Bill_Rate_ST_Hr(rs.getString(9));
				base.setPm_id(rs.getString(10));
				base.setPm_name(rs.getString(11));
				base.setSowNumber(rs.getString(12));
				base.setName(rs.getString(13));
				base.setDescription(rs.getString(14));
				return base;
			}
			
		});
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int updateBase(List<Base> baseToUpdate) {
		
		//update Basedataextended set Startdate = ?, Enddate = ?, updatedbyId = ?, updatedbyName = ? where AssociateID = ? and ProjectID = ?";
		
		List<Object[]> objList = new ArrayList<Object[]>();
		int[] updateCounts = null;
		for (Base base : baseToUpdate) {
			objList.add(new Object[]{
					base.getWorkerEndDate(),
					
					base.getEmployee_id(),
					base.getWork_assignment_id(),
					base.getProject()
										
			});
			updateCounts=  jdbcTemplate.batchUpdate("update base set Worker_End_Date = ? where  employee_id = ? and work_assignment_id = ? and project = ?", objList);
			 
		}
		return updateCounts.length;
		
	}

	

}
