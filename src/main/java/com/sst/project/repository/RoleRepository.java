package com.sst.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sst.project.entity.Role;
import com.sst.project.exception.RoleNotFoundException;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByRoleName(String roleName) throws RoleNotFoundException;
	
	
}
