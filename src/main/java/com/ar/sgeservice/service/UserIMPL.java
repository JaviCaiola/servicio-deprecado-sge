package com.ar.sgeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ar.sgeservice.model.User;
import com.ar.sgeservice.repository.UserRepo;

@Service
public class UserIMPL implements UserService{
	
	private final UserRepo repo;
	
	public UserIMPL(UserRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<User> allUsers() {
		return repo.findAll();
	}

	@Override
	public User searchUser(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public User newUser(User us) {
		return repo.save(us);
	}

	@Override
	public User updateUser(Long id, User us) {
		User user = repo.findById(id).orElse(null);
		if(user != null) {
			user.setNombre(us.getNombre());
			user.setContraseña(user.getContraseña());
			user.setRol(us.getRol());
			return repo.save(user);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(Long id) {
		repo.deleteById(id);
	}
	
}
