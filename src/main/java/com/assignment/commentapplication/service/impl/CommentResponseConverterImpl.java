package com.assignment.commentapplication.service.impl;

import com.assignment.commentapplication.DTO.ResponseDTO;
import com.assignment.commentapplication.model.Comment;
import com.assignment.commentapplication.service.CommentResponseConverter;
import com.assignment.commentapplication.utility.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is CommentResponseConverterImpl class.
 * @author Karan
 */
@Service("commentResponseConverterImpl")
public class CommentResponseConverterImpl implements CommentResponseConverter {

    /**
     * This is createResponseStructure method.
     * @param comment field.
     * @return responseDTO.
     */
    @Override
    public ResponseDTO createResponseStructure(final Comment comment) {

        final ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(Constants.SUCCESS);
        responseDTO.setMessage(Constants.COMMENT_CREATED);
        responseDTO.setResponse(comment);
        return responseDTO;
    }

    /**
     * This is createResponseStructureForAllComments field.
     * @param fetchComments field.
     * @return responseDTO.
     */
    @Override
    public ResponseDTO createResponseStructureForAllComments(List<Comment> fetchComments) {

        final ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus(Constants.SUCCESS);
        responseDTO.setMessage(Constants.COMMENT_RETRIEVAL_SUCCESS);
        responseDTO.setResponse(fetchComments);
        return responseDTO;
    }

}
