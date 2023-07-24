package com.ar.sgeservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.sgeservice.model.User;
import com.ar.sgeservice.service.UserService;

@RestController
@RequestMapping("/sge")
public class UserController {
	
	private final UserService service;
	
	public UserController (UserService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public List<User> todo(){
		return service.allUsers();
	}
	
	@GetMapping("buscar/{id}")
	public User search(@PathVariable Long id) {
		return service.searchUser(id);
	}
	
	@PostMapping("/crear")
	public User crear (@RequestBody User us) {
		return service.newUser(us);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<User> update (@PathVariable Long id ,@RequestBody User us) {
		User user = service.updateUser(id, us);
		if(user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("borrar/{id}")
	public void delete(@PathVariable Long id){
		service.deleteUser(id);
	}
}
