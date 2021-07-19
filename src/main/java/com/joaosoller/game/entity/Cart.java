package com.joaosoller.game.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Users usu;
	@OneToMany
	private List<Product> listprodutos;
	private float price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private float shipping;
	
	public Users getUsu() {
		return usu;
	}
	public void setUsu(Users usu) {
		this.usu = usu;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getShipping() {
		return shipping;
	}
	public void setShipping(float shipping) {
		this.shipping = shipping;
	}
	public Cart(long id,Users usu, float price, float shipping) {
		super();
		this.id = id;
		this.usu = usu;
		this.price = price;
		this.shipping = shipping;
	}
	
	public Cart() {
		super();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		return true;
	}
	
	public Product pertence (Product p)
	{
		if(listprodutos.contains(p))
			return  listprodutos.get(listprodutos.indexOf(p));		
		return null;
	}
	public void addProduto(Product produto)
	{
		Product p = pertence(produto);
		if(p!=null)
			listprodutos.get(listprodutos.indexOf(p)).setQuantidade(p.getQuantidade()+1);
		else
			listprodutos.add(produto);
	}
	public void removeProduto(Product produto)
	{
		Product p = pertence(produto);
		if(p.getQuantidade()>0 )
			listprodutos.get(listprodutos.indexOf(p)).setQuantidade(p.getQuantidade()-1);
		else
			listprodutos.remove(produto);
		
	}
}
