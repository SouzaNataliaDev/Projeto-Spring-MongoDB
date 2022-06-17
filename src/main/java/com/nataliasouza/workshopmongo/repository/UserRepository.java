package com.nataliasouza.workshopmongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nataliasouza.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	List<User> findAll();

	Optional<User> findByUser(Object user);;

	List<User>  findAllByNameContainingIgnoreCase(String name);


}
