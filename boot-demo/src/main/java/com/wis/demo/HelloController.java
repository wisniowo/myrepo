package com.wis.demo;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wis.demo.form.ShoppingCart;
import com.wis.demo.form.UsersForm;
import com.wis.demo.model.Role;

@Controller
public class HelloController {

	@Autowired
	HelloService helloService;

	@Autowired
	ShoppingCart shoppingCart;

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", helloService.getAllUsers());
		final UsersForm form = new UsersForm(helloService.getAllUsers());
		model.addAttribute("usersForm", form);
		return "users";
	}

	@RequestMapping("/user/{name}")
	public String user(@PathVariable("name") String name, Model model) {
		model.addAttribute("user", helloService.findByName(name));
		return "user";
	}

	@RequestMapping("/users-save")
	public String usersSave(@Valid UsersForm usersForm, Errors errors, BindingResult bindingResult) {
		System.out.println("----");
		usersForm.getUsers().stream().forEach(user -> System.out.println(user.getEmail()));
		System.out.println(errors.getErrorCount());
		if (errors.hasErrors()) {
			System.out.println(errors.getFieldErrors());
			return "users";
		} else {
			helloService.updateUsers(usersForm.getUsers());
		}
		return "redirect:/users";
	}

	@RequestMapping("/users/remove/{name}")
	public String usersSave(@PathVariable("name") String name) {
		helloService.removeUser(name);
		return "redirect:/users";
	}

	@RequestMapping("/users/cart-add/{name}")
	public String addToShoppingCart(@PathVariable("name") String name) {
		helloService.addUserToShoppingCart(name);
		return "redirect:/users";
	}

	@RequestMapping("/users/cart-remove/{name}")
	public String removeFromShoppingCart(@PathVariable("name") String name) {
		helloService.removeUserFromShoppingCart(name);
		return "redirect:/users";
	}
	
	@ModelAttribute("allRoles")
	public List<Role> allRoles() {
		return Arrays.asList(Role.values());
	}

	@ModelAttribute("shoppingCart")
	public ShoppingCart shoppingCart() {
		return shoppingCart;
	}

}