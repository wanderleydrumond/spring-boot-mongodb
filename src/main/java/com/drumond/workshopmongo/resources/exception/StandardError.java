package com.drumond.workshopmongo.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Object which will treat the custom error
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    /**
     * The numeric value for the timestamp
     */
    private Long timestamp;
    /**
     * The HTTP error code
     */
    private Integer status;
    /**
     * The error title
     */
    private String error;
    /**
     * The error message
     */
    private String message;
    /**
     * The location where the error has happened
     */
    private String path;
}