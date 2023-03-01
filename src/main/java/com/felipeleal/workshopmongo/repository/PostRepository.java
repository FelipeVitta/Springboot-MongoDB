package com.felipeleal.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipeleal.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
