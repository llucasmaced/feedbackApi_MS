package com.llmcd.feedback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedBack {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iduser")
    private Integer iduser;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "post_id")
    private Integer postId;

    public FeedBack(Integer iduser, Integer rating, String comment, Integer postId) {
        this.iduser = iduser;
        this.rating = rating;
        this.comment = comment;
        this.postId = postId;
    }

    public FeedBack(){}

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
