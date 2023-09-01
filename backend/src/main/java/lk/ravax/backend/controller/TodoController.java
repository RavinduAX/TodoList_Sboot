package lk.ravax.backend.controller;

import lk.ravax.backend.dto.TodoDto;
import lk.ravax.backend.service.TodoService;
import lk.ravax.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/")
    public ResponseUtil addTodo(@RequestBody TodoDto dto){
        todoService.addTodo(dto);
        return new ResponseUtil("200", "Student Added", null);
    }
}
