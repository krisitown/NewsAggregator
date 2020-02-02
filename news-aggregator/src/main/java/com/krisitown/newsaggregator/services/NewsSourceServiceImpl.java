package com.krisitown.newsaggregator.services;

import com.krisitown.newsaggregator.models.NewsSource;
import com.krisitown.newsaggregator.repositories.NewsSourcesRepository;
import com.krisitown.newsaggregator.services.interfaces.NewsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsSourceServiceImpl implements NewsSourceService {
    @Autowired
    private NewsSourcesRepository newsSourcesRepository;

    @Override
    public NewsSource persistNewsSource(NewsSource newsSource) {
        newsSourcesRepository.save(newsSource);
        return newsSource;
    }

    @Override
    public NewsSource getNewsSource(Long id) {
        return newsSourcesRepository.findById(id).get();
    }

    @Override
    public List<NewsSource> getNewsSources() {
        return newsSourcesRepository.findAll();
    }

    @Override
    public NewsSource delete(Long id) {
        NewsSource source = newsSourcesRepository.findById(id).get();
        newsSourcesRepository.deleteById(id);
        return source;
    }
}
