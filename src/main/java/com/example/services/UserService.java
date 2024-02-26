package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;
import com.example.user.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	public void SaveMyUser(User user) {
		userRepository.save(user);
	}
	public List<User> showallusers() {
		List<User> users = new ArrayList<User>();
		for(User user:userRepository.findAll()) {
			users.add(user);		
			}
		return users;
	}
	public void deletemyuser(int id) {
		userRepository.deleteById(id);
	}
	public Optional<User> edituser(int id) {
		return userRepository.findById(id);
	}
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

}
