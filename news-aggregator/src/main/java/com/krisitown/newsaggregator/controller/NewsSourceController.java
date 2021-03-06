package com.krisitown.newsaggregator.controller;

import com.krisitown.newsaggregator.dto.NewsSourceCreationRequest;
import com.krisitown.newsaggregator.dto.NewsSourceEditRequest;
import com.krisitown.newsaggregator.models.NewsSource;
import com.krisitown.newsaggregator.services.interfaces.NewsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sources")
public class NewsSourceController {
    @Autowired
    private NewsSourceService newsSourceService;

    @GetMapping("/get/{sourceId}")
    public NewsSource getNewsSource(@PathVariable Long sourceId){
        return newsSourceService.getNewsSource(sourceId);
    }

    @PostMapping("/new")
    public NewsSource create(@RequestBody NewsSourceCreationRequest newsSource){
        return newsSourceService.create(newsSource);
    }

    @PutMapping("/edit")
    public NewsSource update(@RequestBody NewsSourceEditRequest newsSource){
        return newsSourceService.edit(newsSource);
    }

    @GetMapping("/index")
    public List<NewsSource> index(){
        return newsSourceService.getNewsSources();
    }

    @DeleteMapping("/delete")
    public NewsSource delete(@RequestParam Long id){
        return newsSourceService.delete(id);
    }
}
