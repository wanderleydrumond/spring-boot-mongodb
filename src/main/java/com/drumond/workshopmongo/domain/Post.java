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
    /**
     * Post id
     */
    @Id
    private String id;
    /**
     * Post date
     */
    private Date date;
    /**
     * Post title
     */
    private String title;
    /**
     * Post content
     */
    private String body;
    /**
     * Object which contains post author
     */
    private AuthorDTO author;
}