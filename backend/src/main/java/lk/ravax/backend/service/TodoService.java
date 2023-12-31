package lk.ravax.backend.service;

import lk.ravax.backend.dto.TodoDto;

import java.util.ArrayList;

public interface TodoService {
    void addTodo(TodoDto dto);

    ArrayList<TodoDto> getAllTodo();

    void deleteTodo(String id);

    void updateTodo(String id, TodoDto dto);
}
