package com.ar.sgeservice.service;

import java.util.List;

import com.ar.sgeservice.model.User;

public interface UserService {

	public List<User> allUsers();
	public User searchUser(Long id);
	public User newUser (User us);
	public User updateUser (Long id, User us);
	public void deleteUser (Long id);
}
