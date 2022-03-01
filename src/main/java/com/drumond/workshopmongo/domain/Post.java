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
}