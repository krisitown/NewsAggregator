package com.krisitown.newsaggregator.repositories;

import com.krisitown.newsaggregator.models.NewsSource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsSourcesRepository extends CrudRepository<NewsSource, Long> {
    List<NewsSource> findAll();
}
