package lk.ravax.backend.controller;

import lk.ravax.backend.dto.TodoDto;
import lk.ravax.backend.service.TodoService;
import lk.ravax.backend.util.ResponseUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/")
    public ResponseUtil addTodo(@RequestBody TodoDto dto) {
        todoService.addTodo(dto);
        return new ResponseUtil("200", "Student Added", null);
    }

    @GetMapping("/")
    public ResponseUtil getAllTodo() {
        ArrayList<TodoDto> list = todoService.getAllTodo();
        return new ResponseUtil("200", "Students Fetched", list);
    }

    @DeleteMapping("/{id}")
    public ResponseUtil deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return new ResponseUtil("200", "Student " + id + " Deleted", null);
    }

    @PutMapping("/{id}")
    public ResponseUtil updateTodo(@PathVariable String id, @RequestBody TodoDto dto) {
        todoService.updateTodo(id, dto);
        return new ResponseUtil("200", "Student " + id + " Updated", null);
    }

}
