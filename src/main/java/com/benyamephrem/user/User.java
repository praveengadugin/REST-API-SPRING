package com.benyamephrem.user;

import com.benyamephrem.core.BaseEntity;
import com.benyamephrem.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends BaseEntity{

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String firstName;
    private String lastName;
    private String userName;

    @JsonIgnore //Makes sure this is NEVER shown on the API
    private String password;

    @JsonIgnore
    private String[] roles;

    protected User(){
        super();
    }

    public User(String userName, String firstName, String lastName, String password, String[] roles) {
        this(); //Calls above constructor super'ed to BaseEntity which sets ID to null since it'll be handled by JPA, not by us
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
