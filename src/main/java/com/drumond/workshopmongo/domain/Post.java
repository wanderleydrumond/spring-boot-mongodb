package com.drumond.workshopmongo.domain;

import com.drumond.workshopmongo.dto.AuthorDTO;
import com.drumond.workshopmongo.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Post Entity
 */
@Document
@NoArgsConstructor
//@AllArgsConstructor // used only for unit tests
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id", "date", "title", "body", "author"})
@Getter
@Setter
public class Post implements Serializable {
    /**
     * Post id
     */
    @Id
    private String id;
    /**
     * Post date
     */
    @NonNull
    private Date date;
    /**
     * Post title
     */
    @NonNull
    private String title;
    /**
     * Post content
     */
    @NonNull
    private String body;
    /**
     * Object which contains post author
     */
    @NonNull
    private AuthorDTO author;

    /**
     * Comments list from this post
     */
    private List<CommentDTO> comments = new ArrayList<>();

    /**
     * Custom constructor method used only for unit tests
     *
     * @param id Post id
     * @param date Post date
     * @param title Post title
     * @param body post content
     * @param author DTO from the user object
     */
    public Post(String id, @NonNull Date date, @NonNull String title, @NonNull String body, @NonNull AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}