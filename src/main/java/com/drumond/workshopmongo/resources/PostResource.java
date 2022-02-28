package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.Post;
import com.drumond.workshopmongo.resources.util.URL;
import com.drumond.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Gets a list of post that contains the given text on its title.
     *
     * @param text The text to be searched on posts
     * @return The posts list which contains the text in its title along with the HTTP response conde 200
     */
    @RequestMapping(value = "/title-search", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPostByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParameter(text);
        List<Post> posts = postService.findPostByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}