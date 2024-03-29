package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.services.UserService;
import com.example.user.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String hello() {
		return "this is page";
	}
	
	@GetMapping("/saveuser")
	public String saveuser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {
		User user = new User(username,firstname,lastname,age,password);
		userservice.SaveMyUser(user);
		return "user saved";
	}

}
