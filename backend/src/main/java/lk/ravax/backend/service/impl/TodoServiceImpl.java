package lk.ravax.backend.service.impl;

import lk.ravax.backend.dto.TodoDto;
import lk.ravax.backend.entity.Todo;
import lk.ravax.backend.repo.TodoRepo;
import lk.ravax.backend.service.TodoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addTodo(TodoDto dto) {
        try {
            if (repo.existsById(dto.getId())) {
                throw new RuntimeException("Student" + dto.getId() + " Already Exists");
            }
            repo.save(mapper.map(dto, Todo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<TodoDto> getAllTodo() {
        try {
            List<Todo> list = repo.findAll();
            return mapper.map(list, new TypeToken<ArrayList<TodoDto>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void deleteTodo(int id) {
        try {
            if (!repo.existsById(id)) {
                throw new RuntimeException("Student Not Exists");
            }
            repo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTodo(int id, TodoDto dto) {
        try {
            if (!repo.existsById(id)) {
                throw new RuntimeException("Student Not Exists To Update");
            }
            repo.save(mapper.map(dto, Todo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
