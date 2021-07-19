package com.joaosoller.game.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaosoller.game.entity.Users;
import com.joaosoller.game.repository.UsersRepository;

@RestController
public class UsersControler {

	@Autowired
	UsersRepository repository;
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<Users> getUsersById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	@PostMapping("/users")
	public Users saveUsers(Users users)
	{
		return repository.save(users);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable Long id)
	{
		repository.deleteById(id);;
	}
	

}
