package com.example.blog.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "text_article")
    @NotNull
    private String text;
    private LocalDateTime creationDate;

    public Article(){

    }
    public Article(String text) {
        this.text = text;
    }

    public void setCreationData(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
