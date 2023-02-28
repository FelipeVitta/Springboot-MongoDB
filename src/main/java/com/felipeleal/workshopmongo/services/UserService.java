package com.felipeleal.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeleal.workshopmongo.domain.User;
import com.felipeleal.workshopmongo.dto.UserDTO;
import com.felipeleal.workshopmongo.repository.UserRepository;
import com.felipeleal.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired  //instanciar automaticamente
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();		
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		//primeiro buscando pra ver se existe, se nao existir vai lançar a excessao
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObj = userRepository.findById(obj.getId());
		if(newObj.isPresent()) {
			return userRepository.save(updateData(obj, newObj.get()));
		}
		throw new ObjectNotFoundException("Objeto não existe");
	}
	
	private User updateData(User obj, User newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		return newObj;
	}

	//caminho inverso do UserDTO
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
