package com.assignment.commentapplication.controller;

import com.assignment.commentapplication.DTO.ResponseDTO;
import com.assignment.commentapplication.model.Comment;
import com.assignment.commentapplication.service.CommentResponseConverter;
import com.assignment.commentapplication.service.CommentService;
import com.assignment.commentapplication.utility.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This is CommentController controller.
 * @author Karan
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    /**
     * commentService field.
     */
    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentService commentService;

    /**
     * commentResponseConverter field.
     */
    @Autowired
    @Qualifier("commentResponseConverterImpl")
    private CommentResponseConverter commentResponseConverter;

    /**
     * This is saveComment post mapping.
     * @param comment field.
     * @param commentId field.
     * @return responseDTO.
     */
    @ApiOperation(value = "Comment is created successfully", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = Constants.COMMENT_CREATED),
            @ApiResponse(code = 403, message = Constants.FORBIDDEN),
            @ApiResponse(code = 400, message = Constants.BAD_REQUEST)
    }
    )
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveComment(@RequestBody final Comment comment,
                                                   @RequestParam(value = "comment_id", required = false) Long commentId){
        final ResponseDTO responseDTO = commentResponseConverter
                .createResponseStructure(commentService
                        .createComment(comment, commentId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * This is fetchAllComments get mapping.
     * @return responseDTO.
     */
    @ApiOperation(value = "Fetch All Comments", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constants.FETCH_COMMENTS_SUCCESS),
            @ApiResponse(code = 403, message = Constants.FORBIDDEN),
            @ApiResponse(code = 400, message = Constants.BAD_REQUEST)
    }
    )
    @GetMapping
    public ResponseEntity<ResponseDTO> fetchAllComments(){

        final ResponseDTO responseDTO = commentResponseConverter
                .createResponseStructureForAllComments(commentService
                        .fetchComments());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * This is fetchCommentsByCommentId method.
     * @param commentId field.
     * @return responseDTO.
     */

    @ApiOperation(value = "Get all comments referenced with a comment id", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constants.FETCH_COMMENTS_SUCCESS),
            @ApiResponse(code = 403, message = Constants.FORBIDDEN),
            @ApiResponse(code = 400, message = Constants.BAD_REQUEST)
    }
    )
    @GetMapping("fetch/comment")
    public ResponseEntity<ResponseDTO> fetchCommentsByCommentId(@RequestParam(value = "comment_id", required = false) Long commentId){

        final ResponseDTO responseDTO = commentResponseConverter
                .createResponseStructure(commentService
                        .fetchAllCommentsByParentId(commentId));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
