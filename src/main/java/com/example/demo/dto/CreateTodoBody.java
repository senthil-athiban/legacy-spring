package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;

public class CreateTodoBody {

    @NotEmpty
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

