package com.drumond.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(textDate);
        } catch (ParseException parseException) {
//            parseException.printStackTrace();
            return defaultValue;
        }
    }
}