package com.drumond.workshopmongo.services;

import com.drumond.workshopmongo.domain.User;
import com.drumond.workshopmongo.dto.UserDTO;
import com.drumond.workshopmongo.repository.UserRepository;
import com.drumond.workshopmongo.services.exception.ObjectNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * @return The repository object which contains the users list
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Finds a specific user
     *
     * @param id The given user id
     * @return The user object to be found
     */
    public User findUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
    }

    /**
     * Insert new user in the database
     *
     * @param userObject The given user object
     * @return The object which contains the user to be inserted
     */
    public User insertUser(User userObject) {
        return userRepository.insert(userObject);
    }

    /**
     * Creates a user.
     *
     * @param userDTO The given user DTO
     * @return A new DTO from user
     */
    public User fromDTO(@NotNull UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}