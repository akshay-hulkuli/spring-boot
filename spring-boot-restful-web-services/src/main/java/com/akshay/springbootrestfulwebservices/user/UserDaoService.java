package com.akshay.springbootrestfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int count = 0;
    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Anil", LocalDate.now().minusYears(21)));
        users.add(new User(3, "Akshay", LocalDate.now().minusYears(22)));
        users.add(new User(4, "Anoop", LocalDate.now().minusYears(23)));
        count += 4;
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    public User createUser(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }
}
