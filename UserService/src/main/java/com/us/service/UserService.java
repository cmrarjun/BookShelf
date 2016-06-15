package com.us.service;

import com.us.entities.UserLoginVO;
import com.us.entities.UserRegistrationVO;

public interface UserService {
	String registerUser(UserRegistrationVO userRegVO);
	String authenticateUser(UserLoginVO loginVO);
}
