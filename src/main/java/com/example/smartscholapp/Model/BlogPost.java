package com.example.smartscholapp.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    // Other blog post properties

    // Getters and setters
}
