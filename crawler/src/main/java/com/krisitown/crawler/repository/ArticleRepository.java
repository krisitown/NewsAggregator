package com.krisitown.crawler.repository;

import com.krisitown.crawler.model.Article;
import com.krisitown.crawler.model.NewsSource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findAllByNewsSource(NewsSource newsSource);
}
