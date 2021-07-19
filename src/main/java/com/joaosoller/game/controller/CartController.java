package com.joaosoller.game.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaosoller.game.entity.Cart;
import com.joaosoller.game.entity.Product;
import com.joaosoller.game.entity.Users;
import com.joaosoller.game.repository.CartRepository;
import com.joaosoller.game.repository.ProdutoRepository;
import com.joaosoller.game.repository.UsersRepository;

@RestController
public class CartController {

	@Autowired
	CartRepository repository;
	@Autowired
	UsersRepository user_repository;
	@Autowired
	ProdutoRepository prod_repository;
	@GetMapping("/cart")
	public List<Cart> getAllCarts(){
		return repository.findAll();
	}
	
	@GetMapping("/cart/{id}")
	public Optional<Cart> getCart(@PathVariable("id") Long id)
	{
		return repository.findById(id);
	}

	@PostMapping("/cart/{user_id}")
	public Cart createCart(@PathVariable("user_id") Long user_id)
	{
		Cart cart = new Cart();
		Users user = user_repository.findById(user_id).get();
		cart.setUsu(user);
		return repository.save(cart);
	}
	
	@PostMapping("/cart/{usu_id}/product/{produtos_id}")
	public Cart addProduct(@PathVariable("usu_id") Long usu_id, @PathVariable("produtos_id") Long produtos_id)
	{
		 
		Users user = user_repository.findById(usu_id).get();
		Cart cart = repository.findByUsu(user);
	    Product produto = prod_repository.findById(produtos_id).get();
		cart.setShipping(cart.getShipping()+10);
		if(cart.getShipping()>250.0)
		{
			cart.setShipping(0);
		}
		cart.setPrice(cart.getPrice()+produto.getPrice());
		cart.addProduto(produto);
		return repository.save(cart);
	}
	public Cart removeProduct(@PathVariable("usu_id") Long usu_id, @PathVariable("produtos_id") Long produtos_id)
	{
		 
		Users user = user_repository.findById(usu_id).get();
		Cart cart = repository.findByUsu(user);
	    Product produto = prod_repository.findById(produtos_id).get();
		cart.setShipping(cart.getShipping()+10);
		if(cart.getShipping()>250.0)
		{
			cart.setShipping(0);
		}
		cart.setPrice(cart.getPrice()+produto.getPrice());
		cart.removeProduto(produto);
		return repository.save(cart);
	}
}
