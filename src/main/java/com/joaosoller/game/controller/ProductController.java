package com.joaosoller.game.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joaosoller.game.entity.Product;
import com.joaosoller.game.repository.ProdutoRepository;

@RestController
public class ProductController {

	@Autowired
	ProdutoRepository repository;
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProductById(@PathVariable("id") Long id) {
			return repository.findById(id);
	}
	
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product)
	{
		return repository.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteCarro(@PathVariable Long id)
	{
		repository.deleteById(id);;
	}
	
	
}
