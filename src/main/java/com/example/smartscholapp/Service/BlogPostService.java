package com.example.smartscholapp.Service;


import com.example.smartscholapp.Model.BlogPost;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getAllBlogPosts();

    BlogPost getBlogPostById(Long id);

    BlogPost createBlogPost(BlogPost blogPost);

    BlogPost updateBlogPost(BlogPost blogPost);

    void deleteBlogPost(Long id);

    // Add additional methods for blog post management if needed
}

