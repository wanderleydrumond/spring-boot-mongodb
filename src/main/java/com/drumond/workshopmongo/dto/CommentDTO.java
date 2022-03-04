package com.drumond.workshopmongo.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Comment DTO
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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