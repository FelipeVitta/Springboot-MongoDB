package com.felipeleal.workshopmongo.dto;

import java.io.Serializable;

import com.felipeleal.workshopmongo.domain.User;

//Objeto que tem o papel de carregar dados das entidades de forma simples, projetando apenas os dados necessarios da entidade original
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	public String name;
	public String email;
	
	public UserDTO() {		
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
