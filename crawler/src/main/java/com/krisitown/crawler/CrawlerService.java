package com.krisitown.crawler;

import com.krisitown.crawler.model.Article;
import com.krisitown.crawler.model.NewsSource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CrawlerService {
    @Autowired
    private DatabaseService databaseService;

    private Set<String> crawledUrls = new HashSet<>();

    @PostConstruct
    public void init(){
        while(true){
            try {
                crawlCycle();
                Thread.sleep(3000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void crawlCycle(){
        List<NewsSource> sources = databaseService.getNewsSources();

        for(NewsSource source : sources){
            Set<String> links = getArticleLinks(source.getLink(), source.getLinkSelector());
            for(String link : links){
                if(crawledUrls.contains(link)){
                    continue;
                }
                crawledUrls.add(link);

                Document document = getHtmlDocument(link);
                if(document == null){
                    continue;
                }

                Article article = parseArticle(document, source);
                if(article == null){
                    continue;
                }

                databaseService.saveArticle(article);
            }
        }
    }

    private Article parseArticle(Document document, NewsSource source){
        Article article = new Article();
        article.setNewsSource(source);

        Element titleElement = document.selectFirst(source.getTitleSelector());
        if(titleElement == null){
            return null;
        }
        article.setTitle(titleElement.text());

        Element imageElement = document.selectFirst(source.getImageSelector());
        if(imageElement == null){
            return null;
        }
        article.setImage(titleElement.attr("src"));

        Elements contentElements = document.select(source.getContentSelector());
        if(contentElements == null){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        contentElements.forEach(x -> stringBuilder.append("<p>" + x.text() + "</p>"));
        article.setContent(stringBuilder.toString());

        return article;
    }

    private Set<String> getArticleLinks(String location, String selector){
        Set<String> links = new HashSet<>();
        Document document = getHtmlDocument(location);
        Elements elements =  document.select(selector);
        if(elements != null){
            elements.stream().forEach(x -> links.add(x.attr("abs:href")));
        }
        return links;
    }

    private Document getHtmlDocument(String location){
        System.out.println("Getting html of: " + location);
        Document doc = null;
        try {
            doc = Jsoup.connect(location).get();
        } catch (IOException e){
            e.printStackTrace();
        }
        return doc;
    }
}
