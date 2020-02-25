package com.benyamephrem.course;

import com.benyamephrem.core.BaseEntity;
import com.benyamephrem.review.Review;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity{

    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    private String url;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL) //Connects Course & Review, when course deleted - reviews for that course are deleted as well
    private List<Review> reviews; //One course to many review

    protected Course(){
        super();
        reviews = new ArrayList<>();
    } //JPA still requires that we use at least an empty constructor here

    public Course(String title, String url) {
        this(); //Calls above constructor super'ed to BaseEntity which sets ID to null since it'll be handled by JPA, not by us.
        this.title = title;
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        review.setCourse(this);
        reviews.add(review);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
