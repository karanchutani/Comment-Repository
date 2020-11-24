package com.assignment.commentapplication.service.impl;

import com.assignment.commentapplication.exception.CommentNotFoundException;
import com.assignment.commentapplication.model.Comment;
import com.assignment.commentapplication.repository.CommentRepository;
import com.assignment.commentapplication.service.CommentService;
import com.assignment.commentapplication.utility.Constants;
import com.assignment.commentapplication.validation.CommentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This is CommentServiceImpl service class.
 * @author Karan
 */
@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {

    /**
     * commentRepository field.
     */
    @Autowired
    private CommentRepository commentRepository;

    /**
     * This is createComment method.
     * @param comment field.
     * @param commentId field.
     * @return comment.
     */
    @Override
    public Comment createComment(Comment comment, Long commentId) {
        CommentValidation.validate(comment);
        if(commentId==null){
            return commentRepository.save(comment);
        }
        else{
            final Optional<Comment> optionalData = commentRepository.findById(commentId);
            if(!optionalData.isPresent()){
                throw new CommentNotFoundException(Constants.COMMENT_NOT_AVAILABLE +commentId);
            }
            final Comment existingComment = optionalData.get();
            final Comment returnedComment = commentRepository.saveAndFlush(comment);
            existingComment.getChildComments().add(returnedComment);
            commentRepository.saveAndFlush(existingComment);
            return returnedComment;
        }
    }

    /**
     * This is fetchComments method.
     * @return list of comments.
     */
    @Override
    public List<Comment> fetchComments() {

        final List<Long> uniqueIds =  commentRepository.fetchAllRequiredComments();
        final List<Comment> returnedList = new ArrayList<>();
        uniqueIds.stream().forEach(id ->{
            returnedList.add(commentRepository.findById(id).get());
        });
        return returnedList;
    }

    /**
     * This is fetchAllCommentsByParentId method.
     * @param commentId field.
     * @return list of comments.
     */
    @Override
    public Comment fetchAllCommentsByParentId(Long commentId) {

        CommentValidation.validateCommentId(commentId);
        final Optional<Comment> optionalData = commentRepository.findById(commentId);
        if(optionalData.isEmpty()){
            throw new CommentNotFoundException(Constants.COMMENT_NOT_AVAILABLE+commentId);
        }
        return optionalData.get();
    }
}
