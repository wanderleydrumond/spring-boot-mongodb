package com.drumond.workshopmongo.domain;

import com.drumond.workshopmongo.dto.AuthorDTO;
import com.drumond.workshopmongo.dto.CommentDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
//@RequiredArgsConstructor(onConstructor_= {@Id})
@EqualsAndHashCode(callSuper = false, of = {"id", "date", "title", "body", "author"})
@Getter
@Setter
public class Post implements Serializable {
    /**
     * Post id
     */
    @Id
//    @NonNull //with problems
    private String id;
    /**
     * Post date
     */
//    @NonNull
    private Date date;
    /**
     * Post title
     */
//    @NonNull
    private String title;
    /**
     * Post content
     */
//    @NonNull
    private String body;
    /**
     * Object which contains post author
     */
//    @NonNull
    private AuthorDTO author;

    /**
     * Comments list from this post
     */
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}