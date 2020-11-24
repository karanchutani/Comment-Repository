package com.assignment.commentapplication.validation;

import com.assignment.commentapplication.exception.BlankCommentException;
import com.assignment.commentapplication.exception.CommentNotFoundException;
import com.assignment.commentapplication.model.Comment;
import com.assignment.commentapplication.utility.Constants;
import org.apache.commons.lang3.StringUtils;

/**
 * This is common comment validation class.
 * @author Karan
 */
public class CommentValidation {

    /**
     * This is validate method.
     * @param comment field.
     */
    public static void validate(Comment comment) {

        if(StringUtils.isBlank(comment.getComment())){
            throw new BlankCommentException(Constants.ENTER_COMMENT);
        }
    }

    /**
     * This is validateCommentId method.
     * @param commentId field.
     */
    public static void validateCommentId(Long commentId) {

        if(commentId==null){
            throw new CommentNotFoundException(Constants.ENTER_COMMENT_ID);
        }
    }
}
