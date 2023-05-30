package com.surviving.myproject;

public class Blog {
    private Long id;
    private String title;
    private Category category;
    private int readTime;

    public Blog(Long id, String title, Category category, int readTime) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.readTime = readTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public int getReadTime() {
        return readTime;
    }

    public enum Category {
        FINANCE,
        FOOD,
        TRAVEL,
        TECH
    }
}
