package com.felipeleal.workshopmongo.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeleal.workshopmongo.domain.Post;
import com.felipeleal.workshopmongo.repository.PostRepository;
import com.felipeleal.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired  //instanciar automaticamente
	private PostRepository postRepository;


	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		if(!post.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post.get();
	}
	

}
