package com.benyamephrem.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    //Referred to as the rel value and query path becomes containsTitle?{title}
    @RestResource(rel = "title-contains", path = "containsTitle")
    //Takes the URI param 'title' and searches by that...all is done automatically in background
    //Ex: http://localhost:8080/courses/search/containsTitle?title=Java&page=2 (Searches for "Java" in titles and goes to page 2
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);

}

//Instead of Crud Repository we use PagingAndSortingRepository<> to implement paging