package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.User;
import com.drumond.workshopmongo.dto.UserDTO;
import com.drumond.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implements the CRUD methods
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    /**
     * Finds all users in the database
     *
     * @return The users list along with HTTP code 200
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAllUsers();
        List<UserDTO> usersDTO = users.stream().map(element -> new UserDTO(Optional.ofNullable(element))).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    /**
     * Finds one single user by id in the database
     *
     * @param id The given id to be found
     * @return The DTO user object along with 200 HTTP code
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {
        Optional<User> userObject = userService.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(userObject));
    }

    /**
     * Inserts a new user in database
     *
     * @param userDTO DTO of user object to be created
     * @return The 201 code along with new requisition to create a new user
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        Optional<User> userObject = Optional.ofNullable(userService.fromDTO(userDTO));
        userObject = userService.insertUser(userObject);
        URI uri = new URI("localhost:8080");
        if (userObject.isPresent()) {
            uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userObject.get().getId()).toUri();
        }
        return ResponseEntity.created(uri).build();
    }
}