package com.krisitown.newsaggregator.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany
    private List<NewsSource> sources;

    public Feed(){}
}
