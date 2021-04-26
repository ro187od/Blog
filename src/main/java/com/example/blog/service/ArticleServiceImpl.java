package com.example.blog.service;

import com.example.blog.Repo.ArticlesRepo;
import com.example.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticlesRepo articlesRepo;

    @Override
    public Iterable<Article> findAll() {
        return articlesRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        articlesRepo.deleteById(id);
    }

    @Override
    public void save(String text) {
        Article article = new Article(text);
        article.setCreationData(LocalDateTime.now());
        articlesRepo.save(article);
    }

}
