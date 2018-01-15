package com.cts.revenueforecast.dao.impl;

import static com.cts.revenueforecast.common.Constants.fixedBitProjects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IAllocationReportDAO;
import com.cts.revenueforecast.model.AllocationReport;
import com.cts.revenueforecast.model.AllocationReportList;

@Repository
public class AllocationReportDAOImpl implements IAllocationReportDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AllocationReport> storeAllocationReport(List<AllocationReport> allocationReportList) {

		// jdbcTemplate.update("truncate table AllocationReport");
		jdbcTemplate.update("truncate table actual_allocationReport");
		jdbcTemplate.update("truncate table AllocationReport");
		List<Object[]> inputsToInsert = new ArrayList<>();
		try {
			for (AllocationReport eachRow : allocationReportList) {
				inputsToInsert.add(new Object[] {

						eachRow.getSno(), eachRow.getAssociateId(), eachRow.getTrueFalse(), eachRow.getAssociateName(),
						eachRow.getDesignation(), eachRow.getJobCode(), eachRow.getGradeHR(), eachRow.getGradeHRPyd(),
						eachRow.getAssignmentID(), eachRow.getSoID(), eachRow.getSoLine(), eachRow.getProjectID(),
						eachRow.getProjectDescription(), eachRow.getProjectManagerID(), eachRow.getProjectManagerName(),
						eachRow.getAccountID(), eachRow.getAccountName(), eachRow.getOdHierarchy(),
						eachRow.getAccountGroup(), eachRow.getSubVertical(), eachRow.getPoolID(),
						eachRow.getPoolDescription(), eachRow.getVerticalHorizontal(), eachRow.getGrade(),
						eachRow.getDateOfJoining(), eachRow.getFinDepartmentID(), eachRow.getHcmSupervisorID(),
						eachRow.getProjectOwningDepartment(), eachRow.getProjectOwningPractice(),
						eachRow.getBillabilityStatus(), eachRow.getCriticalFlag(), eachRow.getLocationID(),
						eachRow.getCountry(), eachRow.getOnsiteOffshore(), eachRow.getState(), eachRow.getCity(),
						eachRow.getAssignmentStartDate(), eachRow.getAssignmentEndDate(), eachRow.getAssignmentStatus(),
						eachRow.getPercentAllocation(), eachRow.getProjectRole(), eachRow.getOperationalRole(),
						eachRow.getAssgnCity(), eachRow.getAssgnState(), eachRow.getAssgnCountry(),
						eachRow.getLocationReasoncode(), eachRow.getProjectStartDate(), eachRow.getProjectEndDate(),
						eachRow.getProjectBillability(), eachRow.getProjectType(), eachRow.getProjectStatus(),
						eachRow.getAssociateBaseHiringLocation(), eachRow.getDepartmentName(), eachRow.getHcmSetID(),
						eachRow.getProject_Solution_Type(), eachRow.getAssignmentLocation(), eachRow.getSbu1(),
						eachRow.getSbu2(), eachRow.getPrimaryStateTag(), eachRow.getContractorEndDate(),
						eachRow.getComment(), eachRow.getCompetency()

				});
			}
			String loadAllocationReportSql = "insert into actual_allocationreport values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			jdbcTemplate.batchUpdate(loadAllocationReportSql, inputsToInsert);

			String filterAllocationData = "insert into allocationreport (select * from actual_allocationreport where trueFalse='True' and accountID='1214238' "
					+ "and projectID in (select project from project_list where New_rate_applies='Dev' ) and projectID not in ("
					+ fixedBitProjects + "))";

			jdbcTemplate.update(filterAllocationData);

		} catch (DuplicateKeyException e) {
			// this exception never come because the line
			// jdbcTemplate.update("truncate table AllocationReport"); will
			// truncate all the rows
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List viewAllocationReport() {
		String sql = "select * from allocationreport";
		return jdbcTemplate.queryForList(sql);
	}

}
