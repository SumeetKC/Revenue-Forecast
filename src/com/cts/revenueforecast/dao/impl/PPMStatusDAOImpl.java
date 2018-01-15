package com.cts.revenueforecast.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IPPMStatusDAO;
import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.PPMActuals;
import com.cts.revenueforecast.model.PPMRecord;
import com.cts.revenueforecast.model.User;

@Repository
public class PPMStatusDAOImpl implements IPPMStatusDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<PPMRecord> getPPMTaskReport() {

		return jdbcTemplate.query(
				"select project_id, task, time_period, resource_name, resource_id, resource_manager, timesheet_status, timesheet_hours, senior_executive,email from revenue_forecast.ppmsheet",
				new RowMapper<PPMRecord>() {

					@Override
					public PPMRecord mapRow(ResultSet rs, int arg1) throws SQLException {
						PPMRecord ppmRecord = new PPMRecord();
						ppmRecord.setProject_id(rs.getString(1));
						ppmRecord.setTask(rs.getString(2));
						ppmRecord.setTime_period(rs.getString(3));
						ppmRecord.setResource_name(rs.getString(4));
						ppmRecord.setResource_id(rs.getString(5));
						ppmRecord.setResource_manager(rs.getString(6));
						ppmRecord.setTimesheet_status(rs.getString(7));
						ppmRecord.setTimesheet_hours(rs.getString(8));
						ppmRecord.setSenior_executive(rs.getString(9));
						ppmRecord.setEmail(rs.getString(10));
						return ppmRecord;
					}

				});
	}

	@Override
	public List<Base> getDistinctContractorIds() {
		return jdbcTemplate.query(
				"select distinct(ce_id),employee_id,project,pm_id,pm_name,name,Worker_End_Date from revenue_forecast.base  order by employee_id",
				new RowMapper<Base>() {
					@Override
					public Base mapRow(ResultSet rs, int arg1) throws SQLException {
						Base base = new Base();
						base.setCe_id(rs.getString(1));
						base.setEmployee_id(rs.getString(2));
						base.setProject(rs.getString(3));
						base.setPm_id(rs.getString(4));
						base.setPm_name(rs.getString(5));
						base.setName(rs.getString(6));
						base.setWorkerEndDate(rs.getString(7));
						return base;
					}
				});
	}

	@Override
	public List<PPMRecord> getUniqueTimePeriod() {
		return jdbcTemplate.query("select distinct(time_period) from revenue_forecast.ppmsheet",
				new RowMapper<PPMRecord>() {
					@Override
					public PPMRecord mapRow(ResultSet rs, int arg1) throws SQLException {
						PPMRecord ppmRecord = new PPMRecord();
						ppmRecord.setTime_period(rs.getString(1));
						return ppmRecord;
					}
				});
	}

	@Override
	public List<PPMActuals> getPPMActuals() {
		// TODO Auto-generated method stub
		String ppmActualsQuery = "SELECT a.description,a.project,a.employee_id, a.onsite_offshore,a.name,a.am, "
				+ "a.ce_id,a.pm_id,a.pm_name, SUM(b.timesheet_hours)  as ppmactuals,if(a.Current_Bill_Rate_ST_Hr =0  "
				+ "OR a.Current_Bill_Rate_ST_Hr IS NULL or a.Current_Bill_Rate_ST_Hr ='',a.sowBillRate,"
				+ "a.Current_Bill_Rate_ST_Hr) as Current_Bill_Rate_ST_Hr ,a.Worker_Start_Date,a.Worker_End_Date,"
				+ "a.sow,a.sow_number, a.enddatebypm,a.ratebypm,a.ppmhoursbypm FROM revenue_forecast.base a "
				+ "LEFT JOIN revenue_forecast.ppmsheet b ON a.ce_id=b.resource_id where a.associate_billability='Y' "
				+ "and b.task !='Non-Working Time' and b.project_id !='rop002' and b.project_id != 'OW000027' "
				+ "GROUP BY a.employee_id, a.name, a.ce_id ";
		return jdbcTemplate.query(ppmActualsQuery, new RowMapper<PPMActuals>() {
			@Override
			public PPMActuals mapRow(ResultSet rs, int arg1) throws SQLException {
				PPMActuals ppmActuals = new PPMActuals();
				ppmActuals.setDescription(rs.getString(1));
				ppmActuals.setProject(rs.getString(2));
				ppmActuals.setEmployee_id(rs.getString(3));
				ppmActuals.setOnsite_offshore(rs.getString(4));
				ppmActuals.setName(rs.getString(5));
				ppmActuals.setAm(rs.getString(6));
				ppmActuals.setCe_id(rs.getString(7));
				ppmActuals.setPm_id(rs.getString(8));
				ppmActuals.setPm_name(rs.getString(9));
				ppmActuals.setPpmactuals(rs.getString(10));
				ppmActuals.setCurrent_Bill_Rate_ST_Hr(rs.getString(11));
				ppmActuals.setWorkerStartDate(rs.getString(12));
				ppmActuals.setWorkerEndDate(rs.getString(13));
				ppmActuals.setSow(rs.getString(14));
				ppmActuals.setSowNumber(rs.getString(15));
				ppmActuals.setEnddatebypm(rs.getString(16));
				ppmActuals.setRatebypm(rs.getString(17));
				ppmActuals.setPpmhoursbypm(rs.getString(18));
				return ppmActuals;
			}
		});

	}

	@Override
	public List<PPMRecord> getPPMStatusReport() {
		return jdbcTemplate.query(
				"select project_id, task, time_period, resource_name, resource_id, resource_manager, timesheet_status, timesheet_hours, senior_executive,email from revenue_forecast.ppmsheet where task !='Non-Working Time' and project_id !='rop002' and project_id != 'OW000027' order by resource_id",
				new RowMapper<PPMRecord>() {

					@Override
					public PPMRecord mapRow(ResultSet rs, int arg1) throws SQLException {
						PPMRecord ppmRecord = new PPMRecord();
						ppmRecord.setProject_id(rs.getString(1));
						ppmRecord.setTask(rs.getString(2));
						ppmRecord.setTime_period(rs.getString(3));
						ppmRecord.setResource_name(rs.getString(4));
						ppmRecord.setResource_id(rs.getString(5));
						ppmRecord.setResource_manager(rs.getString(6));
						ppmRecord.setTimesheet_status(rs.getString(7));
						ppmRecord.setTimesheet_hours(rs.getString(8));
						ppmRecord.setSenior_executive(rs.getString(9));
						ppmRecord.setEmail(rs.getString(10));
						return ppmRecord;
					}

				});
	}

	@Override
	public List<PPMActuals> updatePPMActuals(List<PPMActuals> ppmActualsList, User user) {
		List<Object[]> inputsToUpdate = new ArrayList<>();

		for (PPMActuals actuals : ppmActualsList) {
			inputsToUpdate.add(new Object[] { actuals.getEnddatebypm(), actuals.getRatebypm(),
					actuals.getPpmhoursbypm(), user.getFirst_name(), actuals.getEmployee_id(), actuals.getProject() });
		}
		String updateActualsSql = "update revenue_forecast.base set enddatebypm =?,ratebypm=?, ppmhoursbypm=?, last_updated_by=? where employee_id=? and project=? ";

		jdbcTemplate.batchUpdate(updateActualsSql, inputsToUpdate);
		return null;
	}

	@Override
	public Map<String, String> getProjetctByPM(String pmId) {

		String selectProject = "SELECT project,description FROM revenue_forecast.project_list where PM_ID=" + pmId;

		return jdbcTemplate.query(selectProject, new ResultSetExtractor<Map<String, String>>() {

			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, String> projDetails = new HashMap<>();
				while (rs.next()) {
					projDetails.put(rs.getString(1), rs.getString(2));
				}
				return projDetails;
			}
		});
	}

	@Override
	public List<PPMActuals> getPPMActualsByPMAndProject(String pmId, String pId) {
		// TODO Auto-generated method stub
		// String ppmActualsQuery ="SELECT
		// a.description,a.project,a.employee_id, a.onsite_offshore,a.name,a.am,
		// a.ce_id,a.pm_id,a.pm_name, SUM(b.timesheet_hours) as
		// ppmactuals,if(a.Current_Bill_Rate_ST_Hr =0 OR
		// a.Current_Bill_Rate_ST_Hr IS NULL or a.Current_Bill_Rate_ST_Hr
		// ='',a.sowBillRate,a.Current_Bill_Rate_ST_Hr) as
		// Current_Bill_Rate_ST_Hr
		// ,a.Worker_Start_Date,a.Worker_End_Date,a.sow,a.sow_number,
		// a.enddatebypm,a.ratebypm,a.ppmhoursbypm FROM revenue_forecast.base a
		// INNER JOIN revenue_forecast.ppmsheet b ON a.ce_id=b.resource_id where
		// a.associate_billability='Y' and b.task !='Non-Working Time' and
		// b.project_id !='rop002' and b.project_id != 'OW000027' GROUP BY
		// a.employee_id, a.name, a.ce_id ";
		String ppmActualsQuery = "SELECT a.description,a.project,a.employee_id,a.onsite_offshore,a.name,a.am, a.ce_id,a.pm_id,"
				+ "a.pm_name, SUM(b.timesheet_hours)  as ppmactuals,if(a.Current_Bill_Rate_ST_Hr =0  "
				+ "OR a.Current_Bill_Rate_ST_Hr IS NULL or a.Current_Bill_Rate_ST_Hr ='',a.sowBillRate,"
				+ "a.Current_Bill_Rate_ST_Hr) as Current_Bill_Rate_ST_Hr ,a.Worker_Start_Date,a.Worker_End_Date,a.sow,"
				+ "a.sow_number, a.enddatebypm,a.ratebypm,a.ppmhoursbypm FROM revenue_forecast.base a "
				+ "INNER JOIN revenue_forecast.ppmsheet b ON a.ce_id=b.resource_id where a.associate_billability='Y'"
				+ " and b.task !='Non-Working Time' and b.project_id !='rop002' and a.pm_id='" + pmId + "' "
				+ "and a.project='" + pId + "' and b.project_id != 'OW000027' GROUP BY a.employee_id, a.name, a.ce_id";
		return jdbcTemplate.query(ppmActualsQuery, new RowMapper<PPMActuals>() {
			@Override
			public PPMActuals mapRow(ResultSet rs, int arg1) throws SQLException {
				PPMActuals ppmActuals = new PPMActuals();
				ppmActuals.setDescription(rs.getString(1));
				ppmActuals.setProject(rs.getString(2));
				ppmActuals.setEmployee_id(rs.getString(3));
				ppmActuals.setOnsite_offshore(rs.getString(4));
				ppmActuals.setName(rs.getString(5));
				ppmActuals.setAm(rs.getString(6));
				ppmActuals.setCe_id(rs.getString(7));
				ppmActuals.setPm_id(rs.getString(8));
				ppmActuals.setPm_name(rs.getString(9));
				ppmActuals.setPpmactuals(rs.getString(10));
				ppmActuals.setCurrent_Bill_Rate_ST_Hr(rs.getString(11));
				ppmActuals.setWorkerStartDate(rs.getString(12));
				ppmActuals.setWorkerEndDate(rs.getString(13));
				ppmActuals.setSow(rs.getString(14));
				ppmActuals.setSowNumber(rs.getString(15));
				ppmActuals.setEnddatebypm(rs.getString(16));
				ppmActuals.setRatebypm(rs.getString(17));
				ppmActuals.setPpmhoursbypm(rs.getString(18));
				return ppmActuals;
			}
		});
	}

}
