package com.pakotzy.various.blog.services;

public interface UserService {
	boolean authenticate(String username, String password);

	boolean register(String usernmae, String password);
}
