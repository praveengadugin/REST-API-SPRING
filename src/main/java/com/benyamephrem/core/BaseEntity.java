package com.benyamephrem.core;

import javax.persistence.*;

//This class can't be created. ONLY extended through inheritance.
@MappedSuperclass //Now we can use this with our other entities to prevent code duplication.
                  // (Inheritance), children get variables and constructors so they just need to extend
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    @Version //For API versioning, sets request headers with ETag attribute. Saves API calls so people know when data's changed.
             //Provides for safe versioning. Ex: If app updates to 2 and web app tries to update 1...it needs to update 2 so this checks for that
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
