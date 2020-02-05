package com.krisitown.newsaggregator.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(columnDefinition = "varchar(5000)")
    private String content;

    private String image;

    private String link;

    @ManyToOne
    private NewsSource newsSource;

    public Article(){}
}
