package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.Post;
import com.drumond.workshopmongo.resources.util.URL;
import com.drumond.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Implements the CRUD methods for posts
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

    /**
     * Gets posts list which are between a timestamp and contains a given text in title, body or comment.
     *
     * @param text        The text to be searched
     * @param minimumDate The beginning search date
     * @param maximumDate The ending search date
     * @return The posts list along with the HTTP code 200
     */
    @RequestMapping(value = "/full-search", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minimumDate", defaultValue = "") String minimumDate,
                                                 @RequestParam(value = "maximumDate", defaultValue = "") String maximumDate) {
        text = URL.decodeParameter(text);
        Date minimum = URL.convertDate(minimumDate, new Date(0L));
        Date maximum = URL.convertDate(maximumDate, new Date());
        List<Post> posts = postService.fullSearch(text, minimum, maximum);
        return ResponseEntity.ok().body(posts);
    }
}