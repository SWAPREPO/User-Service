package com.sst.project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sst.project.entity.Role;
import com.sst.project.exception.RoleNotFoundException;
import com.sst.project.service.RoleService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/role")
public class RoleController {

	private final RoleService RoleService;

	public RoleController(RoleService RoleService) {
		this.RoleService = RoleService;
	}

	@PostMapping("/add-role")
	public Role saveRole(@Valid @RequestBody Role Role) {
		return RoleService.saveRole(Role);
	}

	@GetMapping("/get-all-role")
	public List<Role> getAllRole() {
		return RoleService.getAllRole();
	}

	@GetMapping("/get-role-by-id/{id}")
	public Role getRoleById(@PathVariable("id") Long id) throws RoleNotFoundException {
		return RoleService.getRoleById(id);
	}
	
	@GetMapping("/get-role-by-name")
	public Role getRoleByName(@PathParam("roleName") String roleName) throws RoleNotFoundException {
		return RoleService.getRoleByRoleName(roleName);
	}
	
	@PutMapping("/update-role")
	public Role updateRole(@Valid @RequestBody Role Role) throws RoleNotFoundException {
		return RoleService.updateRole(Role);
	}

	@DeleteMapping("/delete-role-by-id/{id}")
	public String deleteRoleById(@PathVariable("id") Long id) throws RoleNotFoundException {
		return RoleService.deleteRoleById(id);
	}

	@DeleteMapping("/delete-all-role")
	public String deleteAllRole() {
		return RoleService.deleteAllRoles();
	}

	public ResponseEntity<Role> displayRoleForm(Model model) {
		return null;
	}
	
}
