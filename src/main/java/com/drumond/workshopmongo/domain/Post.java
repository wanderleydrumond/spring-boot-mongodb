package com.drumond.workshopmongo.domain;

import com.drumond.workshopmongo.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Post Entity
 */
@Document
@NoArgsConstructor
@AllArgsConstructor
public @Data class Post implements Serializable {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}