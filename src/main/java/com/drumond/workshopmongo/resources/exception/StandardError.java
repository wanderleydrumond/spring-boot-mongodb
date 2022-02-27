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
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}