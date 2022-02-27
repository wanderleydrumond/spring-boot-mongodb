package com.drumond.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * User Entity
 */
@Document(collection = "user") //Opcional. Serve para mudar o nome do documento (tabela).
@NoArgsConstructor
@AllArgsConstructor
public @Data class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
}