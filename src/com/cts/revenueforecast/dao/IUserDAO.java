package com.cts.revenueforecast.dao;

import java.util.List;

import com.cts.revenueforecast.model.User;

public interface IUserDAO {

	public List<User> isUserValid(User user);

	public List<User> ValidateUser(User user);

	public int generateToken(String token, User user);

	public int saveForgotPassword(String user_Id, String password, String token);

	public int saveChangePassword(String user_Id, String currentPassword, String newPassword);

	public Integer addUser(User userToAdd);

	public List<User> getAllUsers();
}
