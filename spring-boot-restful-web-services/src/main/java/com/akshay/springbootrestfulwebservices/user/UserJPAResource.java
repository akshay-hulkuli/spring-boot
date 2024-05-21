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
import java.util.Optional;

@RestController
public class UserJPAResource {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJPAResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> getUsers() {
        return userRepository.findAll();
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

    @GetMapping(path = "/jpa/users/{id}", params = "hateoas=true")
    public EntityModel<User> getUsersWithHateoas(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @GetMapping("/jpa/users/{id}")
    public User getUsers(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    /*
        Constructs the URI of a newly created resource (in this case, a user) by appending the user's ID to the current request URI.
        Creates an HTTP response with a 201 Created status and includes the URI of the new resource in the Location header.
        This is a standard way to inform the client about the location of the newly created resource in RESTful services.
     */
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@RequestBody @Valid User user) {
        User savedUser = userRepository.saveAndFlush(user);
//        URI location = URI.create("/users/" + user.getId());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        List<Post> postList = user.getPostList();
        postRepository.deleteAll(postList);
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        return user.getPostList();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createUserPost(@PathVariable int id, @Valid @RequestBody Post post) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
