package com.drumond.workshopmongo.dto;

import com.drumond.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;

    /**
     * User Entity DTO
     *
     * @param userObject The given user object
     */
    public UserDTO(@NotNull User userObject) {
        id = userObject.getId();
        name = userObject.getName();
        email = userObject.getEmail();
    }
}