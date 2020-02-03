package com.krisitown.crawler.repository;

import com.krisitown.crawler.model.NewsSource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsSourcesRepository extends CrudRepository<NewsSource, Long> {
    List<NewsSource> findAll();
}
