package com.felipeleal.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipeleal.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
