package com.krisitown.newsaggregator.services.interfaces;

import com.krisitown.newsaggregator.models.Article;
import com.krisitown.newsaggregator.models.NewsSource;

import java.util.List;

public interface ArticleService {
    Article get(Long id);
    Article persist(Article article);
    Article delete(Long id);
    List<Article> getArticlesFromSource(NewsSource newsSource);
}
