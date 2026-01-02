package com.example.demo.dao;

import com.example.demo.domain.Todo;

import java.util.Optional;
import java.util.UUID;

public interface TodoDao {
    void save(Todo todo);
    Optional<Todo> findById(UUID id);
}
