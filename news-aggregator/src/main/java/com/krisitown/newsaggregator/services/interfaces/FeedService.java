package com.krisitown.newsaggregator.services.interfaces;

import com.krisitown.newsaggregator.models.Feed;

import java.util.List;

public interface FeedService {
    Feed persist(Feed feed);
    List<Feed> getUserFeeds(String token);
    Feed delete(Long id);
    Feed getFeed(Long id);
}
