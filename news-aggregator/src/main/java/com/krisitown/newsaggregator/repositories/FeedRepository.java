package com.krisitown.newsaggregator.repositories;

import com.krisitown.newsaggregator.models.Feed;
import com.krisitown.newsaggregator.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed, Long> {
    List<Feed> findAllByUser(User user);
}
