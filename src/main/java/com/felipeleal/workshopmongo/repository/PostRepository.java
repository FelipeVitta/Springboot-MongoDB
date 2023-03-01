package com.felipeleal.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipeleal.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	//Query (achar por palavra no titulo)
	List<Post> findByTitleContainingIgnoreCase(String text);

}
