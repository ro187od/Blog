package com.example.blog.service;

import com.example.blog.model.Article;

public interface ArticleService {

    public Iterable<Article> findAll();

    public void remove(Long id);

    public void save(String text);
}
