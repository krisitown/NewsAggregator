package com.krisitown.newsaggregator.controller;

import com.krisitown.newsaggregator.models.Article;
import com.krisitown.newsaggregator.models.NewsSource;
import com.krisitown.newsaggregator.services.interfaces.ArticleService;
import com.krisitown.newsaggregator.services.interfaces.NewsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private NewsSourceService newsSourceService;

    @PostMapping("/new")
    public Article create(Article article){
        return articleService.persist(article);
    }

    @GetMapping("/bySource/{newsSourceId}")
    public List<Article> get(@PathVariable Long newsSourceId){
        NewsSource newsSource = newsSourceService.getNewsSource(newsSourceId);
        return articleService.getArticlesFromSource(newsSource);
    }

    @PutMapping("/update")
    public Article update(Article article){
        return articleService.persist(article);
    }

    @DeleteMapping("/delete/{articleId}")
    public Article delete(@PathVariable Long articleId){
        return articleService.delete(articleId);
    }
}
