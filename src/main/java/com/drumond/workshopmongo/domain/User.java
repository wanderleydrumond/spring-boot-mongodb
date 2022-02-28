package com.drumond.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public @Data class User implements Serializable {
    /**
     * User id in the mongodb
     */
    @Id
    private String id;
    /**
     * User name in the mongodb
     */
    private String name;
    /**
     * User email in the mongodb
     */
    private String email;
    /**
     * Users posts list
     */
    @DBRef(lazy = true) // Only instantiated if made it directly.
    private List<Post> posts = new ArrayList<>();

    /**
     * Constructor method that contains only the necessary fields.
     *
     * @param id The user id
     * @param name The user name
     * @param email The user email
     */
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}