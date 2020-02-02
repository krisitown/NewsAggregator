package com.krisitown.newsaggregator.repositories;

import com.krisitown.newsaggregator.models.Article;
import com.krisitown.newsaggregator.models.NewsSource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findAllByNewsSource(NewsSource newsSource);
}
