package com.pakotzy.various.blog.services;

import com.pakotzy.various.blog.models.User;

import java.util.List;

public interface UserService {
	User authenticate(String username, String password);
	User register(String username, String password);

	List<User> findAll();

	User findById(Long id);

	User create(User user);

	User edit(User user);

	void deleteById(Long id);
}
