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

    @Min(3)
    @Max(30)
    @NonNull
    private String name;

    @Email
    @NonNull
    private String email;

    @Min(9)
    @Max(30)
    @NonNull
    private String password;
}
