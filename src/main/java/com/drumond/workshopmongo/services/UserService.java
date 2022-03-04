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

/**
 * Implements the CRUD methods for users
 */
@Service
public class UserService {
    /**
     * Dependency Injection to access CRUD methods
     */
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
     * Delete a given user.
     *
     * @param id The id from the user to be deleted
     */
    public void deleteUser(String id) {
        findUserById(id);
        userRepository.deleteById(id);
    }

    /**
     * Finds a given user and update all their
     *
     * @param userObject The user object to be updated
     * @return The updated user
     */
    public User updateUser(@NotNull User userObject) {
        User newUser = findUserById(userObject.getId());
        updateData(newUser, userObject);
        return userRepository.save(newUser);
    }

    /**
     * Updates all the data from a given user
     *
     * @param newUser The user object that will receive the changes
     * @param userObject The user object that will provide the data to be updated
     */
    private void updateData(@NotNull User newUser, @NotNull User userObject) {
        newUser.setName(userObject.getName());
        newUser.setEmail(userObject.getEmail());
    }

    /**
     * DTO factory.
     *
     * @param userDTO The given user DTO
     * @return A new DTO from user
     */
    public User fromDTO(@NotNull UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail());
    }
}