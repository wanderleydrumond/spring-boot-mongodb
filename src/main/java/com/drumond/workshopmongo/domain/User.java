package com.drumond.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User Entity
 */
@Document(collection = "user") // Optional. It works to change the document (table) name.
@NoArgsConstructor
@RequiredArgsConstructor
public @Data class User implements Serializable {
    /**
     * User id in the mongodb
     */
    @Id
    private String id;
    /**
     * Username in the mongodb
     */
    @NonNull
    private String name;
    /**
     * User email in the mongodb
     */
    @NonNull
    private String email;
    /**
     * Users posts list
     */
    @DBRef(lazy = true) // Only instantiated if made it directly.
    private List<Post> posts = new ArrayList<>();

    /**
     * Constructor method made only for unit tests (UserRepositoryTest).
     *
     * @param id The user id
     * @param name The username
     * @param email The user e-mail
     */
    public User(String id, @NonNull String name, @NonNull String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}