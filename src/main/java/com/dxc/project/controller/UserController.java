package com.dxc.project.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.project.exception.UserExistsException;
import com.dxc.project.exception.UserNotFoundException;
import com.dxc.project.model.User;
import com.dxc.project.service.TokenGeneratorService;
import com.dxc.project.service.UserService;

@RestController
@RequestMapping("/project")
public class UserController {

	@Autowired
	public UserService service;
	
	@Autowired
	public TokenGeneratorService token;
	
	
	@PostMapping("register")
	public User registerUser(@RequestBody User user) throws UserExistsException {
		return service.registerUser(user);
	}
	
	@PostMapping("login")
	public Map<String,String> authenticateUser(@RequestBody User user) throws UserNotFoundException {
		final User user1 = service.authenticateUser(user.getRole(),user.getUserName(), user.getPassword());
		return this.token.generateToken(user1);
	
	}

	
//	@GetMapping("getAll")
//	public List<User> getUSers(){
//		return service.getUsers();
//	}
}
