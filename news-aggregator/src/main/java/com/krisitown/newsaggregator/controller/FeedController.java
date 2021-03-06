package com.krisitown.newsaggregator.controller;

import com.krisitown.newsaggregator.dto.FeedCreationRequest;
import com.krisitown.newsaggregator.dto.FeedEditRequest;
import com.krisitown.newsaggregator.models.Feed;
import com.krisitown.newsaggregator.services.interfaces.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/feeds")
public class FeedController {
    @Autowired
    private FeedService feedService;

    @PostMapping("/new")
    public Feed create(@RequestBody FeedCreationRequest feed){
        return feedService.create(feed);
    }

    @GetMapping("/get")
    public List<Feed> getFeedsOfUser(@RequestParam String token){
        return feedService.getUserFeeds(token);
    }

    @GetMapping("/{feedId}")
    public Feed getFeed(@PathVariable Long feedId){
        return feedService.getFeed(feedId);
    }

    @PutMapping("/edit")
    public Feed update(@RequestBody FeedEditRequest feed){
        return feedService.edit(feed);
    }

    @DeleteMapping("/delete/{feedId}")
    public Feed delete(@PathVariable Long feedId){
        return feedService.delete(feedId);
    }
}
