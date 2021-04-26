package com.example.blog.Repo;

import com.example.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepo extends JpaRepository<Article, Long> {

    Article findById(String id);

    void deleteById(Long id);
}
