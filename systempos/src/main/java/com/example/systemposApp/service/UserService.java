package com.example.systemposApp.service;

import com.example.systemposApp.Exception.UsernameOrldNotFound;
import com.example.systemposApp.dto.ChangePasswordForm;
import com.example.systemposApp.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrldNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
}
