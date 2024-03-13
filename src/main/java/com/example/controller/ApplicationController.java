package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.services.UserService;
import com.example.user.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	@PostMapping("/save-user")
	public String registeruser(@ModelAttribute User user, BindingResult bindingreuslt, HttpServletRequest request ){
		userservice.SaveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	@GetMapping("/show-users")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String showallusers(HttpServletRequest request) {
		request.setAttribute("users", userservice.showallusers());
		request.setAttribute("mode", "ALL_USERS");
		
		return "welcomepage";
	}
	@RequestMapping("/delete-user")
	public String deleteuser(@RequestParam int id, HttpServletRequest request) {
		userservice.deletemyuser(id);
		request.setAttribute("users", userservice.showallusers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	@RequestMapping("/edit-user")
	public String edituser(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("user", userservice.edituser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	@RequestMapping("/login")
	public String loginpage(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	@RequestMapping("/login-user")
	public String loginuser(@ModelAttribute User user,HttpServletRequest request ) {
		if(userservice.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			return "homepage";
		}
		else {
			request.setAttribute("error", "invalid username and password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
	}

}
