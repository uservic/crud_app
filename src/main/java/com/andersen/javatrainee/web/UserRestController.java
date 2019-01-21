package com.andersen.javatrainee.web;

import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    private Repository<User> repository;

    @Autowired
    public UserRestController(Repository<User> repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        user.setRole(new Role(1,"NewRole", 1));
        return repository.save(user);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return repository.get(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user, @PathVariable("id") int id) {
        Role role = repository.get(id).getRole();
        user.setId(id);
        user.setRole(role);
        repository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return repository.getAll();
    }

}