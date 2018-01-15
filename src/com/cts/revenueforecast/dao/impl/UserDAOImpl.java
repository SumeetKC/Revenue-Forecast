package com.cts.revenueforecast.dao.impl;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.revenueforecast.dao.IUserDAO;
import com.cts.revenueforecast.model.User;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> isUserValid(User user) {

		List<User> returnedUsers = jdbcTemplate.query(
				"select user_id,first_name,role from UserInfo where user_id=? and password=? and approval_status='APPROVED'",
				new Object[] { user.getUser_id(), user.getPassword() }, new BeanPropertyRowMapper<User>(User.class));
		return returnedUsers;
	}

	@Override
	public Integer addUser(User userToAdd) {
		Object[] user = new Object[] { userToAdd.getUser_id(), userToAdd.getPassword(), userToAdd.getFirst_name(),
				userToAdd.getLast_name(), userToAdd.getMobile_number(), userToAdd.getLocation(), userToAdd.getRole() };
		// return jdbcTemplate.update("insert into userinfo
		// values(?,?,?,?,?,?,?)",userToAdd);
		return jdbcTemplate.update(
				"insert into userinfo(user_id, password, first_name, last_name, mobile_number, location, role) values(?,?,?,?,?,?,?)",
				user, new int[] { INTEGER, VARCHAR, VARCHAR, VARCHAR, VARCHAR, VARCHAR, VARCHAR });
	}

	@Override
	public List<User> getAllUsers() {
		return jdbcTemplate.query(
				"select user_id,first_name,last_name,mobile_number,location,role,approval_status from userinfo",
				new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> ValidateUser(User user) {

		List<User> returnedUsers = jdbcTemplate.query("select user_id from UserInfo where user_id=?",
				new Object[] { user.getUser_id() }, new BeanPropertyRowMapper<User>(User.class));
		return returnedUsers;
	}

	public int generateToken(String token, User user) {
		String forgot_pass_requested = "Yes";
		String sql = "update userinfo set forgot_pass_requested=?,token=? where user_id=? ";
		Object[] inputsToUpdate = new Object[] { forgot_pass_requested, token, user.getUser_id() };
		int result = jdbcTemplate.update(sql, inputsToUpdate);
		return result;

	}

	@Override
	public int saveForgotPassword(String user_Id, String password, String token) {
		// TODO Auto-generated method stub
		String forgot_pass_requested = "Yes";
		String sql = "update userinfo set password=? where user_id=? and token=? and forgot_pass_requested=? ";
		Object[] inputsToUpdate = new Object[] { password, user_Id, token, forgot_pass_requested };
		int result = jdbcTemplate.update(sql, inputsToUpdate);
		jdbcTemplate.update("update userinfo set token=null, forgot_pass_requested=null where user_id=" + user_Id);
		return result;
	}
	
	@Override
	public int saveChangePassword(String user_Id, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update userinfo set password=? where user_id=? and password=?";
		Object[] inputsToUpdate = new Object[] { newPassword, user_Id, currentPassword };
		int result = jdbcTemplate.update(sql, inputsToUpdate);
		return result;
	}

}
