package com.sst.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "UserMaster", uniqueConstraints = @UniqueConstraint(columnNames = { "firstName", "middleName","lastName" }))
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@Pattern(regexp = "^[a-zA-Z\\s]{3,250}$", message = "FirstName must be 5-20 characters long and contain only letters, space, or underscores")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z\\s]{3,250}$", message = "MiddleName must be 5-20 characters long and contain only letters, space, or underscores")
	private String middleName;

	@Pattern(regexp = "^[a-zA-Z\\s]{3,250}$", message = "LastName must be 5-20 characters long and contain only letters, space, or underscores")
	private String lastName;

	@Pattern(regexp = "^[0-9]{0,10}$")
	private String mobileNo;

	@NotEmpty(message = "Gender can not be empty")
	private String gender;
	
	@NotEmpty(message = "Password can not be empty")
	private String password;

	@Email
	@NotEmpty(message = "Email Id can not be empty")
	private String email;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	@JsonIgnore
	private Role role;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", mobileNo=" + mobileNo + ", gender=" + gender + ", password=" + password + ", email="
				+ email + ", role=" + role + "]";
	}
}
