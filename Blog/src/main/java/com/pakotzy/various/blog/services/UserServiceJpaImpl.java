package com.pakotzy.various.blog.services;

import com.pakotzy.various.blog.models.User;
import com.pakotzy.various.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User authenticate(String username, String password) {
		return userRepository.authenticate(username, password);
	}

	@Override
	public User register(String username, String password) {
		return create(new User(null, username, password));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User edit(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
