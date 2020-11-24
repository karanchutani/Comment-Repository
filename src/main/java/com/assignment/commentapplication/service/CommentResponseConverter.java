package com.assignment.commentapplication.service;

import com.assignment.commentapplication.DTO.ResponseDTO;
import com.assignment.commentapplication.model.Comment;

import java.util.List;

/**
 * This is CommentResponseConverter interface.
 * @author Karan
 */
public interface CommentResponseConverter {

    ResponseDTO createResponseStructure(Comment comment);

    ResponseDTO createResponseStructureForAllComments(List<Comment> fetchComments);
}
