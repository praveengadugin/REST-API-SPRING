package com.benyamephrem.core;

import com.benyamephrem.user.DetailsService;
import com.benyamephrem.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //Let Spring security know that we are Overriding the custom configurations
@EnableGlobalMethodSecurity(prePostEnabled = true)//Allows us to secure our methods
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    DetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(User.PASSWORD_ENCODER); //Sets password encoder
    }

    //This is kept friendly but DO NOT RUN THIS ON PRODUCTION
    //This implementation is SUPER LIGHTWEIGHT...no bueno for publishing
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest().authenticated() //any request must be authenticated
                .and()
                    .httpBasic()
                .and()
                    .csrf().disable(); //NEVER DO THIS IN PRODUCTION
    }
}
