package com.drumond.workshopmongo.repository;

import com.drumond.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Contains the signature methods to be implemented by Service classes related to users
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}