package com.benyamephrem.review;

import com.benyamephrem.core.BaseEntity;
import com.benyamephrem.course.Course;
import com.benyamephrem.user.User;

import javax.persistence.*;

@Entity
public class Review extends BaseEntity{

    private int rating;
    private String description;

    @ManyToOne
    private Course course; //Sets relationship to course saying there are many reviews per course

    @ManyToOne
    private User reviewer; //Sets relationship to user saying there can be many reviews to one user

    protected Review(){
        super();
    }

    public Review(int rating, String description) {
        this();
        this.rating = rating;
        this.description = description;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
