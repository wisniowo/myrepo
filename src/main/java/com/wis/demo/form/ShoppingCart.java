package com.wis.demo.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.wis.demo.model.User;

@Component
@SessionScope
public class ShoppingCart {
	List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		if (!users.contains(user)) {
			users.add(user);
		}
	}

	public void removeUser(User user) {
		users.remove(user);
	}
}
