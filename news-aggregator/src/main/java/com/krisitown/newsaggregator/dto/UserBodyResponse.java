package com.krisitown.newsaggregator.dto;

import lombok.Data;

@Data
public class UserBodyResponse {
    private String name;
    private String email;
    private String token;
}
