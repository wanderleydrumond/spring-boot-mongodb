package com.drumond.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "user")
@AllArgsConstructor
public @Data class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
}