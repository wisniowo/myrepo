package com.wis.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wis.demo.form.ShoppingCart;
import com.wis.demo.model.User;

@RestController
public class HelloRestController {

	@Autowired
	ShoppingCart shoppingCart;

	@RequestMapping("/cart/show")
	public List<User> showCart(Model model) {
		return shoppingCart.getUsers();
	}

}