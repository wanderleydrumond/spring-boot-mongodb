package com.drumond.workshopmongo.repository;

import com.drumond.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Contains the signature methods to be implemented by Service classes related to posts
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);

    /**
     * Finds a given text on all posts titles. Originated from mongodb library.
     *
     * @param text The text to be searched
     * @return The posts list which contains that text on the title
     */
    List<Post> findByTitleContainingIgnoreCase(String text);
}