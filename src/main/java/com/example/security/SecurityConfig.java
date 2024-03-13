package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder){
		UserDetails admin = User.withUsername("buddy").password(encoder.encode("maama")).roles("ADMIN").build();
		UserDetails user = User.withUsername("spring").password(encoder.encode("123456")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	//@Bean
	//public DefaultSecurityFilterChain Securityfilterchain(HttpSecurity http) throws Exception {
		//return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests.requestMatchers("/welcome").permitAll()).authorizeHttpRequests(requests -> requests.requestMatchers("/**")
              //  .authenticated()).build();
				//}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

}
