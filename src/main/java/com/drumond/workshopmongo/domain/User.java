package com.drumond.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@AllArgsConstructor
public @Data class User implements Serializable {
    private String id;
    private String name;
    private String email;
}