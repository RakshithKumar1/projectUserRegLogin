package com.dxc.project.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.project.exception.*;
import com.dxc.project.exception.UserExistsException;
import com.dxc.project.model.User;
import com.dxc.project.repo.*;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) throws UserExistsException {
		final boolean existById = userRepository.existsById(user.getUserId());
		if(existById) {
			throw new UserExistsException("User Already Exists");
		}
		return userRepository.save(user);
	}

	@Override
	public User authenticateUser(String role,String userName, String password)
			throws UserNotFoundException {
		final Optional<User> optionalUser = userRepository.findByUserNameAndPassword(userName, password);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		else if(optionalUser.get().getRole().equals(role)) {
				return optionalUser.get();
		}
		else {
			throw new UserNotFoundException("User Not Found");
		}
	}
		

//just to check all the records
//	@Override
//	public List<User> getUsers() {
//		// TODO Auto-generated method stub
//		return userRepository.findAll();
//	}


	

}
