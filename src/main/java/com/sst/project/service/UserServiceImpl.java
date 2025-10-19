package com.sst.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.project.dto.UserDTO;
import com.sst.project.entity.Role;
import com.sst.project.entity.User;
import com.sst.project.exception.UserNotFoundException;
import com.sst.project.mapper.UserMapper;
import com.sst.project.repository.RoleRepository;
import com.sst.project.repository.UserRepository;
import com.sst.project.utility.EncryptDecryptUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EncryptDecryptUtils encryptDecryptUtils;
	
	@Autowired
    private UserMapper userMapper;
	
	private final UserRepository userRepository;
	
	private final RoleRepository roleRepository;
	
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDTO saveUser(UserDTO userDTO)  {
		Role lsRole = roleRepository.findById(userDTO.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found"));
		
		User User = userMapper.convertToEntity(userDTO);
		
//		System.out.println("Object Converted to Role 	:: " + lsRole.toString());
		System.out.println("Object Converted to Entity 	:: " + User.toString());
		
		User.setRole(lsRole);
		User.setPassword(encryptDecryptUtils.generateSHA256Hash(userDTO.getFirstName().toLowerCase() + "@12345"));
		
		System.out.println("Object Converted to Entity After :: " + User.toString());
		
		try {
			userRepository.save(User);
		} catch (Exception ex) {
//			System.err.println("Throwing User not Registerd exception from Service Class..." + ex);
			throw new RuntimeException("User not Registerd." + ex.getLocalizedMessage());
		}
		return userMapper.convertToDTO(User);
	}
	
	@Override
	public List<UserDTO> getAllUser() {
		List<User> listUsers = (List<User>) userRepository.findAll();
		return userMapper.toDTOList(listUsers);
	}

	@Override
	public UserDTO getUserById(long id) throws UserNotFoundException {
		if(userRepository.findById(id).isPresent()) {
			return userMapper.convertToDTO(userRepository.findById(id).get());
		} else {
			String msg = "User with id <" + id + "> does not exist..";
			System.err.println(msg);
			throw new UserNotFoundException(msg);
		}
	}

	@Override
	public String deleteUserById(long id) {
		String msg = "";
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			msg = "User with id <" + id + "> is deleted.";
		} else {
			msg = "User with id <" + id + "> does not exist hence can not delete it.";
			System.err.println(msg);
		}
		return msg;
	}

	@Override
	public String deleteAllUsers() {
		try {
			userRepository.deleteAll();
			return "All Users are deleted.";
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		User user = userRepository.findByEmail(email.trim());
		if(user != null) {
			return user;
		} else {
			throw new UserNotFoundException("Email does not exist");
		}
	}

	@Override
	public User validateUser(String email, String password) throws UserNotFoundException {
		User userObjDB = getUserByEmail(email);
		if(userObjDB.getPassword().equals(encryptDecryptUtils.generateSHA256Hash(password))) {
			return userObjDB;
		} else {
			throw new UserNotFoundException("Passowrd does not matched");
		}
	}
}
