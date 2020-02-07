package com.krisitown.newsaggregator.services;

import com.krisitown.newsaggregator.dto.FeedCreationRequest;
import com.krisitown.newsaggregator.dto.FeedEditRequest;
import com.krisitown.newsaggregator.models.Feed;
import com.krisitown.newsaggregator.models.NewsSource;
import com.krisitown.newsaggregator.models.User;
import com.krisitown.newsaggregator.repositories.FeedRepository;
import com.krisitown.newsaggregator.repositories.NewsSourcesRepository;
import com.krisitown.newsaggregator.repositories.UsersRepository;
import com.krisitown.newsaggregator.services.interfaces.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private NewsSourcesRepository sourceRepository;

    @Override
    public Feed create(FeedCreationRequest request) {
        User user = usersRepository.findFirstByToken(request.getUserToken());
        List<NewsSource> sources = new ArrayList<>();
        for(Long id : request.getIds()){
            sources.add(sourceRepository.findById(id).get());
        }
        Feed feed = new Feed();
        feed.setName(request.getName());
        feed.setSources(sources);
        feed.setUser(user);
        feedRepository.save(feed);
        return feed;
    }

    @Override
    public Feed persist(Feed feed) {
        feedRepository.save(feed);
        return feed;
    }

    @Override
    public Feed getFeed(Long id){
        return feedRepository.findById(id).get();
    }

    @Override
    public List<Feed> getUserFeeds(String token) {
        User user = usersRepository.findById(token).get();
        return feedRepository.findAllByUser(user);
    }

    @Override
    public Feed edit(FeedEditRequest feed) {
        Feed oldFeed = feedRepository.findById(feed.getId()).get();
        oldFeed.setName(feed.getName());
        List<NewsSource> sources = new ArrayList<>();
        for(Long id : feed.getIds()){
            sources.add(sourceRepository.findById(id).get());
        }
        oldFeed.setSources(sources);
        feedRepository.save(oldFeed);
        return oldFeed;
    }

    @Override
    public Feed delete(Long id) {
        Feed feed = feedRepository.findById(id).get();
        feedRepository.deleteById(id);
        return feed;
    }
}
