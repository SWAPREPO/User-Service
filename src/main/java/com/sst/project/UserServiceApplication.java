package com.sst.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sst.project.config.ApplicationContextProvider;
import com.sst.project.dto.UserDTO;
import com.sst.project.entity.Role;
import com.sst.project.exception.RoleNotFoundException;
import com.sst.project.service.RoleService;
import com.sst.project.service.UserService;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
		Role role = new Role();
		role.setRoleName("ADMIN");
		role.setRoleDescription("ADMIN ROLE");
		role.setIsActive("Y");
		
		RoleService roleService = (RoleService) ApplicationContextProvider.getApplicationContext().getBean(RoleService.class);
		
		try {
			roleService.getRoleByRoleName(role.getRoleName());
			System.out.println("Role " + role.getRoleName() + " alreday Added.");
		} catch (RoleNotFoundException e) {
			role = roleService.saveRole(role);
			System.out.println("Role Added Successfully...");
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("sst231990@gmail.com");
		userDTO.setFirstName("Swapnil");
		userDTO.setMiddleName("Shivaji");
		userDTO.setLastName("Thoke");
		userDTO.setGender("M");
		userDTO.setMobileNo("8097904803");
		userDTO.setRoleId(role.getRoleId());
		
		UserService userService = (UserService) ApplicationContextProvider.getApplicationContext().getBean(UserService.class);
		userService.saveUser(userDTO);
		
		System.out.println("User Added Successfully...");
	}

}
