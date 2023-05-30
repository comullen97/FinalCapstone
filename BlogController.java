package com.surviving.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    private final BlogService blogService;
    private List<Blog> blogs;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
        initializeBlogs();
    }

    private void initializeBlogs() {
        blogs = new ArrayList<>();
        blogs.add(new Blog(1L, "Top Tech Gadgets", Blog.Category.TECH, 10));
        blogs.add(new Blog(2L, "Quick Healthy Dinner Ideas for 1", Blog.Category.FOOD, 20));
        blogs.add(new Blog(3L, "Life as a Digital Nomad", Blog.Category.TRAVEL, 20));
        blogs.add(new Blog(4L, "Meals under $10", Blog.Category.FOOD, 10));
        blogs.add(new Blog(5L, "What is a 401K", Blog.Category.FINANCE, 10));
        blogs.add(new Blog(6L, "How to triple your savings", Blog.Category.FINANCE, 30));
        blogs.add(new Blog(7L, "Week in Yosemite", Blog.Category.TRAVEL, 10));
        blogs.add(new Blog(8L, "Five tips to travel on a budget", Blog.Category.TRAVEL, 20));
        blogs.add(new Blog(9L, "What is new in the tech world", Blog.Category.FINANCE, 20));
        blogs.add(new Blog(10L, "Must-have content creator tech equipment", Blog.Category.TECH, 30));
    }

    @GetMapping("/")
public String home(Model model) {
    model.addAttribute("blogList", blogs);
    return "home";
}

@GetMapping("/blogs")
public String filterBlogs(@RequestParam(value = "category", required = false) String category,
                          @RequestParam(value = "readTime", required = false) Integer readTime,
                          Model model) {
    List<Blog> filteredBlogs = filterBlogsByCategoryAndReadTime(category, readTime);
    model.addAttribute("blogList", filteredBlogs);
    return "home";
}

private List<Blog> filterBlogsByCategoryAndReadTime(String category, Integer readTime) {
    List<Blog> filteredBlogs = new ArrayList<>();
    for (Blog blog : blogs) {
        if ((category == null || category.isEmpty() || category.equals(blog.getCategory().toString()))
                && (readTime == null || readTime.equals(blog.getReadTime()))) {
            filteredBlogs.add(blog);
        }
    }
    return filteredBlogs;
}
}
