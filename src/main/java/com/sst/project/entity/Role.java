package com.sst.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;

	@Column(unique = true)
	@NotEmpty(message = "Role Name can not be empty")
	private String roleName;

	@NotEmpty(message = "Role Description can not be empty")
	private String roleDescription;

	@NotEmpty(message = "Role isActive status can not be empty")
	private String isActive = "N";

//	@OneToMany(mappedBy = "role")
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<User> userRoleList;
	
	public Role() {}
	
	public Role(long roleId) {
		super();
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName.toUpperCase();
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription.toUpperCase();
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive.toUpperCase();
	}

	public List<User> getEmployeeRoleList() {
		return userRoleList;
	}

	public void setEmployeeRoleList(List<User> userRoleList) {
		this.userRoleList = userRoleList;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription
				+ ", isActive=" + isActive + ", userRoleList=" + userRoleList + "]";
	}

}
