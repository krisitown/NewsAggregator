package com.krisitown.newsaggregator.services.interfaces;

import com.krisitown.newsaggregator.dto.NewsSourceCreationRequest;
import com.krisitown.newsaggregator.dto.NewsSourceEditRequest;
import com.krisitown.newsaggregator.models.NewsSource;
import java.util.List;

public interface NewsSourceService {
    NewsSource create(NewsSourceCreationRequest request);
    NewsSource edit(NewsSourceEditRequest editRequest);
    NewsSource persistNewsSource(NewsSource newsSource);
    NewsSource getNewsSource(Long id);
    List<NewsSource> getNewsSources();
    NewsSource delete(Long id);
}
