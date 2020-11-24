package com.assignment.commentapplication.exception.handler;

import com.assignment.commentapplication.DTO.ErrorResponseDTO;
import com.assignment.commentapplication.exception.BlankCommentException;
import com.assignment.commentapplication.exception.CommentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Global controller for exception handling.
 * @author Karan
 */

@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This is handleAllExceptions method.
     * @param ex ex
     * @return object
     */

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        final List<String> details = new ArrayList<>();
        details.add(ex.toString());
        final ErrorResponseDTO error = new ErrorResponseDTO("Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * This is handleCommentNotFoundException method.
     * @param ex ex
     * @return object
     */

    @ExceptionHandler(CommentNotFoundException.class)
    public final ResponseEntity<Object> handleCommentNotFoundException(CommentNotFoundException ex) {
        final List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        final ErrorResponseDTO error = new ErrorResponseDTO("Invalid request", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This is handleBlankCommentException method.
     * @param ex ex
     * @return object
     */

    @ExceptionHandler(BlankCommentException.class)
    public final ResponseEntity<Object> handleBlankCommentException(BlankCommentException ex) {
        final List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        final ErrorResponseDTO error = new ErrorResponseDTO("Invalid request", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
