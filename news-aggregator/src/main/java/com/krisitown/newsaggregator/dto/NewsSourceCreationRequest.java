package com.krisitown.newsaggregator.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class NewsSourceCreationRequest {
    @NonNull
    private String link;

    @NonNull
    private String linkSelector;

    @NonNull
    private String titleSelector;

    @NonNull
    private String contentSelector;

    @NonNull
    private String imageSelector;

    private String userToken;
}
