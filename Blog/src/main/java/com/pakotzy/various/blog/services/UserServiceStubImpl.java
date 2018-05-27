package com.pakotzy.various.blog.services;

import com.pakotzy.various.blog.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {
	private List<User> users = new ArrayList<User>(){{
		add(new User(0, "admin", "admin"));
		add(new User(1, "user", "user"));
		add(new User(2, "pakotzy", "password"));
	}};

	@Override
	public User authenticate(String username, String password) {
		return users.stream().filter(e -> e.getUsername().equals(username)).filter(e -> e.getPasswordHash()
				.equals(password)).findFirst().orElse(null);
	}

	@Override
	public User register(String username, String password) {
		User user = users.stream().filter(e -> e.getUsername().equals(username)).findFirst().orElse(null);

		if (Objects.isNull(user)) {
			user = new User(users.stream().mapToLong(User::getId).max().getAsLong()+1, username, password);
			users.add(user);
		}

		return user;
	}

	@Override
	public List<User> findAll() {
		return users;
	}
}
