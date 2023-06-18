package com.dxc.project.service;


import com.dxc.project.exception.UserExistsException;
import com.dxc.project.exception.UserNotFoundException;
import com.dxc.project.model.User;


public interface UserService {
	User registerUser(User user) throws UserExistsException;
	User authenticateUser(String role,String userName,String password)throws UserNotFoundException;
	// to check all the records List<User> getUsers();

}
