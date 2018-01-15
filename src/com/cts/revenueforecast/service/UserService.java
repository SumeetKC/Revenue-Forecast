package com.cts.revenueforecast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.revenueforecast.dao.IUserDAO;
import com.cts.revenueforecast.model.User;

@Service
public class UserService {

	@Autowired
	private IUserDAO iUserDAO;

	public User isUserValid(User user) {
		List<User> users = iUserDAO.isUserValid(user);
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public Boolean addUser(User userToAdd) {
		Integer result = iUserDAO.addUser(userToAdd);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> getAllUsers() {

		return iUserDAO.getAllUsers();
	}

	public User validateUser(User user) {
		List<User> users = iUserDAO.ValidateUser(user);
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public int generateToken(User user) {
		String token = String.valueOf((int) (Math.random() * 1000000));
		int result = iUserDAO.generateToken(token, user);
		return result;
	}

	public int saveForgotPassword(String user_Id, String password, String token) {
		int result = iUserDAO.saveForgotPassword(user_Id, password, token);
		return result;
	}

	public int saveChangePassword(String user_Id, String currentPassword, String newPassword) {
		int result = iUserDAO.saveChangePassword(user_Id, currentPassword, newPassword);
		return result;
	}

}
