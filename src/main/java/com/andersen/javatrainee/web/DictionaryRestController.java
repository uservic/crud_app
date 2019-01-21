package com.andersen.javatrainee.web;

import com.andersen.javatrainee.model.Dictionary;
import com.andersen.javatrainee.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/dicts")
public class DictionaryRestController {

    private Repository<Dictionary> repository;

    @Autowired
    public DictionaryRestController(Repository<Dictionary> repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Dictionary create(@RequestBody Dictionary dictionary) {
        System.out.println(dictionary);
        return repository.save(dictionary);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dictionary get(@PathVariable("id") int id) {
        return repository.get(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dictionary dictionary, @PathVariable("id") int id) {
        dictionary.setId(id);
        repository.save(dictionary);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dictionary> getAll() {
        return repository.getAll();
    }

}