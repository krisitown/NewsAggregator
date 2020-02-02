package com.krisitown.newsaggregator.services;

import com.krisitown.newsaggregator.models.Feed;
import com.krisitown.newsaggregator.models.User;
import com.krisitown.newsaggregator.repositories.FeedRepository;
import com.krisitown.newsaggregator.repositories.UsersRepository;
import com.krisitown.newsaggregator.services.interfaces.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private UsersRepository usersRepository;

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
    public Feed delete(Long id) {
        Feed feed = feedRepository.findById(id).get();
        feedRepository.deleteById(id);
        return feed;
    }
}
