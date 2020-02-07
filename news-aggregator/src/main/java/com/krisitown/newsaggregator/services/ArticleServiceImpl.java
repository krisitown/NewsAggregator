package com.krisitown.newsaggregator.services;

import com.krisitown.newsaggregator.models.Article;
import com.krisitown.newsaggregator.models.NewsSource;
import com.krisitown.newsaggregator.repositories.ArticleRepository;
import com.krisitown.newsaggregator.services.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article get(Long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article persist(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public Article delete(Long id) {
        Article article = articleRepository.findById(id).get();
        articleRepository.deleteById(id);
        return article;
    }

    @Override
    public List<Article> getArticlesFromSource(NewsSource newsSource) {
        return articleRepository.findAllByNewsSource(newsSource);
    }
}
