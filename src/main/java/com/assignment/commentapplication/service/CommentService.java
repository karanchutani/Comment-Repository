package com.assignment.commentapplication.service;

import com.assignment.commentapplication.model.Comment;

import java.util.List;

/**
 * This is CommentService interface.
 * @author Karan
 */
public interface CommentService {

    Comment createComment(Comment comment, Long commentId);

    List<Comment> fetchComments();

    Comment fetchAllCommentsByParentId(Long commentId);
}
