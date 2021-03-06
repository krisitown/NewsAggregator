package com.krisitown.newsaggregator.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
public class NewsSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @ManyToOne
    private User user;

    public NewsSource(){}
}
