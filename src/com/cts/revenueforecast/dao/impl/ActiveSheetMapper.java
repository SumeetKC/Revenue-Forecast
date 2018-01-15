package com.cts.revenueforecast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.cts.revenueforecast.model.Active;

public class ActiveSheetMapper extends MappingSqlQuery<Active>{

	@Override
	protected Active mapRow(ResultSet rs, int arg1) throws SQLException {
		Active active = new Active();
		active.setWork_assignment_id(rs.getString(1));
		active.setEmployee_id(rs.getString(2));
		active.setName(rs.getString(3));
		active.setProject(rs.getString(4));
		active.setDescription(rs.getString(5));
		active.setPm_id(rs.getString(6));
		active.setPm_name(rs.getString(7));
		active.setProjectId_EmpId(rs.getString(8));
		active.setCity(rs.getString(9));
		active.setCountry(rs.getString(10));
		active.setAssociate_billability(rs.getString(11));
		active.setAM(rs.getString(12));
		active.setSow(rs.getString(13));
		active.setSowNumber(rs.getString(14));
		active.setBilling_in(rs.getString(15));
		active.setCe_id(rs.getString(16));
		active.setContractor_number(rs.getString(17));
		active.setWorkerStartDate(rs.getString(18));
		active.setWorkerEndDate(rs.getString(19));
		active.setCurrent_Bill_Rate_ST_Hr(rs.getString(20));
		active.setPto_jan(rs.getString(21));
		active.setPto_feb(rs.getString(22));
		active.setPto_mar(rs.getString(23));
		active.setPto_apr(rs.getString(24));
		active.setPto_may(rs.getString(25));
		active.setPto_june(rs.getString(26));
		active.setPto_july(rs.getString(27));
		active.setPto_aug(rs.getString(28));
		active.setPto_sept(rs.getString(29));
		active.setPto_oct(rs.getString(30));
		active.setPto_nov(rs.getString(31));
		active.setPto_dec(rs.getString(32));
		active.setTotal_pto(rs.getString(33));
		active.setOnsite_Offshore(rs.getString(34));
		active.setBilling_hours_per_day(rs.getString(35));
		active.setDate_stamp(rs.getString(36));
		
		
		return active;
	}

	
}
