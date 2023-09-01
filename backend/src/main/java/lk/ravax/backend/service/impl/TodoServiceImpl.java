package lk.ravax.backend.service.impl;

import lk.ravax.backend.dto.TodoDto;
import lk.ravax.backend.entity.Todo;
import lk.ravax.backend.repo.TodoRepo;
import lk.ravax.backend.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addTodo(TodoDto dto) {
        try {
            if(repo.existsById(dto.getId())){
                throw new RuntimeException("Student" + dto.getId()+" Already Exists");
            }
            repo.save(mapper.map(dto, Todo.class));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
