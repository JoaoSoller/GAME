package com.joaosoller.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaosoller.game.entity.Product;

public interface ProdutoRepository extends JpaRepository<Product, Long>{

}
