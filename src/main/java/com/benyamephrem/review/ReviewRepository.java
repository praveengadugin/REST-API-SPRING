package com.benyamephrem.review;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    //Only allows the an admin or a regular user to delete their OWN review. We check if review author's username == the authenticated user's username
    @Override
    //Get whatever is currently wired, find review by id (? means it's optional incase not found), getReviewer, getUsername, then check equivalence to authentication, getName
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.userName == authentication.name")
    void delete(@Param("id") Long id); //id has to be in query string now and we use the "id" value above in SpEL (Spring Expression Language)

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviewer?.userName == authentication.name") //Must use # sign when referencing param in SpEL
    void delete(@Param("review") Review entity);
}

//Instead of Crud Repository we use PagingAndSortingRepository<> to implement paging