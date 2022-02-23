package com.drumond.workshopmongo.resources;

import com.drumond.workshopmongo.domain.User;
import com.drumond.workshopmongo.dto.UserDTO;
import com.drumond.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAllUsers();
        List<UserDTO> usersDTO = users.stream().map(element -> new UserDTO(Optional.ofNullable(element))).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {
        Optional<User> userObject = userService.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(userObject));
    }
}