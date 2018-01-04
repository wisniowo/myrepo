package com.wis.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wis.demo.form.ShoppingCart;
import com.wis.demo.model.User;

@Service
public class HelloService {

	final List<User> users = new ArrayList<>();
	
	@Autowired
	ShoppingCart shoppingCard;

	@PostConstruct
	public void setupUsers() {
		for (int i = 0; i < 10; i++) {
			String username = "user" + i;
			users.add(new User(username, username + "@gmail.com"));
		}
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User findByName(final String name) {
		return users.stream().filter(user -> name.equals(user.getName())).findFirst().orElse(null);
	}

	public void updateUsers(List<User> users) {
		this.users.clear();
		this.users.addAll(users);
	}

	public void removeUser(String name) {
		User user = findByName(name);
		users.remove(user);
	}
	
	public void addUserToShoppingCart(String name) {
		User user = findByName(name);
		shoppingCard.addUser(user);
	}

	public void removeUserFromShoppingCart(String name) {
		User user = findByName(name);
		shoppingCard.removeUser(user);
	}
	
}
