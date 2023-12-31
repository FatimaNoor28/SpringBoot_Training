package org.example.news;
//package io.github.merite.training.news;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class NewsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {

        this.repository = repository;
    }

    public List<News> findAll() {
        logger.debug("findAll");
        return repository.findAll();
    }

    public Optional<News> findById(Long id) {
        logger.info("findById: {}" ,id);
        return repository.findById(id);
    }

    public News create(News news) {
        if (news.getId() != null && repository.existsById(news.getId())) {
            logger.warn("News already exist {}", news.getId());
            return null;
        }
        news.setId(System.currentTimeMillis());
        news.setReportedAt(LocalDateTime.now());
        return repository.save(news);
    }

    public Optional<Void> delete(News news){
        if (news.getId() != null && repository.existsById(news.getId())) {
            repository.delete(news);
            return Optional.empty();
        }

        return null;
    }

    public Optional<Void> update(Long id, News news) {
        if (news.getId() != null && repository.existsById(news.getId())) {
            Optional<News> FoundNews = repository.findById(id);
            News newNews = FoundNews.get();
            newNews.setDetails(news.getDetails());
            newNews.setTags(news.getTags());
            newNews.setTitle(news.getTitle());
            newNews.setReportedAt(news.getReportedAt());
            repository.save(newNews);
            return Optional.empty();
        }
        return null;
    }
}
