package com.cts.revenueforecast.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IProjectListDAO;
import com.cts.revenueforecast.model.ProjectList;

@Repository
public class ProjectListDAOImpl implements IProjectListDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int storeProjectList(List<ProjectList> pll) {
		// TODO Auto-generated method stub
		List<Object[]> inputs = new ArrayList<>();
		String sql = "insert into project_list values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for (ProjectList pl : pll) {
			inputs.add(pl.getObjectAsArray());
		}

		return jdbcTemplate.batchUpdate(sql, inputs)[0];
		// System.out.println("Success");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List viewProjectList() {
		// TODO Auto-generated method stub
		String sql="select * from project_list";
		return jdbcTemplate.queryForList(sql);
	}

}
