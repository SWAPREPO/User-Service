package com.sst.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sst.project.entity.Role;
import com.sst.project.exception.RoleNotFoundException;
import com.sst.project.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService 
{
	private final RoleRepository RoleRepository;

//	Constructor injection
	public RoleServiceImpl(RoleRepository RoleRepository) {
		this.RoleRepository = RoleRepository;
	}

	@Override
	public Role saveRole(Role role) {
		return RoleRepository.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		return (List<Role>) RoleRepository.findAll();
	}

	@Override
	public Role getRoleById(long id) throws RoleNotFoundException {
		if (RoleRepository.findById(id).isPresent()) {
			return RoleRepository.findById(id).get();
		} else {
			String msg = "Role with id <" + id + "> does not exist..";
			System.err.println(msg);
			throw new RoleNotFoundException(msg);
		}
	}

	@Override
	public String deleteRoleById(long id) {
		String msg = "";
		if (RoleRepository.findById(id).isPresent()) {
			RoleRepository.deleteById(id);
			msg = "Role with id <" + id + "> is deleted.";
		} else {
			msg = "Role with id <" + id + "> does not exist hence can not delete it.";
			System.err.println(msg);
		}
		return msg;
	}

	@Override
	public String deleteAllRoles() {
		try {
			RoleRepository.deleteAll();
			return "All Roles are deleted.";
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Role updateRole(Role role) throws RoleNotFoundException {
		String msg = "";
		long id = role.getRoleId();
		if (RoleRepository.findById(id).isPresent()) {
			Role tempRole = RoleRepository.findById(id).get();
			
			tempRole.setIsActive(role.getIsActive() == null ? tempRole.getIsActive() : role.getIsActive());
			tempRole.setRoleDescription(role.getRoleDescription() == null ? tempRole.getRoleDescription() : role.getRoleDescription());
			
			role = RoleRepository.save(tempRole);
			msg = "Role with id <" + id + "> is updated.";
		} else {
			msg = "Role with id <" + id + "> does not exist hence can not update it.";
			throw new RoleNotFoundException(msg);
		}
		return role;
	}

	@Override
	public Role getRoleByRoleName(String roleName) throws RoleNotFoundException {
		Role role = RoleRepository.findByRoleName(roleName);
		if (role != null) {
			return role;
		} else {
			String msg = "Role with id <" + roleName + "> does not exist..";
			throw new RoleNotFoundException(msg);
		}
	}
}
