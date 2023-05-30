package com.surviving.myproject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private List<Blog> blogs;

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Blog> getAllBlogs() {
        return blogs;
    }

    public List<Blog> filterBlogsByCategoryAndReadTime(String category, Integer readTime) {
        List<Blog> filteredBlogs = new ArrayList<>();
        for (Blog blog : blogs) {
            if ((category == null || category.equals(blog.getCategory()))
                    && (readTime == null || readTime.equals(blog.getReadTime()))) {
                filteredBlogs.add(blog);
            }
        }
        return filteredBlogs;
    }

    public Blog getBlogById(Long id) {
        for (Blog blog : blogs) {
            if (blog.getId().equals(id)) {
                return blog;
            }
        }
        return null;
    }
}
