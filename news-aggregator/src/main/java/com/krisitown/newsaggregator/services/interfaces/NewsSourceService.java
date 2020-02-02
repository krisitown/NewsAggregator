package com.krisitown.newsaggregator.services.interfaces;

import com.krisitown.newsaggregator.models.NewsSource;
import java.util.List;

public interface NewsSourceService {
    NewsSource persistNewsSource(NewsSource newsSource);
    NewsSource getNewsSource(Long id);
    List<NewsSource> getNewsSources();
    NewsSource delete(Long id);
}
