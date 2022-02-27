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
}