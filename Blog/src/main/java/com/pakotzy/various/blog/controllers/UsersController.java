package com.pakotzy.various.blog.controllers;

import com.pakotzy.various.blog.forms.LoginForm;
import com.pakotzy.various.blog.models.User;
import com.pakotzy.various.blog.services.NotificationService;
import com.pakotzy.various.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;
	@Autowired
	private NotificationService notificationService;

	@RequestMapping
	public String index(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users/index";
	}

	@RequestMapping("login")
	public String loginPage(LoginForm loginForm) {
		return "users/login";
	}

	@PostMapping(value = "login")
	public String login(@Valid LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			notificationService.addErrorMessage("Please fill the form correctly!");
			return "users/login";
		}

		if (Objects.isNull(userService.authenticate(loginForm.getUsername(), loginForm.getPassword()))) {
			notificationService.addErrorMessage("Invalid loginPage!");
			return "users/login";
		}

		notificationService.addInfoMessage("Login successful");
		return "redirect:/";
	}

	@GetMapping("register")
	public String registerPage(LoginForm loginForm) {
		return "users/register";
	}

	@PostMapping("register")
	public String register(@Valid LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			notificationService.addErrorMessage("Please fill the form correctly!");
			return "register";
		}

		if (Objects.isNull(userService.register(loginForm.getUsername(), loginForm.getPassword()))) {
			notificationService.addErrorMessage("User already exists!");
			return "users/register";
		}

		notificationService.addInfoMessage("Registration successful");
		return "redirect:/";
	}
}

