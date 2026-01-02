package com.example.demo.service;


import com.example.demo.dao.TodoDao;
import com.example.demo.dao.TodoDaoImp;
import com.example.demo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TodoService {

    private final TodoDao todoDao = new TodoDaoImp();

    public Todo createTodo(String title) {
        Todo todo = new Todo(UUID.randomUUID(), title);
        todoDao.save(todo);
        return todo;
    }

    public Todo getTodo(UUID id) {
        return todoDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}
