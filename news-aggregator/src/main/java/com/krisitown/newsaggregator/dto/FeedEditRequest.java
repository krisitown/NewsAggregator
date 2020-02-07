package com.krisitown.newsaggregator.dto;

import lombok.Data;

import java.util.List;

@Data
public class FeedEditRequest {
    private Long id;
    private String name;
    private String userToken;
    private List<Long> ids;
}
