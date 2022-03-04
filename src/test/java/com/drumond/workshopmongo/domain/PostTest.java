package com.drumond.workshopmongo.domain;

import com.drumond.workshopmongo.dto.AuthorDTO;
import com.drumond.workshopmongo.dto.CommentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
//    Given
    User initialUser = new User("liuryzdgn238457", "Usuário", "usuario@email.com");
    AuthorDTO initialAuthorDTO = new AuthorDTO(initialUser);
    Date initialDate = new Date();
    Post post1 = new Post("lisduhtgn356245", initialDate,"Post title","Post body", initialAuthorDTO);
    CommentDTO initialCommentDTO = new CommentDTO("Comment text",new Date(),new AuthorDTO(initialUser));

    @Test
    void getId() {
//        Then
        assertEquals("lisduhtgn356245", post1.getId());
    }

    @Test
    void getDate() {
//        Then
        assertEquals(initialDate, post1.getDate());
    }

    @Test
    void getTitle() {
//        Then
        assertEquals("Post title", post1.getTitle());
    }

    @Test
    void getBody() {
//        Then
        assertEquals("Post body", post1.getBody());
    }

    @Test
    void getAuthor() {
//        Then
        assertEquals(initialAuthorDTO, post1.getAuthor());
    }

    @Test
    void getComments() {
//        When
        post1.setComments(List.of(initialCommentDTO));
//        Then
        assertEquals(1, post1.getComments().size());
    }

    @Test
    void setId() {
//        When
        initialUser.setId("New_Id");

//        Then
        assertEquals("New_Id", initialUser.getId());
    }

    @Test
    void setDate() {
//        Given
        Date date = new Date();

//        When
        post1.setDate(date);

        assertEquals(date, post1.getDate());
    }

    @Test
    void setTitle() {
//        When
        post1.setTitle("New title");

//        Then
        assertEquals("New title", post1.getTitle());
    }

    @Test
    void setBody() {
//        When
        post1.setBody("New body");

//        Then
        assertEquals("New body", post1.getBody());
    }

    @Test
    void setAuthor() {
//        Given
        AuthorDTO authorDTO = new AuthorDTO(initialUser);

//        When
        post1.setAuthor(authorDTO);

//        Then
        assertNotSame(post1.getAuthor(), initialAuthorDTO);
    }

    /**
     * Initializes a command, change its value, then assert they aren't the same instance.
     */
    @Test
    void setComments() {
//        Given
        Post post2 = new Post("lisduhtgn356245", initialDate,"Post title","Post body", initialAuthorDTO);
        CommentDTO commentDTO = new CommentDTO("Comment text",new Date(),new AuthorDTO(initialUser));

//        When
        post2.setComments(List.of(initialCommentDTO));
        post2.setComments(List.of(commentDTO));
        post2.getComments().forEach(element -> post2.setComments(List.of(commentDTO)));

//        Then
        post2.getComments().forEach(element -> assertNotSame(initialCommentDTO, element));
    }
}