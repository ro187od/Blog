package com.example.blog.controller;

import com.example.blog.Repo.ArticlesRepo;
import com.example.blog.model.Article;
import com.example.blog.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping
    public String getAllArticle(Model model){
        model.addAttribute("articles", articleService.findAll());
        return "listArticles";
    }

    @PostMapping
    public String createArticle(@RequestParam String text, Model model){
        articleService.save(text);
        model.addAttribute("articles", articleService.findAll());
        return "listArticles";
    }

    @DeleteMapping("{id}")
    public String deleteArticle(@PathVariable long id, Model model){
        articleService.remove(id);
        return "redirect:listArticles";
    }
}
