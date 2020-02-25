package com.benyamephrem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //Mark this as a Spring Boot application
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//ALPS: Application Level Profile Semantics