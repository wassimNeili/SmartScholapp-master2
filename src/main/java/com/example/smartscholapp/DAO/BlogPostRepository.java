package com.example.smartscholapp.DAO;

import com.example.smartscholapp.Model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    // Add any additional query methods if needed
}

