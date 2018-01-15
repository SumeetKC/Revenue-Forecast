package com.cts.revenueforecast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IActiveAssignmentsDAO;
import com.cts.revenueforecast.model.ActiveAssignments;

@Repository
public class ActiveAssignmentsDAOImpl implements IActiveAssignmentsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int storeActiveAssignments(final List<ActiveAssignments> aal) {
		
		//String sql = "insert into Active_Assignments values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'n') on duplicate key update status='o'";
		String sql = "insert into Active_Assignments values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		//jdbcTemplate.update("update active_assignments set status='r'");
		List<Object[]> inputs = new ArrayList<>();
		
		for (ActiveAssignments aa : aal) {
			inputs.add(aa.getObjectArray());
		}
		 
		return jdbcTemplate.batchUpdate(sql, inputs)[0];
		
	}

	@Override
	public List<ActiveAssignments> selectAllWorkAssignmentIds() {
		String selectQry = "select work_assignment_id, employee_id from Active_Assignments";
		
		return jdbcTemplate.query(selectQry, new RowMapper<ActiveAssignments>(){

			@Override
			public ActiveAssignments mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ActiveAssignments activeAssignments = new ActiveAssignments();
				activeAssignments.setWork_assignment_id(rs.getString(1));
				activeAssignments.setEmployee_id(rs.getString(2));
				return activeAssignments;
			}
			
		});
	}

	

}
