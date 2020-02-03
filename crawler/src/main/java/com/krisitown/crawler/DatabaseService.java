package com.krisitown.crawler;

import com.krisitown.crawler.model.Article;
import com.krisitown.crawler.model.NewsSource;
import com.krisitown.crawler.repository.ArticleRepository;
import com.krisitown.crawler.repository.NewsSourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private NewsSourcesRepository newsSourcesRepository;

    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<NewsSource> getNewsSources(){
        return newsSourcesRepository.findAll();
    }
}
