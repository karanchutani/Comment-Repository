package com.assignment.commentapplication.repository;

import com.assignment.commentapplication.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT DISTINCT id FROM comment where id not in (SELECT child_comments_id FROM comment_child_comments);", nativeQuery = true)
    List<Long> fetchAllRequiredComments();
}
