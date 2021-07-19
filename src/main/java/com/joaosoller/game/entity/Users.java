package com.joaosoller.game.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Users {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String email;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String nome) {
	this.name = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public Users(long id, String nome, String email) {
	super();
	this.id = id;
	this.name = nome;
	this.email = email;
}
public Users()
{
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

}
