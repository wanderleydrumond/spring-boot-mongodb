package com.drumond.workshopmongo.repository;

import com.drumond.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Contains the signature methods to be implemented by Service classes
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    default Optional<User> insert(Optional<User> user) {
        return Optional.of(new User(null, "teste", "teste@email.com"));
    }
}