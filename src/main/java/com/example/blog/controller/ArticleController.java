package com.example.blog.controller;

import com.example.blog.Repo.ArticlesRepo;
import com.example.blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticlesRepo articlesRepo;

    @GetMapping
    public String getAllArticle(Model model){
        model.addAttribute("articles", articlesRepo.findAll());
        return "listArticles";
    }

    @PostMapping
    public String createArticle(@RequestParam String text, Model model){
        Article article = new Article(text);
        article.setCreationData(LocalDateTime.now());
        articlesRepo.save(article);
        model.addAttribute("articles", articlesRepo.findAll());
        return "listArticles";
    }

}
