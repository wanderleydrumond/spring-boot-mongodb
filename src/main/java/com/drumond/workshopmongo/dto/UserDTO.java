package com.drumond.workshopmongo.dto;

import com.drumond.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;

    public UserDTO(@NotNull Optional<User> user) {
        id = user.get().getId();
        name = user.get().getName();
        email = user.get().getEmail();
    }
}