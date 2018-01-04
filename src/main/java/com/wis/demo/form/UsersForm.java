package com.wis.demo.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.wis.demo.model.User;

public class UsersForm {

	@Valid
	private List<User> users = new ArrayList<User>();

	public UsersForm() {
	}

	public UsersForm(List<User> rows) {
		super();
		this.users = rows;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> rows) {
		this.users = rows;
	}

}
