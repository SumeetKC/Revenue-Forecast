package com.cts.revenueforecast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IActiveDAO;
import com.cts.revenueforecast.model.Active;

@Repository
public class ActiveDAOImpl implements IActiveDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Active> readBaseData() {
		String sql ="select work_assignment_id, employee_id, name, project, description, pm_id, pm_name,  city, country, associate_billability, AM, SoW, SoW_Number, Billing_in, ce_id, contractor_number, Worker_Start_Date, Worker_End_Date, Current_Bill_Rate_ST_Hr, pto_jan, pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec, total_pto, Onsite_Offshore, billing_hours_per_day, date_stamp,sowEndDate,sowBillRate from Base where truefalse = '"+true+"'";
		
		
		
				
				
		return jdbcTemplate.query(sql, new RowMapper<Active>(){

			@Override
			public Active mapRow(ResultSet rs, int arg1) throws SQLException {
				Active active = new Active();
				active.setWork_assignment_id(rs.getString(1));
				active.setEmployee_id(rs.getString(2));
				active.setName(rs.getString(3));
				active.setProject(rs.getString(4));
				active.setDescription(rs.getString(5));
				active.setPm_id(rs.getString(6));
				active.setPm_name(rs.getString(7));
				//active.setProjectId_EmpId(rs.getString(8));
				active.setCity(rs.getString(8));
				active.setCountry(rs.getString(9));
				active.setAssociate_billability(rs.getString(10));
				active.setAM(rs.getString(11));
				active.setSow(rs.getString(12));
				active.setSowNumber(rs.getString(13));
				active.setBilling_in(rs.getString(14));
				active.setCe_id(rs.getString(15));
				active.setContractor_number(rs.getString(16));
				active.setWorkerStartDate(rs.getString(17));
				active.setWorkerEndDate(rs.getString(18));
				active.setCurrent_Bill_Rate_ST_Hr(rs.getString(19));
				active.setPto_jan(rs.getString(20));
				active.setPto_feb(rs.getString(21));
				active.setPto_mar(rs.getString(22));
				active.setPto_apr(rs.getString(23));
				active.setPto_may(rs.getString(24));
				active.setPto_june(rs.getString(25));
				active.setPto_july(rs.getString(26));
				active.setPto_aug(rs.getString(27));
				active.setPto_sept(rs.getString(28));
				active.setPto_oct(rs.getString(29));
				active.setPto_nov(rs.getString(30));
				active.setPto_dec(rs.getString(31));
				active.setTotal_pto(rs.getString(32));
				active.setOnsite_Offshore(rs.getString(33));
				active.setBilling_hours_per_day(rs.getString(34));
				active.setDate_stamp(rs.getString(35));
				active.setSowEndDate(rs.getString(36));
				active.setSowBillRate(rs.getString(37));
				
				return active;
			}
			
		});
	}

}
