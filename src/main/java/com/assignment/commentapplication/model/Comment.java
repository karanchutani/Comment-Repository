package com.assignment.commentapplication.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "comment")
public class Comment extends AuditModel {

    @Column(name = "message")
    private String comment;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> childComments = new ArrayList<>();

    public List<Comment> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<Comment> childComments) {
        this.childComments = childComments;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(comment, comment1.comment) &&
                Objects.equals(childComments, comment1.childComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, childComments);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                ", childComments=" + childComments +
                '}';
    }
}
