package com.joaosoller.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaosoller.game.entity.Cart;
import com.joaosoller.game.entity.Users;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	Cart findByUsu(Users usu);
	
}
