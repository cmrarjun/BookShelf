package com.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bs.entity.User;
import com.us.dao.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserServiceController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		userRepository.createUser(new User());
		return "Hi!!!";
	}
}
