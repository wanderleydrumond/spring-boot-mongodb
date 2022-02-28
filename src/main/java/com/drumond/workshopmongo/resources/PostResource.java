package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.Post;
import com.drumond.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements the CRUD methods
 */
@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    /**
     * Dependency Injection to access CRUD methods
     */
    @Autowired
    private PostService postService;

    /**
     * Finds one single post by the related user id.
     *
     * @param id The given id to be found
     * @return The DTO user object along with 200 HTTP code
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findPostByUserId(@PathVariable String id) {
        Post postObject = postService.findPostByUserId(id);
        return ResponseEntity.ok().body(postObject);
    }
}