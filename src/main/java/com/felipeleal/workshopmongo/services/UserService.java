package com.felipeleal.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeleal.workshopmongo.domain.User;
import com.felipeleal.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired  //instanciar automaticamente
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();		
	}
}
