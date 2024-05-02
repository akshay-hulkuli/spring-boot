package com.akshay.springbootfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static List<Todo> todos;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "Akshay", "Learn something technical everyday",
                LocalDate.of(2024, 12, 31), false));
        todos.add(new Todo(2, "Akshay", "To go gym", LocalDate.of(2024, 12, 31), false));
        todos.add(new Todo(3, "Akshay", "Learn Java", LocalDate.now(), true));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<Todo> getTodosByName(String name) {
        return todos.stream().filter(t -> t.getUserName().equals(name)).collect(Collectors.toList());
    }
}
