package com.drumond.workshopmongo.repository;

import com.drumond.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    /**
     * Finds a given text in the post title or body in a given timestamp.
     *
     * @param text        The text to be searched
     * @param minimumDate The beginning date
     * @param maximumDate The ending date
     * @return The posts list which contains that text in the tile or in the body
     */
    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minimumDate, Date maximumDate);
//    https://docs.mongodb.com/manual/reference/operator/query/or/#mongodb-query-op.-or
}