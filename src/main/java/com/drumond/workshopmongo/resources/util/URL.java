package com.drumond.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    /**
     * Decodes a given text from HTML to plain text.
     *
     * @param text The text that will be decoded
     * @return The decoded plain text
     */
    public static String decodeParameter(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}