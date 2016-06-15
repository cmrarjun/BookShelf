package com.us.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.constant.GeneralEnum;
import com.bs.entity.Shelf;
import com.bs.entity.User;
import com.google.gson.Gson;
import com.us.dao.UserRepository;
import com.us.entities.UserLoginVO;
import com.us.entities.UserRegistrationVO;
import com.us.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String registerUser(UserRegistrationVO userRegVO) {
		String status = validateUser(userRegVO);
		if(!status.equalsIgnoreCase("success"))
			return status;
		User user = new User();
		user.setFirstName(userRegVO.getFirstName());
		user.setLastName(userRegVO.getLastName());
		user.setUserName(userRegVO.getUserName());
		user.setPwd(userRegVO.getPassword());
		user.setEmail(userRegVO.getEmail());
		user.setPhoneNumber(userRegVO.getPhoneNumber());
		Calendar cal = Calendar.getInstance();
		user.setCreatedDt(cal.getTime());
		user.setLastUpdatedDt(cal.getTime());
		Shelf shelf = new Shelf();
		shelf.setName(GeneralEnum.DEFAULT_SHELF_NAME.getValue());
		shelf.setCreatedDt(cal.getTime());
		shelf.setLastUpdatedDt(cal.getTime());
		shelf.setUser(user);
		user.setShelf(shelf);
		userRepository.createUser(user);
		return status;
	}

	@Override
	public String authenticateUser(UserLoginVO loginVO) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(loginVO.getUserName().trim()) && !StringUtils.isEmpty(loginVO.getPassword().trim())) {
			User user = userRepository.getUserByUsernameAndPassword(loginVO.getUserName(), loginVO.getPassword());
			if(user != null) {
				map.put("status", "success");
			} else {
				map.put("status", "failed");
				map.put("error", "Username/Password is not correct");
			}
		} else {
			map.put("status", "failed");
			map.put("error", "Username/Password cannot be blank");
		}
		return gson.toJson(map);
	}

	private String validateUser(UserRegistrationVO userRegVO) {
		List<String> errors = new ArrayList<String>();
		if(userRepository.getUserByUserName(userRegVO.getUserName()) != null) {
			errors.add("Username already exists");
		}
		
		if(userRepository.getUserByEmail(userRegVO.getEmail()) != null) {
			errors.add("Email Id already exists");
		}
		
		if (userRegVO.getPassword() != null
				&& userRegVO.getConfirmPassword() != null
				&& !userRegVO.getPassword().equals(
						userRegVO.getConfirmPassword())) {
			errors.add("Password & Confirm Password are not matching");
		}
		if(errors.size() > 0) {
			Gson gson = new Gson();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", errors);
			return gson.toJson(map);
		} else {
			return "success";
		}
	}
}
