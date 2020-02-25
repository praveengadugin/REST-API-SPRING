package com.benyamephrem.review;

import com.benyamephrem.user.User;
import com.benyamephrem.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

//We will handle review events here and can create a whole host of tasks to run before/after creating, deleting, or updating an entity
//This is synchronous! Don't do anything too intense in here because it is in the request response loop and may delay things!!! No bueno.
//Using EventHandler classes allow you to encapsulate business logic easily for testing

@Component //So class is pucked up by component scan
@RepositoryEventHandler(Review.class) //Marks this class as the event handler for the class provided here
public class ReviewEventHandler {

    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository userRepository) {
        this.users = userRepository;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnOnLoggedInUser(Review review){
        String username = SecurityContextHolder.getContext().getAuthentication().getName(); //Get user's username
        User user = users.findByUserName(username);
        review.setReviewer(user); //Set review with the current authenticated user
    }
}
