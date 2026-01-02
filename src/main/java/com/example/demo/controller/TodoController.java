package com.example.demo.controller;

import com.example.demo.domain.Todo;
import com.example.demo.dto.CreateTodoBody;
import com.example.demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@Valid @RequestBody CreateTodoBody createTodoBody) {
        return todoService.createTodo(createTodoBody.getTitle());
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable UUID id) {
        return todoService.getTodo(id);
    }

    @GetMapping("/heartbeat")
    public String heartbeat() {
        return "OK";
    }
}
