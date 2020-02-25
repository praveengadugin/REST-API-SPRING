package com.benyamephrem.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;


@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter{

    //Get access to our global validator
    @Autowired
    private Validator validator;

    //This is a working config that will cause our validation in the entities to send back clean error messages
    //on create and save
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator); //Before a creation happens
        validatingListener.addValidator("afterSave", validator); //Before a save happens
    }
}