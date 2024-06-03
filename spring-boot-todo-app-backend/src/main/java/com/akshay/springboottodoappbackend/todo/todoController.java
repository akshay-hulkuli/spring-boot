package com.akshay.springboottodoappbackend.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class todoController {

    private TodoService todoService;

    public todoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo retrieveTodoById(@PathVariable String username, @PathVariable int id) {
        return todoService.findById(id);
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable String username, @PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todoService.updateTodo(todo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping(path = "/users/{username}/todos")
    public ResponseEntity<Todo> addTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo= todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return new ResponseEntity<>(createdTodo, HttpStatus.OK);
    }
}
