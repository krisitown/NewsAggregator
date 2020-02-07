package com.krisitown.newsaggregator.services;

import com.krisitown.newsaggregator.dto.NewsSourceCreationRequest;
import com.krisitown.newsaggregator.dto.NewsSourceEditRequest;
import com.krisitown.newsaggregator.models.NewsSource;
import com.krisitown.newsaggregator.models.User;
import com.krisitown.newsaggregator.repositories.NewsSourcesRepository;
import com.krisitown.newsaggregator.services.interfaces.NewsSourceService;
import com.krisitown.newsaggregator.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsSourceServiceImpl implements NewsSourceService {
    @Autowired
    private NewsSourcesRepository newsSourcesRepository;

    @Autowired
    private UserService userService;

    @Override
    public NewsSource create(NewsSourceCreationRequest request) {
        User user = userService.getUser(request.getUserToken());
        NewsSource newsSource = new NewsSource();
        newsSource.setLink(request.getLink());
        newsSource.setContentSelector(request.getContentSelector());
        newsSource.setLinkSelector(request.getLinkSelector());
        newsSource.setTitleSelector(request.getTitleSelector());
        newsSource.setImageSelector(request.getImageSelector());
        newsSource.setUser(user);
        newsSourcesRepository.save(newsSource);
        return newsSource;
    }

    @Override
    public NewsSource edit(NewsSourceEditRequest editRequest) {
        NewsSource source = newsSourcesRepository.findById(editRequest.getId()).get();
        source.setLinkSelector(editRequest.getLinkSelector());
        source.setLink(editRequest.getLink());
        source.setImageSelector(editRequest.getImageSelector());
        source.setContentSelector(editRequest.getContentSelector());
        source.setTitleSelector(editRequest.getTitleSelector());
        newsSourcesRepository.save(source);
        return source;
    }

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
