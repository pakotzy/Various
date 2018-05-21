package com.pakotzy.various.blog.controllers;

import com.pakotzy.various.blog.forms.LoginForm;
import com.pakotzy.various.blog.services.NotificationService;
import com.pakotzy.various.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private NotificationService notifyService;

	@RequestMapping("/users/login")
	public String login(LoginForm loginForm) {
		return "users/login";
	}

	@PostMapping(value = "/users/login")
	public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			notifyService.addErrorMessage("Please fill the form correctly!");
			return "users/login";
		}

		if (!userService.authenticate(
				loginForm.getUsername(), loginForm.getPassword())) {
			notifyService.addErrorMessage("Invalid login!");
			return "users/login";
		}

		notifyService.addInfoMessage("Login successful");
		return "redirect:/";
	}
}

