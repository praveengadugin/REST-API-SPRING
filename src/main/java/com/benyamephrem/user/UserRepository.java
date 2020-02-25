package com.benyamephrem.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false) //Keeps API from exporting our user list for public viewing...yikes
                                          //Now the localhost:8080/api/v1/users DOES NOT EXIST...it's only a REST resource
public interface UserRepository extends CrudRepository<User, Long>{

    User findByUserName(String username);
}