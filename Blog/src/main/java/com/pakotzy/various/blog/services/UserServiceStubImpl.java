package com.pakotzy.various.blog.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {

	@Override
	public boolean authenticate(String username, String password) {
		return Objects.equals(username, password);
	}

	@Override
	public boolean register(String usernmae, String password) {
		return authenticate(usernmae, password);
	}
}
