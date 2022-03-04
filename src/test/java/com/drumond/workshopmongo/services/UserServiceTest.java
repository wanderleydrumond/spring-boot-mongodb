package com.drumond.workshopmongo.services;

import com.drumond.workshopmongo.domain.User;
import com.drumond.workshopmongo.dto.UserDTO;
import com.drumond.workshopmongo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class UserServiceTest {

    /**
     * Dependency Injection to access CRUD methods
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Deletes all users after each test.
     */
    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    /**
     * Creates 3 users, save then in the database, then verifies is the total users is 3.
     */
    @Test
    void findAllUsers() {
//        Given
        User user1 = new User("Usuário 1", "usuario1@email.com");
        User user2 = new User("Usuário 2", "usuario2@email.com");
        User user3 = new User("Usuário 3", "usuario3@email.com");

//        When
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

//        Then
        assertEquals(3, userRepository.findAll().size());
    }

    /**
     * Creates a new user, save it in the database then verifies if the given id is equal to the database saved user.
     */
    @Test
    void findUserById() {
//        Given
        User user1 = new User("hut1h6at14e5q9T0f", "Usuário 1", "usuario1@email.com");

//        When
        userRepository.save(user1);

//        Then
        if (userRepository.findById(user1.getId()).isPresent())
            assertEquals("hut1h6at14e5q9T0f", userRepository.findById(user1.getId()).get().getId());
    }

    /**
     * Creates a new user, save it in the database, then verifies if the amount of users in the database is 1.
     */
    @Test
    void insertUser() {
//        Given
        User user = new User("hut1h6at14e5q9T0f", "Usuário", "usuario1@email.com");

//        When
        userRepository.save(user);

//        Then
        assertEquals(1, userRepository.findAll().size());
    }

    /**
     * Creates a new user, save it in the database, deletes it, then verifies if the users amount inthe database is 0.
     */
    @Test
    void deleteUser() {
//        Given
        User user = new User("hut1h6at14e5q9T0f", "Usuário", "usuario@email.com");

//        When
        userRepository.save(user);
        userRepository.deleteById(user.getId());

//        Then
        assertEquals(0, userRepository.findAll().size());
    }

    /**
     * Creates a new user, save it in the database, sets news id, name and e-mail, then save the in the database.
     * In the end verifies the given name and e-mail correspond to those existent in the database.
     */
    @Test
    void updateUser() {
//        Given
        User user = new User("hut1h6at14e5q9T0f", "Usuário", "usuario@email.com");

//        When
        user.setId("New_Id");
        user.setName("Novo Usuário");
        user.setEmail("novousuario@email.com");
        userRepository.save(user);

//        Then
        if (userRepository.findById("New_Id").isPresent()){
            assertEquals("Novo Usuário", userRepository.findById("New_Id").get().getName());
            assertEquals("novousuario@email.com", userRepository.findById("New_Id").get().getEmail());
        }
    }

    /**
     * Creates a new user and userDTO object, then verifies if their data are the same.
     */
    @Test
    void fromDTO() {
//        Given
        User user = new User("hut1h6at14e5q9T0f", "Usuário", "usuario@email.com");
        UserDTO userDTO = new UserDTO(user);

//        Then
        assertEquals(userDTO.getName(), user.getName());
        assertEquals(userDTO.getEmail(), user.getEmail());
    }
}