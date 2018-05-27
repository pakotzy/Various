package com.pakotzy.various.blog.services;

import com.pakotzy.various.blog.models.User;

import java.util.List;

public interface UserService {
	User authenticate(String username, String password);
	User register(String username, String password);
	List<User> findAll();
}
