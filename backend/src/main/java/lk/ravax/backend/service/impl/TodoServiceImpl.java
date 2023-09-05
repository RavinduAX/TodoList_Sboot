package lk.ravax.backend.service.impl;

import lk.ravax.backend.dto.TodoDto;
import lk.ravax.backend.entity.Todo;
import lk.ravax.backend.repo.TodoRepo;
import lk.ravax.backend.service.TodoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addTodo(TodoDto dto) {
        try {
            if (repo.existTodo(dto.getId()) != null) {
                throw new RuntimeException("Student " + dto.getId() + " Already Exists");
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
    public void deleteTodo(String id) {
        try {
            if (repo.existTodo(id) == null) {
                throw new RuntimeException("Student Not Exists");
            }
            repo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTodo(String id, TodoDto dto) {
        try {
            if (repo.existTodo(id) == null) {
                throw new RuntimeException("Student Not Exists To Update");
            }
            repo.save(mapper.map(dto, Todo.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
