package com.drumond.workshopmongo.dto;

import com.drumond.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * User DTO
 */
@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {
    /**
     * User id
     */
    String id;
    /**
     * User name
     */
    String name;

    /**
     * Constructor method which gets the given user object
     *
     * @param userObject The already instantiated user object
     */
    public AuthorDTO(@NotNull User userObject) {
        id = userObject.getId();
        name = userObject.getName();
    }
}