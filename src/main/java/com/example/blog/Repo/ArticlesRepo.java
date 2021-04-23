package com.example.blog.Repo;

import com.example.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepo extends JpaRepository<Article, Long> {

}
