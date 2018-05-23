package com.pakotzy.various.blog.controllers;

import com.pakotzy.various.blog.forms.LoginForm;
import com.pakotzy.various.blog.services.NotificationService;
import com.pakotzy.various.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;

	@Autowired
	NotificationService notificationService;

	@GetMapping("users/register")
	public String register(LoginForm loginForm) {
		return "users/register";
	}

	@PostMapping("users/register")
	public String registerPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			notificationService.addErrorMessage("Please fill the form correctly!");
			return "users/register";
		}

		if (!userService.register(loginForm.getUsername(), loginForm.getPassword())) {
			notificationService.addErrorMessage("User already exists!");
			return "users/register";
		}

		notificationService.addInfoMessage("Registration successful");
		return "redirect:/";
	}
}
