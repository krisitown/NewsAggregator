package com.krisitown.newsaggregator.models;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
public class User {
    @Id
    private String token;

    @NonNull
    private String name;

    @Email
    @NonNull
    private String email;
    
    @NonNull
    private String password;

    public User(){

    }
}
