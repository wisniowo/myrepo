package com.wis.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User extends AbstractModel {

	@NotEmpty
	private String name;

	@Email
	private String email;
	
	@NotEmpty
	List<Role> roles = new ArrayList<>();

	public User() {
		super();
		roles.add(Role.CUSTOMER);
	}

	public User(String name, String email) {
		this();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}
