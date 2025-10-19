package com.sst.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sst.project.dto.UserDTO;
import com.sst.project.entity.User;
import com.sst.project.exception.UserNotFoundException;
import com.sst.project.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/add-user")
	public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}

	@GetMapping("/get-all-user")
	public List<UserDTO> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/get-user-by-id/{id}")
	public UserDTO getAllUser(@PathVariable("id") Long id) throws UserNotFoundException {
		return userService.getUserById(id);
	}
	
//	@GetMapping("/get-user-by-name")
//	public User getRoleByName(@PathParam("userName") String userName) throws UserNotFoundException {
//		return userService.getUserByUserName(userName);
//	}
	
//	@PostMapping("/validate-user")
//	public User validateUser(@Valid @RequestBody UserDTO userDTO) throws UserNotFoundException {
//		return userService.validateUser(userDTO.getEmail(), userDTO.getPassword());
//	}
//
//	@DeleteMapping("/delete-user-by-id/{id}")
//	public String deleteUserById(@PathVariable("id") Long id) throws UserNotFoundException {
//		return userService.deleteUserById(id);
//	}
//
//	@DeleteMapping("/delete-all-user")
//	public String deleteAllUser() {
//		return userService.deleteAllUsers();
//	}
}
