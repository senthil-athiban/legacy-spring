package com.example.demo.domain;

import java.util.UUID;

public class Todo {

    private UUID id;
    private String title;
    private boolean completed;
    private int priority;

    protected Todo() {
        // required by Hibernate
    }

    public Todo(UUID id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.priority = 0;
    }

    public UUID getId() {
        return id;
    }

    // ✅ REQUIRED for HBM (property access)
    protected void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}


