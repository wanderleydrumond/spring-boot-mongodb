package com.drumond.workshopmongo.domain;

import com.drumond.workshopmongo.dto.AuthorDTO;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User("liuryzdgn238457", "Usuário", "usuario@email.com");
    Post post = new Post(new Date(), "Post title", "Post body", new AuthorDTO(user));

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
//        Then
        assertEquals("liuryzdgn238457", user.getId());
    }

    @Test
    void getName() {
//        Then
        assertEquals("Usuário", user.getName());
    }

    @Test
    void getEmail() {
//        Then
        assertEquals("usuario@email.com", user.getEmail());
    }

    @Test
    void getPosts() {
//        When
        user.setPosts(List.of(post));

//        Then
        assertEquals(1, user.getPosts().size());
    }

    @Test
    void setId() {
//        Given
        User user = new User("Usuário", "usuario@email.com");

//        When
        user.setId("liuryzdgn238457");

//        Then
        assertEquals("liuryzdgn238457", user.getId());
    }

    @Test
    void setName() {
//        Given
        User user = new User();

//        When
        user.setName("Usuário");

//        Then
        assertEquals("Usuário", user.getName());
    }

    @Test
    void setEmail() {
//        Given
        User user = new User();

//        When
        user.setEmail("usuario@email.com");

//        Then
        assertEquals("usuario@email.com", user.getEmail());
    }

    @Test
    void setPosts() {
//        Given
        Date date = new Date();
        Post post = new Post(date, "Post title", "Post body", new AuthorDTO(user));

//        When
        user.setPosts(List.of(post));
        
//        Then
        user.getPosts().forEach(element -> {
            assertEquals("Usuário", element.getAuthor().getName());
            assertEquals("Post title", element.getTitle());
            assertEquals("Post body", element.getBody());
            assertEquals(date, element.getDate());
        });
    }

    @Test
    void testToString() {
//        Then
        assertThat(user.toString(), is("User(id=liuryzdgn238457, name=Usuário, email=usuario@email.com, posts=[])"));
    }
}