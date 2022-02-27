package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.User;
import com.drumond.workshopmongo.dto.UserDTO;
import com.drumond.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements the CRUD methods
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    /**
     * Dependency Injection to access CRUD methods
     */
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
        List<UserDTO> usersDTO = users.stream().map(UserDTO::new).collect(Collectors.toList());
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
        User userObject = userService.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(userObject));
    }

    /**
     * Inserts a new user in database
     *
     * @param userDTO DTO of user object to be created
     * @return The 201 code along with new requisition to create a new user
     */
    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO) {
        User userObject = userService.fromDTO(userDTO);
        userObject = userService.insertUser(userObject);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userObject.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * Deletes a given user from the database.
     *
     * @param id The id from the user to be deleted
     * @return The delete response
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}