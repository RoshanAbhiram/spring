package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);

}
