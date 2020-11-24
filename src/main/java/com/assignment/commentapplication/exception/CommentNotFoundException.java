package com.assignment.commentapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is custom exception class.
 * @author Karan
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(String exception) {
        super(exception);
    }
}
