package com.cts.revenueforecast.dao.impl;

import static com.cts.revenueforecast.common.Constants.comma;
import static com.cts.revenueforecast.common.Constants.countryIndia;
import static com.cts.revenueforecast.common.Constants.existingEmployeeStatus;
import static com.cts.revenueforecast.common.Constants.insertBaseSql;
import static com.cts.revenueforecast.common.Constants.offshoreWorkingHrs;
import static com.cts.revenueforecast.common.Constants.onsiteWorkingHrs;
import static com.cts.revenueforecast.common.Constants.selectNewBaseDataQuery;
import static com.cts.revenueforecast.common.Constants.singleQuote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IBaseDAO;
import com.cts.revenueforecast.model.Base;
import com.cts.revenueforecast.model.ProjectForm;


@Repository
public class BaseDAOImpl implements IBaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Base> retrieveBaseDetailsList(String datestamp) {

		updateStatusOfAllEmployeesTo(existingEmployeeStatus);
		updateTerminatedEmployeesStatus();
		insertNewEmployeesToBase(datestamp);
		/*String moveTerminatedToHistory="insert into base_history select work_assignment_id, employee_id, name, project, description,"
				+ " pm_id, pm_name,  city, country, associate_billability, AM, SoW, SoW_Number, Billing_in, ce_id, contractor_number, "
				+ "Worker_Start_Date, Worker_End_Date, Current_Bill_Rate_ST_Hr,sowenddate, sowbillrate,pto_jan, "
				+ "pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug,"
				+ " pto_sept, pto_oct, pto_nov, pto_dec, total_pto, Onsite_Offshore,"
				+ " billing_hours_per_day, date_stamp,status,truefalse,email from base where ";
		jdbcTemplate.update(moveTerminatedToHistory);*/
		
		// To return Base Table Data for Viewing
		String updatedBaseData = "select * from base";
		List<Base> baseFinal = jdbcTemplate.query(updatedBaseData, new BeanPropertyRowMapper<Base>(Base.class));

		return baseFinal;

	}

	private void insertNewEmployeesToBase(String datestamp) {


		List<Base> finalBaseDataToInsert = jdbcTemplate.query(selectNewBaseDataQuery,
				new BeanPropertyRowMapper<Base>(Base.class));		
	

		List<Object[]> inputsToInsert = new ArrayList<>();
		for (Base b : finalBaseDataToInsert) {

			if (b.getCountry().equals(countryIndia)) {
				b.setOnsite_Offshore(b.getCity());
				b.setBilling_hours_per_day(offshoreWorkingHrs);
			} else {
				b.setOnsite_Offshore("Onsite");
				b.setBilling_hours_per_day(onsiteWorkingHrs);
			}

			inputsToInsert.add(new Object[] { b.getWork_assignment_id(), b.getEmployee_id(), b.getName(),
					b.getProject(), b.getDescription(), b.getPm_id(), b.getPm_name(),
					// b.getProjectId_EmpId(),
					b.getCity(), b.getCountry(), b.getAssociate_billability(), b.getAM(), b.getSow(), b.getSowNumber(),
					b.getBilling_in(), b.getCe_id(), b.getContractor_number(), b.getWorkerStartDate(),
					b.getWorkerEndDate(), b.getCurrent_Bill_Rate_ST_Hr(), b.getPto_jan(), b.getPto_feb(),
					b.getPto_mar(), b.getPto_apr(), b.getPto_may(), b.getPto_june(), b.getPto_july(), b.getPto_aug(),
					b.getPto_sept(), b.getPto_oct(), b.getPto_nov(), b.getPto_dec(), b.getTotal_pto(),
					b.getOnsite_Offshore(), b.getBilling_hours_per_day(), datestamp, b.getStatus(),
					b.getTruefalse(), b.getSowBillRate(), b.getSowEndDate(), b.getEmail(), b.getPractice_name(),b.getAllocation_end_date()});

		}

		jdbcTemplate.batchUpdate(insertBaseSql, inputsToInsert);
	}

	private void updateStatusOfAllEmployeesTo(String status) {
		String updateAllExisting="update base set status='"+status+"'";
		jdbcTemplate.update(updateAllExisting);
	}
	
	/**
	 * This method Updates the status of Employees using the 
	 * passed 'status' for the 'employeeStringForSQL'
	 * 
	 * @param status
	 * @param employeeStringForSQL
	 */
	private void updateStatusOfEmployeesTo(String status,String employeeStringForSQL) {
		String updateAllExisting="update base set status='"+status+"' where employee_id in ("+employeeStringForSQL+")";
		jdbcTemplate.update(updateAllExisting);
	}

	private void updateTerminatedEmployeesStatus() {
		String terminatedEmployees = "select employee_id from base where employee_id not in (SELECT associateId FROM allocationreport)";
		
		List<String> terminatedEmployeesList = jdbcTemplate.queryForList(terminatedEmployees, String.class);
		StringBuilder terminatedEmployeeString = new StringBuilder();
		for (String empid : terminatedEmployeesList) {
			terminatedEmployeeString.append(singleQuote).append(empid).append(singleQuote).append(comma);			
		}
		//String terminatedEmployeeStringForSQL = terminatedEmployeeString.toString().substring(0,terminatedEmployeeString.length()-1);
		//updateStatusOfEmployeesTo(terminatedEmployeeStatus,terminatedEmployeeStringForSQL);
		
	}

	public List<Base> retrieveBaseDetailsListForExcel() {

		String selectBaseQuery = "Select description, project, employee_id, onsite_Offshore, name, practice_name, city,"
				+ "worker_Start_Date, worker_End_Date, current_Bill_Rate_ST_Hr,sowEndDate,sowBillRate, sow, sow_Number, pto_jan,"
				+ "pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, "
				+ "pto_nov, pto_dec, date_stamp, ce_id, AM, pm_name from base; ";
		List<Base> finalBasesheet = jdbcTemplate.query(selectBaseQuery, new BeanPropertyRowMapper<Base>(Base.class));
		/*
		 * for(Base b:finalBasesheet) { System.out.println(b.getDescription());
		 * System.out.println(b.getProject()); }
		 */
		return finalBasesheet;
	}


	@Override
	public Map<String, String> retrieveNewAddedEmployees(String datestamp) {

		/**
		 * The below Query returns a list of new employees who have to be
		 * inserted into Base Table with AssociateId, Associate Name, Status = N
		 * and insert the new employees into EsaVsContractorId table and call
		 * Method - fetchContractorIds()
		 * 
		 */
		String selectBaseDataQuery = "select associateId,associateName from allocationreport where associateId not in (SELECT employee_id FROM base)";
		return jdbcTemplate.query(selectBaseDataQuery, new ResultSetExtractor<Map<String, String>>() {

			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, String> newEmployees = new HashedMap<>();
				while (rs.next()) {
					newEmployees.put(rs.getString(1), rs.getString(2));
				}

				return newEmployees;
			}
		});
	}

	@Override
	public List<Base> viewBaseDetailsList() {

		String query = "select * from base";
		List<Base> brl = jdbcTemplate.query(query, new BeanPropertyRowMapper<Base>(Base.class));
		return brl;
	}

	@Override
	public Map<String, String> retrieveAllProjectIds() {
		String sql = "select distinct(project),description from base";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Map<String, String>>() {

			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, String> vl = new HashedMap<>();
				while (rs.next()) {
					vl.put(rs.getString(1), rs.getString(2));

				}

				return vl;
			}
		});

	}

	@Override
	public List<Base> retrieveBaseRecordsByProjectId(String pid) {
		String sql = "select * from base where project='" + pid + "' and truefalse = '" + true + "'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Base>(Base.class));
	}

	@Override
	public Map<String, String> retrieveAllProjectManagerIds() {
		String sql = "select distinct(pm_id),pm_name from base";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Map<String, String>>() {

			@Override
			public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, String> vl = new HashMap<>();
				while (rs.next()) {
					vl.put(rs.getString(1), rs.getString(2));
				}
				return vl;
			}
		});
	}

	@Override
	public List<Base> retrieveBaseRecordsByProjectManagerId(String pmid) {
		String sql = "select *  from base where pm_id='" + pmid + "' and truefalse = '" + true + "'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Base>(Base.class));
	}

	@Override
	public int movebasetohistory() {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"insert into base_history select work_assignment_id, employee_id, name, project, description, pm_id, pm_name,  city, country, associate_billability, AM, SoW, SoW_Number, Billing_in, ce_id, contractor_number, Worker_Start_Date, Worker_End_Date, Current_Bill_Rate_ST_Hr,sowenddate, sowbillrate,pto_jan, pto_feb, pto_mar, pto_apr, pto_may, pto_june, pto_july, pto_aug, pto_sept, pto_oct, pto_nov, pto_dec, total_pto, Onsite_Offshore, billing_hours_per_day, date_stamp,status,truefalse,email from base");
	}

	@Override
	public List<ProjectForm> retrieveAllProject() {
		// TODO Auto-generated method stub

		String sql = "select Project,Description,PM_ID,PM_Name,New_rate_applies,Type,AM,Em,SVP,VP_IT,Forecast_PoC_ID,SoW,SoW_Number,Onsite_PoC,Offshore_PoC,Discount,Datestamp,Billing_in from project_list";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<ProjectForm>>() {

			@Override
			public List<ProjectForm> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ProjectForm> prjList = new ArrayList<ProjectForm>();
				while (rs.next()) {
					ProjectForm pl = new ProjectForm();
					pl.setProject(rs.getString(1));
					pl.setDescription(rs.getString(2));
					pl.setPmID(rs.getString(3));
					pl.setPmName(rs.getString(4));
					pl.setNew_rate_applies(rs.getString(5));
					pl.setType(rs.getString(6));
					pl.setAm(rs.getString(7));
					pl.setEm(rs.getString(8));
					pl.setSvp(rs.getString(9));
					pl.setVpit(rs.getString(10));
					pl.setForecastPoCID(rs.getString(11));
					pl.setSoW(rs.getString(12));
					pl.setSoW_Number(rs.getString(13));
					pl.setOnsitePoC(rs.getString(14));
					pl.setOffshorePoC(rs.getString(15));
					pl.setDiscount(rs.getString(16));
					pl.setDatestamp(rs.getString(17));
					pl.setBillingin(rs.getString(18));
					prjList.add(pl);
				}
				return prjList;
			}

		});

	}

	@Override
	public List<ProjectForm> retrieveProject(String projectId) {
		String sqlSelectProject = "select Project,Description,PM_ID,PM_Name,New_rate_applies,Type,AM,Em,SVP,VP_IT,Forecast_PoC_ID,SoW,SoW_Number,Onsite_PoC,Offshore_PoC,Discount,Datestamp,Billing_in from project_list where project='"
				+ projectId + "' ";

		return jdbcTemplate.query(sqlSelectProject, new ResultSetExtractor<List<ProjectForm>>() {

			@Override
			public List<ProjectForm> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ProjectForm> prjList = new ArrayList<ProjectForm>();
				while (rs.next()) {
					ProjectForm pl = new ProjectForm();
					pl.setProject(rs.getString(1));
					pl.setDescription(rs.getString(2));
					pl.setPmID(rs.getString(3));
					pl.setPmName(rs.getString(4));
					pl.setNew_rate_applies(rs.getString(5));
					pl.setType(rs.getString(6));
					pl.setAm(rs.getString(7));
					pl.setEm(rs.getString(8));
					pl.setSvp(rs.getString(9));
					pl.setVpit(rs.getString(10));
					pl.setForecastPoCID(rs.getString(11));
					pl.setSoW(rs.getString(12));
					pl.setSoW_Number(rs.getString(13));
					pl.setOnsitePoC(rs.getString(14));
					pl.setOffshorePoC(rs.getString(15));
					pl.setDiscount(rs.getString(16));
					pl.setDatestamp(rs.getString(17));
					pl.setBillingin(rs.getString(18));
					prjList.add(pl);
				}
				return prjList;
			}

		});
	}

	@Override
	public int updateProject(ProjectForm projectForm) {
		List<Object[]> inputsToUpdate = new ArrayList<>();

		inputsToUpdate.add(new Object[] { projectForm.getDescription(), projectForm.getPmID(), projectForm.getPmName(),
				projectForm.getNew_rate_applies(), projectForm.getType(), projectForm.getAm(), projectForm.getEm(),
				projectForm.getSvp(), projectForm.getVpit(), projectForm.getForecastPoCID(), projectForm.getSoW(),
				projectForm.getSoW_Number(), projectForm.getOnsitePoC(), projectForm.getOffshorePoC(),
				projectForm.getDiscount(), projectForm.getDatestamp(), projectForm.getBillingin(),
				projectForm.getProject()});

		String updateprojetSql = "update project_list set Description =?,PM_ID=?, PM_Name=?, New_rate_applies=?, Type=?, AM=?,Em=?, SVP=?, VP_IT=?, Forecast_PoC_ID=?, sow=?, SoW_Number=?, Onsite_PoC=?,Offshore_PoC=?, Discount=?, Datestamp=?, Billing_in=? where project=?";

		jdbcTemplate.batchUpdate(updateprojetSql, inputsToUpdate);
		return 0;
	}

	@Override
	public int addNewProject(ProjectForm projectForm) {
		List<Object[]> inputsToInsert = new ArrayList<>();
		String insertProjectSql = "insert into project_list (project,Description,PM_ID, PM_Name, New_rate_applies, Type, AM,Em, SVP, VP_IT, Forecast_PoC_ID, sow, SoW_Number, Onsite_PoC,Offshore_PoC, Discount, Datestamp, Billing_in) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		inputsToInsert.add(new Object[] { projectForm.getProject(), projectForm.getDescription(), projectForm.getPmID(),
				projectForm.getPmName(), projectForm.getNew_rate_applies(), projectForm.getType(), projectForm.getAm(),
				projectForm.getEm(), projectForm.getSvp(), projectForm.getVpit(), projectForm.getForecastPoCID(),
				projectForm.getSoW(), projectForm.getSoW_Number(), projectForm.getOnsitePoC(),
				projectForm.getOffshorePoC(), projectForm.getDiscount(), projectForm.getDatestamp(),
				projectForm.getBillingin(),

		});
		jdbcTemplate.batchUpdate(insertProjectSql, inputsToInsert);
		return 0;
	}

}
