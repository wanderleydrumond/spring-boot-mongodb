package com.drumond.workshopmongo.repository;

import com.drumond.workshopmongo.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Inserts a new user in the database then count how many users are.
     */
    @Test
    public void insert() {
//        Given
        User user = new User("John Yellow", "john@email.com");

//        When
        userRepository.deleteAll();
        userRepository.save(user);
        Integer countUser = userRepository.findAll().size();

//        Then
        assertEquals(1, countUser);
    }

    /**
     * Insert a new user then search for it in the database.
     */
    @Test
    public void findExistentUserById() {
//        Given
        User user = new User("gysa4u8yg12", "John Yellow", "john@email.com");

//        When
        userRepository.deleteAll();
        userRepository.save(user);
        Integer countUser = userRepository.findAll().size();

//        Then
        assertThat(user.getId(), is("gysa4u8yg12"));
        assertThat(user.getName(), is("John Yellow"));
        assertThat(user.getEmail(), is("john@email.com"));
    }

    /**
     * Insert a new user then search for non-existent id in the database.
     */
    @Test
    public void findNonExistentUserById() {
//        Given
        User user = new User("John Yellow", "john@email.com");
        Optional<User> userOptionalInitialized = Optional.of(user),
                userOptionalNonInitialized = Optional.empty();

//        When
        userRepository.deleteAll();
        userRepository.save(user);
        Integer countUser = userRepository.findAll().size();

//        Then
        assertThat(userRepository.findById("Nonexistent_id"), is(userOptionalNonInitialized));
    }

    /**
     * Inserts a new user, deletes it, then verifies if the database registries counter is 0.
     */
    @Test
    public void delete() {
//        Given
        User user = new User("John Yellow", "john@email.com");

//        When
        userRepository.save(user);

        userRepository.deleteAll();
//        userRepository.deleteById(user.getId());
        Integer countUser = userRepository.findAll().size();

//        Then
        assertEquals(0, countUser);
    }

    /**
     * Inserts a new user, updates its name and e-mail, save it in database and checks if it's having been changed.
     */
    @Test
    public void updateUser() {
//        Given
        User user = new User("gysa4u8yg12","John Yellow", "john@email.com");

//        When
        userRepository.deleteAll();
        user.setName("Jack White");
        user.setEmail("jack@email.com");
        userRepository.save(user);

//        Then
        assertEquals("Optional[User(id=gysa4u8yg12, name=Jack White, email=jack@email.com, posts=0$LazyLoadingProxy)]", userRepository.findById("gysa4u8yg12").toString());
    }
}