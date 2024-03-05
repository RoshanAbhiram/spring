package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.repository.UserRepository;
import com.example.user.User;

@SpringBootTest
class MyApplicationTests {
	@Autowired
    UserRepository userRepository;
	
	@Test
	public void testCreate() {
		User user = new User();
		user.setId(5);
		user.setUsername("buddy");
		user.setFirstname("mra");
		user.setLastname("harry");
		user.setAge(28);
		user.setPassword("maama");
		userRepository.save(user);
		assertNotNull(userRepository.findById(5).get());
	}
	@Test
	public void testReadall() {
		List<User> list = (List<User>) userRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testbyid() {
		User user = userRepository.findById(2).get();
		assertEquals(24, user.getAge());
	}
	@Test
	public void updateit() {
		User user = userRepository.findById(5).get();
		user.setAge(30);
		userRepository.save(user);
		assertNotEquals(28, userRepository.findById(5).get().getAge());
	}
	@Test
	public void deleteit() {
		userRepository.deleteById(4);
		assertThat(userRepository.existsById(4)).isFalse();
	}
	
	
	
	
	

}
