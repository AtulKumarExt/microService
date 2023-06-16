package com.user.service;

import java.util.List;

import com.user.entities.User;

public interface UserService {

	User addUser(User user);
	List<User> getAllUsers();
	User findById(String id);
	void delete(String id);
	User update(User user);
}
