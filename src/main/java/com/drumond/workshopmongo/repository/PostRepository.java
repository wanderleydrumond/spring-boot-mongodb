package com.drumond.workshopmongo.repository;

import com.drumond.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Contains the signature methods to be implemented by Service classes related to posts
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}