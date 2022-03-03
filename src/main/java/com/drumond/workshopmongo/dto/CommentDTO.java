package com.drumond.workshopmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Comment DTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentDTO implements Serializable {
    /**
     * The comment content
     */
    private String text;
    /**
     * The comment date
     */
    private Date date;
    /**
     * The user who made the comment
     */
    private AuthorDTO author;
}