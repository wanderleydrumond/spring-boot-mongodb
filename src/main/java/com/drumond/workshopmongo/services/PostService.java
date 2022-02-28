package com.drumond.workshopmongo.services;

import com.drumond.workshopmongo.domain.Post;
import com.drumond.workshopmongo.repository.PostRepository;
import com.drumond.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Post> findPostByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}