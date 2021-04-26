package com.example.blog.controller;

import com.example.blog.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllArticle(Model model){
        model.addAttribute("articles", articleService.findAll());
        return "listArticles";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createArticle(@RequestParam String text, Model model){
        articleService.save(text);
        model.addAttribute("articles", articleService.findAll());
        return "listArticles";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable Long id){
        articleService.remove(id);
        return "redirect:/article";
    }
}
