package com.akshay.springbootfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos;
    private static int count = 0;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "Akshay", "Learn something technical everyday",
                LocalDate.of(2024, 12, 31), false));
        todos.add(new Todo(2, "Akshay", "To go gym", LocalDate.of(2024, 12, 31), false));
        todos.add(new Todo(3, "Akshay", "Learn Java", LocalDate.now(), true));
        count += todos.size();
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<Todo> getTodosByName(String name) {
        return todos.stream().filter(t -> t.getUserName().equals(name)).collect(Collectors.toList());
    }

    public void addTodo(String name, String description, LocalDate date, boolean completed) {
        count++;
        Todo todo = new Todo(count, name, description, date, completed);
        todos.add(todo);
    }
}
