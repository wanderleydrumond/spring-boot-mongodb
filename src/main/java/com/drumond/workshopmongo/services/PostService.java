package com.drumond.workshopmongo.services;

import com.drumond.workshopmongo.domain.Post;
import com.drumond.workshopmongo.repository.PostRepository;
import com.drumond.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    /**
     * Dependency Injection to access CRUD methods
     */
    @Autowired
    private PostRepository postRepository;

    /**
     * Finds a specific post
     *
     * @param id The given user id
     * @return The post object to be found
     */
    public Post findPostByUserId(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    /**
     * Calls the method which finds a post by some given text.
     *
     * @param text The text that wil be searched
     * @return The posts list which contains the given text
     */
    public List<Post> findPostByTitle(String text) {
//        return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

    /**
     * Change the final date to the entire day and calls the method which perform the search.
     *
     * @param text The text which will be searched in title, body or comment
     * @param minimumDate The beginning search date
     * @param maximumDate The ending search date
     * @return The search result
     */
    public List<Post> fullSearch(String text, Date minimumDate,  Date maximumDate) {
        maximumDate = new Date(maximumDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minimumDate, maximumDate);
    }
}