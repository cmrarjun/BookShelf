package com.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bs.entity.User;
import com.us.dao.UserRepository;
import com.us.entities.UserLoginVO;
import com.us.entities.UserRegistrationVO;
import com.us.service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserServiceController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hi!!!";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody UserRegistrationVO userRegVO) {
		return new ResponseEntity<String>(userService.registerUser(userRegVO), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/verifyUserLogin", method = RequestMethod.POST)
	public ResponseEntity<String> verifyUserLogin(@RequestBody UserLoginVO loginVO) {
		return new ResponseEntity<String>(userService.authenticateUser(loginVO), HttpStatus.OK);
	}
}
