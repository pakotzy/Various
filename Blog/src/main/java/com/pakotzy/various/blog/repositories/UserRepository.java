package com.pakotzy.various.blog.repositories;

import com.pakotzy.various.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.username = ?1 and u.passwordHash = ?2")
	User authenticate(String username, String password);
}
