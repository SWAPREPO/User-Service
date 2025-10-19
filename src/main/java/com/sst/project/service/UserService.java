package com.sst.project.service;

import java.util.List;

import com.sst.project.dto.UserDTO;
import com.sst.project.entity.User;
import com.sst.project.exception.UserNotFoundException;

public interface UserService {

	UserDTO saveUser(UserDTO UserDTO);
	
	List<UserDTO> getAllUser();
	
	UserDTO getUserById(long id) throws UserNotFoundException;
	
	String deleteUserById(long id) throws UserNotFoundException;
	
	String deleteAllUsers();
	
	User getUserByEmail(String email) throws UserNotFoundException;
	
	User validateUser(String email, String password) throws UserNotFoundException;
}
