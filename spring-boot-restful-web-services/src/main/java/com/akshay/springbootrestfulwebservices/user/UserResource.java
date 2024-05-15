package com.akshay.springbootrestfulwebservices.user;

import com.akshay.springbootrestfulwebservices.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDaoService.findAll();
    }

    /*
        HATEOAS = hypermedia as the engine of Application state.
        A given website will be having data and actions to be performed on them.
        Using HATEOAS we can define what are the further actions that one can perform on retrieving data using a URL/API.
        Spring provides a starter project to easily implement HATEOAS(spring-boot-starter-hateoas).
        In order to understand this we need to understand 2 things
        1. EntityModel - wraps the returned data from a RestMapping method.
        2. WebMvcLinkBuilder -

     */

    @GetMapping(path = "/users/{id}", params = "hateoas=true")
    public EntityModel<User> getUsersWithHateoas(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
        User savedUser = userDaoService.createUser(user);
//        URI location = URI.create("/users/" + user.getId());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userDaoService.deleteById(id);
    }
}
