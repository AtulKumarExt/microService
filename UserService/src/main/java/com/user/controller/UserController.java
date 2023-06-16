package com.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entities.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User user1=userService.addUser(user);
		return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod="ratingHotelFallBack")
	public ResponseEntity<Object> findById(@PathVariable String userId){
		User user=userService.findById(userId);
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> findAllBooks(){
		List<User> users=userService.getAllUsers();
		return new ResponseEntity<Object>(users, HttpStatus.OK);
	}
	
	//creating fall back method
	public ResponseEntity<Object> ratingHotelFallBack(String id, Exception ex){
		log.info("fallback is executed ", ex.getMessage());
		User user = User.builder().userId("user id").email("himanshu@gmail.com").about("htis is user").build();
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
}
