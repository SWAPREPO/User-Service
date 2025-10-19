package com.sst.project.service;

import java.util.List;

import com.sst.project.entity.Role;
import com.sst.project.exception.RoleNotFoundException;

public interface RoleService {
	
	Role saveRole(Role Role);

	List<Role> getAllRole();

	Role getRoleById(long id) throws RoleNotFoundException;
	
	Role getRoleByRoleName(String roleName) throws RoleNotFoundException;
	
	Role updateRole(Role Role) throws RoleNotFoundException;

	String deleteRoleById(long id) throws RoleNotFoundException;

	String deleteAllRoles();
}
