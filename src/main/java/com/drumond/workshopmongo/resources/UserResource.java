package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User mary = new User("1", "Mary Brown", "maria@email.com");
        User alex = new User("2", "Alex Green", "alex@email.com");
        List<User> users = new ArrayList<>(Arrays.asList(mary, alex));
        return ResponseEntity.ok().body(users);
    }
}