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
public class AuthorDTO implements Serializable {
    String id;
    String name;

    public AuthorDTO(@NotNull User userObject) {
        id = userObject.getId();
        name = userObject.getName();
    }
}