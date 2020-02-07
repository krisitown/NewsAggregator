package com.krisitown.newsaggregator.services.interfaces;

import com.krisitown.newsaggregator.dto.FeedCreationRequest;
import com.krisitown.newsaggregator.dto.FeedEditRequest;
import com.krisitown.newsaggregator.models.Feed;

import java.util.List;

public interface FeedService {
    Feed create(FeedCreationRequest request);
    Feed persist(Feed feed);
    List<Feed> getUserFeeds(String token);
    Feed edit(FeedEditRequest feed);
    Feed delete(Long id);
    Feed getFeed(Long id);
}
