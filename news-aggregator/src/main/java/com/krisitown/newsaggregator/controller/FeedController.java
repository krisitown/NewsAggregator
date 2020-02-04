package com.krisitown.newsaggregator.controller;

import com.krisitown.newsaggregator.models.Feed;
import com.krisitown.newsaggregator.services.interfaces.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {
    @Autowired
    private FeedService feedService;

    @PostMapping("/new")
    public Feed create(@RequestBody Feed feed){
        return feedService.persist(feed);
    }

    @GetMapping("/get")
    public List<Feed> getFeedsOfUser(@RequestParam String token){
        return feedService.getUserFeeds(token);
    }

    @GetMapping("/{feedId}")
    public Feed getFeed(@PathVariable Long feedId){
        return feedService.getFeed(feedId);
    }

    @PutMapping("/update")
    public Feed update(@RequestBody Feed feed){
        return feedService.persist(feed);
    }
}
