package com.krisitown.crawler.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public NewsSource(){}
}
