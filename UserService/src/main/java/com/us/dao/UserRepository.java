package com.us.dao;

import com.bs.entity.User;


public interface UserRepository {

	int createUser(User user);
	User getUserByUserId(int userId);
	boolean updateUser(User user);
	boolean deleteUser(int userId);
	User getUserByUserName(String userName);
	User getUserByEmail(String email);
	User getUserByUsernameAndPassword(String userName, String password);
}
